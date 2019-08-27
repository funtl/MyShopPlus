package com.funtl.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员信息
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-08-28 01:01:36
 * @see com.funtl.myshop.plus.business.dto
 */
@Data
public class UmsAdminDTO implements Serializable {
    private Long id;
    private String username;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 备注信息
     */
    private String note;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后登录时间
     */
    private Date loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    private Integer status;
}
