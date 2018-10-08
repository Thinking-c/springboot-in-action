package com.thinking.springbootincation.project.system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class TestControllerTest {

    private MockMvc mvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setupMockMvc() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getUserList() throws Exception {

        mvc.perform(get("/test/list") //调用接口地址
                //调用接口类型
                .contentType(MediaType.APPLICATION_JSON_UTF8)

                //接收的类型
                .accept(MediaType.APPLICATION_JSON))
                //判断接收到的状态是否是200
                .andExpect(status().isOk())
                //打印内容
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                //匹配返回值中的内容
                .andExpect(content().string(Matchers.containsString("admin")));
                //.andExpect(jsonPath("$.errcode", is(0)));////使用jsonPath解析返回值，判断具体的内容

    }

    @Test
    public void saveUser() throws Exception {
        mvc.perform(post("/test/save")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("userId", "11")
                .param("userName", "henry")
                .param("password", "12345")

                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(content().string(Matchers.containsString("OK")))
                .andExpect(jsonPath("$.code", is(0)));

    }

    @Test
    public void queryUser() throws Exception {
        HashMap parpams = new HashMap();
        parpams.put("id", 1);
        ObjectMapper mapper = new ObjectMapper();
        String requestJson = mapper.writeValueAsString(parpams);

        mvc.perform(post("/test/query")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(requestJson)

                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
//                .andExpect(content().string(Matchers.containsString("OK")))
//                .andExpect(jsonPath("$.code", is(0)));

    }

}