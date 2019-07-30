package com.funtl.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 个人信息参数
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-07-30 22:42:50
 * @see com.funtl.myshop.plus.business.dto
 */
@Data
public class ProfileParam implements Serializable {

    /**
     * 用户名
     */
    private String username;

}
