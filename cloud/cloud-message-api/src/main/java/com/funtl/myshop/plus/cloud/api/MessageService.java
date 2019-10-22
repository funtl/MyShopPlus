package com.funtl.myshop.plus.cloud.api;

import com.funtl.myshop.plus.cloud.dto.UmsAdminLoginLogDTO;

public interface MessageService {

    boolean sendAdminLoginLog(UmsAdminLoginLogDTO umsAdminLoginLogDTO);

}
