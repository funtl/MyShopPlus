package com.funtl.myshop.plus.cloud.feign;

import com.funtl.myshop.plus.cloud.dto.UmsAdminLoginLogDTO;
import com.funtl.myshop.plus.cloud.feign.fallback.MessageFeignFallback;
import com.funtl.myshop.plus.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "cloud-message", path = "message", configuration = FeignRequestConfiguration.class, fallback = MessageFeignFallback.class)
public interface MessageFeign {

    @PostMapping(value = "admin/login/log")
    String sendAdminLoginLog(@RequestBody UmsAdminLoginLogDTO umsAdminLoginLogDTO);

}
