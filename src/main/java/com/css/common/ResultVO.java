package com.css.common;

import lombok.Data;

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
@Data
public class ResultVO<T> {

    private Integer code;
    private String message;
    private T data;


    public ResultVO(T data) {
        this(ResultEnumCode.SUCCESS, data);
    }

    public ResultVO(ResultEnumCode resultCode) {
        this(resultCode, null);
    }

    public ResultVO(ResultEnumCode resultCode, T data) {
        this(resultCode.getCode(), resultCode.getMessage(), data);
    }

    public ResultVO(Integer code, String message) {
        this(code, message, null);
    }

    public ResultVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 方式2：
     * 私有构造方法，采用静态方法去生成ResultVO对象
     *
     * @return
     */

    private ResultVO() {
    }


    public static ResultVO successResultVO() {
        ResultVO vo = new ResultVO();
        vo.setCode(ResultEnumCode.SUCCESS.getCode());
        vo.setMessage(ResultEnumCode.SUCCESS.getMessage());
        return vo;
    }

    public static ResultVO errorResultVO() {
        ResultVO vo = new ResultVO();
        vo.setCode(ResultEnumCode.FAILED.getCode());
        vo.setMessage(ResultEnumCode.FAILED.getMessage());
        return vo;
    }

    public static ResultVO getReusltVO(ResultEnumCode code) {
        ResultVO vo = new ResultVO();
        vo.setCode(code.getCode());
        vo.setMessage(code.getMessage());
        return vo;
    }

    /**
     * 封装所有的属性对应的set方法，实现链式编程，设置多个属性
     *
     * @param code
     * @return
     */
    public ResultVO addCode(Integer code) {
        this.setCode(code);
        return this;
    }

    public ResultVO addMessage(String msg) {
        this.setMessage(msg);
        return this;
    }

    public ResultVO addData(T data) {
        this.setData(data);
        return this;
    }
}
