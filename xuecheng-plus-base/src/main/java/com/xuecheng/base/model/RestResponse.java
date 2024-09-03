package com.xuecheng.base.model;

import lombok.Data;
import lombok.ToString;

/**
 * @Classname RestResponse
 * @Description TODO
 * @Date 2024/9/3 21:56
 * @Created by cwl
 */
@Data
@ToString
public class RestResponse<T> {

    private int code;

    private String msg;

    private T result;

    public static <T> RestResponse<T> success(){
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.code = 0;
        restResponse.msg = "success";
        return restResponse;
    }

    public static <T> RestResponse<T> success(T object){
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.code = 0;
        restResponse.msg = "success";
        restResponse.result = object;
        return restResponse;
    }

public static <T> RestResponse<T> fail(){
    RestResponse<T> restResponse = new RestResponse<>();
    restResponse.code = -1;
    restResponse.msg = "fail";
    return restResponse;
}



    public static <T> RestResponse<T> fail(String msg){
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.code = -1;
        restResponse.msg = msg;
        return restResponse;
    }

    public static <T> RestResponse<T> fail(T object,String msg){
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.code = -1;
        restResponse.msg = msg;
        restResponse.result = object;
        return restResponse;
    }

}
