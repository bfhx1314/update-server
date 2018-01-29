package com.limn.update.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by limengnan on 2018/1/6.
 */


@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("getResults")
    @ResponseBody
    public Object getResults(HttpServletRequest request, HttpServletResponse response, String requestUrl, String responseData) throws IOException {




        return null;
    }

}
