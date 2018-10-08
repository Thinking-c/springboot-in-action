package com.chargedot.malfunction.config.dbconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author：caoj
 * @Description：
 * @Data：Created in 2018/1/4
 */
public class DataSourceContextHolder {

    private static Logger LOG = LoggerFactory.getLogger(DataSourceContextHolder.class);

    private static final ThreadLocal<String> local = new ThreadLocal<String>();

    /**
     * get ThreadLocal
     * @return
     */
    public static ThreadLocal<String> getLocal() {
        return local;
    }

    /**
     * set read database
     */
    public static void setRead(){
        local.set(DataSourceType.read.getType());
        LOG.info("----------this is read database----------");
    }

    /**
     * set write database
     */
    public static void setWrite(){
        local.set(DataSourceType.write.getType());
        LOG.info("----------this is write database----------");
    }

    /**
     * get read or write ThreadLocal
     * @return
     */
    public static String getReadOrWrite() {
        return local.get();
    }

    /**
     * remove threadLocal
     */
    public static void clear(){
        local.remove();
    }

}
