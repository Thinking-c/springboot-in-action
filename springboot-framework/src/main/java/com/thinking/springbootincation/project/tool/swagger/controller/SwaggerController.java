package com.thinking.springbootincation.project.tool.swagger.controller;

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
 * @Date：Created in 2018/7/5
 */
@Controller
@RequestMapping("/tool")
@Slf4j
public class SwaggerController {

    @ApiOperation(value = "swagger-ui", notes = "重定向到swagger2")
    @GetMapping(value = "/swagger")
    public void swaggerUi(HttpServletResponse response){
        try {
            response.sendRedirect("/swagger-ui.html");
        } catch (IOException e) {
            log.info("exception happened", e);
        }
    }


}
