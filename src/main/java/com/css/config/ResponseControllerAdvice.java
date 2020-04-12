package com.css.config;

import com.css.common.ResultVO;
import com.css.exception.APIException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

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
@RestControllerAdvice(basePackages = {"com.css.controller"})
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {

    /*
    重写的这两个方法是用来在controller将数据进行返回前进行增强操作，
    supports方法要返回为true才会执行beforeBodyWrite方法，
    所以如果有些情况不需要进行增强操作可以在supports方法里进行判断。
    对返回数据进行真正的操作还是在beforeBodyWrite方法中，
    我们可以直接在该方法里包装数据，这样就不需要每个接口都进行数据包装了，省去了很多麻烦。
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        //如果接口本身已经返回统一响应体ResultVO对象，则不用在统一封装。
        return !methodParameter.getGenericParameterType().equals(ResultVO.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (methodParameter.getGenericParameterType().equals(String.class)) {
            //如果是返回String类型不能直接包装，需要特殊处理
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在ResultVO里后，再转换为json字符串响应给前端
                //beforeBodyWrite方法里包装数据无法对String类型的数据直接进行强转，
                // 所以要进行特殊处理，这里不讲过多的细节，有兴趣可以自行深入了解。
                // beforeBodyWrite方法里包装数据无法对String类型的数据直接进行强转，
                // 所以要进行特殊处理，这里不讲过多的细节，有兴趣可以自行深入了解。
                return objectMapper.writeValueAsString(new ResultVO<>(o));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                throw new APIException(10000, e.getMessage());
            }
        }
        // 将原本的数据包装在ResultVO里
        return new ResultVO(o);
    }
}
