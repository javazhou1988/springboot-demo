package com.css.controller;

import com.css.common.ResultVO;
import com.css.model.User;
import com.css.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 周海峰
 * @version 1.0
 * @project 深圳市智能政务办公系统
 * @package zhbg.oaxt.hdxt.gwgl.domain.bo.wdclq
 * @file GwglTjBo.java 创建时间:2018年11月29日下午2:17:37
 * @title 标题（要求能简洁地表达出类的功能和职责）
 * @description 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @copyright Copyright (c) 2018 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestBody @Valid User user, BindingResult result) {
        for (ObjectError error : result.getAllErrors()) {
            return error.getDefaultMessage();
        }
        return userService.saveUser(user);
    }

    @PostMapping(value = "/addUser2")
    public String addUser2(@RequestBody @Valid User user) {
        return userService.saveUser(user);
    }

    @PostMapping(value = "/addUser3")
    public ResultVO addUser3(@RequestBody @Valid User user) {
        userService.saveUser(user);
        return new ResultVO<>(user);
    }

    @PostMapping(value = "/addUser5")
    public User addUser5(@RequestBody @Valid User user) {
        userService.saveUser(user);
        return user;
    }

    @GetMapping(value = "/searchAllUser")
    public List<User> searchAllUser() {
        /**
         * 采用通用的拦截器返回统一响应格式
         */
        return userService.searchAllUser();
    }

    @GetMapping(value = "/searchAllUser2")
    public ResultVO searchAlluser2() {
        //自定义返回标准统一格式，统一拦截器不会再处理
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("totalCount", 1000);
        resultMap.put("pages", 88);
        resultMap.put("list", userService.searchAllUser());

        ResultVO resultVO = new ResultVO(resultMap);

        return resultVO;
    }
}
