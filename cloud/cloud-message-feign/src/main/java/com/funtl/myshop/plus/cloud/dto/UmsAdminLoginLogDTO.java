package com.funtl.myshop.plus.cloud.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UmsAdminLoginLogDTO implements Serializable {
    private static final long serialVersionUID = -6610556441914830628L;
    private Long id;
    private Long adminId;
    private Date createTime;
    private String ip;
    private String address;
    private String userAgent;
}
