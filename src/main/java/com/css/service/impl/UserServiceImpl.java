package com.css.service.impl;

import com.css.exception.APIException;
import com.css.model.User;
import com.css.service.UserService;
import org.springframework.stereotype.Service;

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
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String saveUser(User user) {
        if(user.getName().equals("javazhou")){
            throw new APIException("用户名已存在。。。");
        }
        return "success:" + user;
    }
}
