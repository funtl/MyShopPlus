package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "ums_admin")
public class UmsAdmin implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "`password`")
    private String password;

    /**
     * 头像
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 备注信息
     */
    @Column(name = "note")
    private String note;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    @Column(name = "`status`")
    private Integer status;

    private static final long serialVersionUID = 1L;
}