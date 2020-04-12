package com.css.common;

import lombok.Getter;

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
@Getter
public enum ResultEnumCode {

    SUCCESS(10000, "操作成功"),
    FAILED(10001, "返回失败"),
    VALID_ERROR(10002, "参数校验错误"),

    USER_EXISTS(20001, "用户名已经存在。。。"),
    USES_STATUS(20002, "用户已发起订单，不能删除。。。"),


    NPE_ERROR(50000, "空指针异常"),
    ERROR(50001, "系统未知错误"),
    ARITHME_ERROR(500002, "算法相除错误");

    private Integer code;
    private String message;

    ResultEnumCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}
