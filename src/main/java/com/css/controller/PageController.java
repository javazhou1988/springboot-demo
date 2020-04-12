package com.css.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: javazhou
 * @Date: 2020/4/12 012
 * @Description: com.css.controller
 * @version: 1.0
 */
@Controller
public class PageController {

    @GetMapping("/{page}")
    @ResponseBody
    public String index(@PathVariable String page) {
        int i = 10 / 1;
        return page;
    }
}
