package com.xuecheng.base.exception;

/**
 * @Classname XueChengPlusException
 * @Description 自定义异常类
 * @Date 2024/8/26 17:35
 * @Created by cwl
 */
/**
 * @description 学成在线项目异常类
 */
public class XueChengPlusException extends RuntimeException {
    private String errMessage;

    public String getErrMessage() {
        return errMessage;
    }

    public XueChengPlusException() {
        super();
    }

    public XueChengPlusException(String errMessage) {
        super(errMessage);
        this.errMessage = errMessage;
    }

    public static void cast(CommonError commonError) {
        throw new XueChengPlusException(commonError.getErrMessage());
    }

    public static void cast(String errMessage) {
        throw new XueChengPlusException(errMessage);
    }
}