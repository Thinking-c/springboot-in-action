package com.thinking.springbootincation.project.monitor.druid;

import com.thinking.springbootincation.framework.web.controller.BaseController;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/24
 */
@Controller
@RequestMapping("/monitor/data")
@Slf4j
public class DruidController extends BaseController{

    private static final String prefix = "/monitor/druid";

    @ApiOperation(value = "swagger-ui", notes = "重定向到druid.html")
    @GetMapping()
    public void index(HttpServletResponse response){
        try {
            response.sendRedirect(prefix + "/index.html");
        } catch (IOException e) {
            log.info("[/monitor/data]exception happened ", e);
        }
    }

}
