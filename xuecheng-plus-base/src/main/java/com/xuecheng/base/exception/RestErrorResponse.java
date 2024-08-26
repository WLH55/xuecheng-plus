package com.xuecheng.base.exception;

import java.io.Serializable;

/**
 * @Classname RestErrorResponse
 * @Description 响应用户的统一类型
 * @Date 2024/8/26 17:40
 * @Created by cwl
 */
public class RestErrorResponse implements Serializable {
    private String errMessage;

    public RestErrorResponse(String errMessage){
        this.errMessage = errMessage;
    }

    public String getErrMessage(){
        return errMessage;
    }
    public void setErrMessage(String errMessage){
        this.errMessage = errMessage;
    }
}
