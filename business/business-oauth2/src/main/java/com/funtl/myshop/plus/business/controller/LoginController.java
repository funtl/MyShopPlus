package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.dto.LoginParam;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 登录管理
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-07-28 21:12:24
 * @see com.funtl.myshop.plus.business.controller
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "user")
public class LoginController {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping(value = "login")
    public ResponseResult<Map<String, Object>> login(@RequestBody LoginParam loginParam) {
        Map<String, Object> result = Maps.newHashMap();

        // 认证
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
        if (!passwordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())) {
            return new ResponseResult<Map<String, Object>>(HttpStatus.NOT_ACCEPTABLE.value(), "密码错误，请重试");
        }

        // 授权
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 令牌

        // 封装结果
        result.put("name", userDetails.getUsername());
        result.put("token", "");
        result.put("avatar", "");

        return new ResponseResult<Map<String, Object>>(20000, "登录成功", result);
    }

}
