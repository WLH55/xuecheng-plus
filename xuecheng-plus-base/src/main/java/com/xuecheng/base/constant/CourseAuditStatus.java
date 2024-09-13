package com.xuecheng.base.constant;

import lombok.Getter;

/**
 * @Classname CourseAuditStatus
 * @Description TODO
 * @Date 2024/9/13 18:32
 * @Created by cwl
 */
@Getter
public enum CourseAuditStatus {

    AUDIT_FAILED("202001", "审核未通过"),
    NOT_SUBMITTED("202002", "未提交"),
    SUBMITTED("202003", "已提交"),
    AUDIT_PASSED("202004", "审核通过");

    private final String code;
    private final String desc;

    CourseAuditStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
