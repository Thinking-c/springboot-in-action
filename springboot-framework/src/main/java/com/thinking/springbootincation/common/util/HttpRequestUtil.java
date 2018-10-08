package com.thinking.springbootincation.common.util;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author：caoj
 * @Description： send http request class
 * @Data：Created in 2018/2/28
 */
@Slf4j
public class HttpRequestUtil {

    /**
     * restTemplate Basic auth get token
     *
     * @param operatorId
     * @param operatorSecret
     * @param url
     * @param scope
     * @return
     */
    public static String getToken(String operatorId, String operatorSecret, String url, String scope) {
        String result = null;

        try {
            RestTemplate restTemplate = new RestTemplate(httpClientFactory());
            String auth = operatorId + ":" + operatorSecret;
            byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("UTF-8")));
            String authHeader = "Basic " + new String(encodedAuth);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.valueOf(MediaType.APPLICATION_FORM_URLENCODED_VALUE));
            httpHeaders.add("Authorization", authHeader);
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("grant_type", "client_credentials");
            if (scope.indexOf(",") > 0) {
                scope = scope.replace(",", " ");
            }
            params.add("scope", scope);
            org.springframework.http.HttpEntity<String> entity = new org.springframework.http.HttpEntity(params, httpHeaders);
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, entity, String.class);
            result = responseEntity.getBody();
        } catch (Exception e) {
            log.info("getToken method exception happened ", e);
        }
        return result;
    }

    /**
     * HttpClient Basic auth get token
     *
     * @param operatorId
     * @param operatorSecret
     * @param url
     * @param scope
     * @return
     */
    public static String getTokenResult(String operatorId, String operatorSecret, String url, String scope) {
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(operatorId, operatorSecret);
        provider.setCredentials(AuthScope.ANY, credentials);
        HttpClient client = HttpClients.custom().setDefaultCredentialsProvider(provider).build();
        HttpPost post = new HttpPost(url);
        post.setConfig(requestConfig());
        String result = null;
        if (scope.indexOf(",") > 0) {
            scope = scope.replace(",", " ");
        }
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("grant_type", "client_credentials"));
        parameters.add(new BasicNameValuePair("scope", scope));
        try {
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "UTF-8");
            post.setEntity(formEntity);
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
        } catch (ClientProtocolException e) {
            log.info("getTokenResult method exception happened {}", e);
        } catch (IOException e) {
            log.info("getTokenResult method exception happened {}", e);
        }
        return result;
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        StringBuilder jsonStr = new StringBuilder();
        BufferedReader in = null;
        try {
            String urlNameString = url + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                log.info("[sendGet][key]{}[value]{}", key, map.get(key));
            }

            //ConstantUtil.UTF_CODE 编码格式
            InputStreamReader reader = new InputStreamReader(connection.getInputStream(), "UTF-8");
            char[] buff = new char[1024];
            int length = 0;
            while ((length = reader.read(buff)) != -1) {
                result = new String(buff, 0, length);
                jsonStr.append(result);
            }

            Gson gson = new Gson();
            Map temp = gson.fromJson("", Map.class);

        } catch (Exception e) {
            log.info("sendGet method exception happened ", e);
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jsonStr.toString();
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        URLConnection conn = null;
        StringBuilder jsonStr = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            conn = realUrl.openConnection();
            conn.setConnectTimeout(20000);
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应

            InputStreamReader reader = new InputStreamReader(conn.getInputStream(), "UTF-8");
            char[] buff = new char[1024];
            int length = 0;
            while ((length = reader.read(buff)) != -1) {
                String result = new String(buff, 0, length);
                jsonStr.append(result);
            }
        } catch (Exception e) {
            log.info("sendPost method exception happened ", e);
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return jsonStr.toString();
    }

    /**
     * http request set timeout
     *
     * @return RequestConfig
     */
    public static RequestConfig requestConfig() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(30000)
                .setConnectionRequestTimeout(30000)
                .setSocketTimeout(30000)
                .build();

        return requestConfig;
    }

    /**
     * restTemplate post request set timeout
     *
     * @return
     */
    public static HttpComponentsClientHttpRequestFactory httpClientFactory() {

        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setReadTimeout(35000);
        httpRequestFactory.setConnectTimeout(35000);
        httpRequestFactory.setConnectionRequestTimeout(35000);

        return httpRequestFactory;
    }
}
