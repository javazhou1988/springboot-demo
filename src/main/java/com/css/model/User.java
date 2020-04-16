package com.css.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

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
@AllArgsConstructor
public class User {
    @NotNull(message = "id不能为空")
    @Email
    private int id;
    @NotBlank(message = "name不能为空")
    @Length(min = 6, max = 12, message = "name的长度必须为6-12")
    private String name;
    @Range(min = 10, max = 100, message = "年龄必须在10-100岁")
    private int age;
    private String address;
}
