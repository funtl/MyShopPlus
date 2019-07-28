package com.funtl.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 后台登录参数
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-07-28 21:33:20
 * @see com.funtl.myshop.plus.business.dto
 *
 */
@Data
public class LoginParam implements Serializable {

    private String username;
    private String password;

}
