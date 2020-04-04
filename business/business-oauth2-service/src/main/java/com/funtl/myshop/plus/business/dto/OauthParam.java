package com.funtl.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * token参数
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-07-29 11:13:56
 * @see com.funtl.myshop.plus.business.dto
 */
@Data
public class OauthParam implements Serializable {

    private String refresh_token;

}
