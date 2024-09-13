package com.xuecheng.base.constant;

import lombok.Data;
import lombok.Getter;

/**
 * @Classname AuditStatus
 * @Description 审核枚举类
 * @Date 2024/9/13 18:21
 * @Created by cwl
 */
@Getter
public enum AuditStatus {
    AUDIT_FAILED("002001","审核不通过"),
    AUDIT_SUCCESS("002003","审核通过"),
    NOT_AUDITED("002002","未审核");

    private final String code;
    private final String desc;

     AuditStatus(String code,String desc){
        this.code = code;
        this.desc = desc;
    }
    public String getCode(){
        return this.code;
    }
    public String getDesc(){
         return this.desc;
    }
}
