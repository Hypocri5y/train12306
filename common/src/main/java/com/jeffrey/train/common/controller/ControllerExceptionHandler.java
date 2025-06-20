package com.jeffrey.train.common.controller;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2025-06-20 21:27
 * @description:
 **/
/**
 * 统一异常处理、数据预处理等
 * @ControllerAdvice 一般和三个以下注解一块使用，实现对业务异常进行统一处理
 *
 * @ExceptionHandler: 该注解作用于方法上，，可以捕获到controller中抛出的一些自定义异常，统一进行处理，一般用于进行一些特定的异常处理。
 * @InitBinder: 该注解作用于方法上,用于将前端请求的特定类型的参数在到达controller之前进行处理，从而达到转换请求参数格式的目的。
 * @ModelAttribute： 该注解作用于方法和请求参数上，在方法上时设置一个值，可以直接在进入controller后传入该参数。
 */
import com.jeffrey.train.common.exception.BusinessException;
import com.jeffrey.train.common.exception.BusinessExceptionEnum;
import com.jeffrey.train.common.resp.CommonResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 所有异常统一处理
     *
     * @param e
     * @return
     */
    // @ExceptionHandler参数是某个异常类的class，代表这个方法专门处理该类异常，比如这样：
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResp exceptionHandler(Exception e) {
        // // 如果是在一次全局事务里出异常了，就不要包装返回值，将异常抛给调用方，让调用方回滚事务
        // if (StrUtil.isNotBlank(RootContext.getXID())) {
        //     throw e;
        // }
        CommonResp commonResp = new CommonResp();
        LOG.error("系统异常：", e);
        commonResp.setSuccess(false);
        commonResp.setMessage("系统异常，请联系管理员");
        return commonResp;
    }

    /**
     * 业务异常统一处理
     *
     * @param e
     * @return
     */
    // @ExceptionHandler参数是某个异常类的class，代表这个方法专门处理该类异常，比如这样：
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public CommonResp exceptionHandler(BusinessException e) {
        CommonResp commonResp = new CommonResp();
        LOG.error("业务异常：{}", e.getExceptionEnum().getDesc());
        commonResp.setSuccess(false);
        commonResp.setMessage(e.getExceptionEnum().getDesc());
        return commonResp;
    }
    /**
     * 业务异常统一处理
     *
     * @param e
     * @return
     */
    // @ExceptionHandler参数是某个异常类的class，代表这个方法专门处理该类异常，比如这样：
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public CommonResp exceptionHandler(BindException e) {
        CommonResp commonResp = new CommonResp();
        LOG.error("校验异常：{}", e.getBindingResult().getAllErrors().get(0));
        commonResp.setSuccess(false);
        commonResp.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return commonResp;
    }

}
