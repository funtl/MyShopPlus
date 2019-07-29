package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.dto.LoginParam;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.commons.utils.MapperUtils;
import com.funtl.myshop.plus.commons.utils.OkHttpClientUtil;
import com.google.common.collect.Maps;
import okhttp3.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 登录管理
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-07-29 11:14:58
 * @see com.funtl.myshop.plus.business.controller
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LoginController {

    private static final String URL_OAUTH_TOKEN = "http://localhost:9001/oauth/token";

    @PostMapping(value = "/user/login")
    public ResponseResult<Map<String, Object>> login(@RequestBody LoginParam loginParam) throws Exception {
        // 封装返回的结果集
        Map<String, Object> result = Maps.newHashMap();

        // 通过 HTTP 客户端请求登录接口
        Map<String, String> params = Maps.newHashMap();
        params.put("username", loginParam.getUsername());
        params.put("password", loginParam.getPassword());
        params.put("grant_type", "password");
        params.put("client_id", "client");
        params.put("client_secret", "secret");

        // 解析响应结果封装并返回
        Response response = OkHttpClientUtil.getInstance().postData(URL_OAUTH_TOKEN, params);
        String jsonString = response.body().string();
        Map<String, Object> jsonMap = MapperUtils.json2map(jsonString);
        String token = String.valueOf(jsonMap.get("access_token"));
        result.put("token", token);

        return new ResponseResult<Map<String, Object>>(20000, "登录成功", result);
    }

}
