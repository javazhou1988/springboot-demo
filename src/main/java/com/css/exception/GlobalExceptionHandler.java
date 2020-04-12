package com.css.exception;

import com.css.common.ResultEnumCode;
import com.css.common.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

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

/**
 * 注解@ControllerAdvice的类可以拥有@ExceptionHandler,
 *
 * @InitBinder或 @ModelAttribute注解的方法，并且这些方法会被应用到
 * 控制器类层次的所有@RequestMapping方法上。
 * annotations()，basePackageClasses()， basePackages()或它的别名value()
 * 可以被指定，以限定控制器，以协助的特定子集。当应用多个选择器时，应用OR逻辑 -
 * 意味着所选的控制器应匹配至少一个选择器。
 * <p>
 * 默认行为（即，如果没有任何选择器使用），带@ControllerAdvice注释的类将协助
 * 所有已知的控制器。
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //通用异常
    @ExceptionHandler({Exception.class})
    public ResultVO exceptionHandler(Exception e) {
        e.printStackTrace();//记录日志
        logger.info(e.getMessage(), e.getStackTrace());
        return new ResultVO<>(ResultEnumCode.ERROR);
    }

    //指定异常
    @ExceptionHandler({NullPointerException.class})
    public ResultVO nullPointerExceptionHandler(NullPointerException e) {
        e.printStackTrace();//记录日志
        return new ResultVO<>(ResultEnumCode.NPE_ERROR);
    }

    @ExceptionHandler({ArithmeticException.class})
    public ResultVO arithmeticExceptionHandler(ArithmeticException e) {
        e.printStackTrace();
        return new ResultVO(ResultEnumCode.ARITHME_ERROR);
    }

    //指定异常，同时需要返回具体的数据信息data
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResultVO<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        return new ResultVO<>(ResultEnumCode.VALID_ERROR, errors.get(0).getDefaultMessage());
    }


    //自定义异常
    @ExceptionHandler({APIException.class})
    public ResultVO apiExceptionHandler(APIException e) {
        return new ResultVO<>(e.getCode(), e.getMessage());
    }
}
