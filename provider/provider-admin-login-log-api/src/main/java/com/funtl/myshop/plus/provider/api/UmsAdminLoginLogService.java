package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.UmsAdminLoginLog;

/**
 * 系统登录日志服务
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-10-19 03:48:49
 * @see com.funtl.myshop.plus.provider.api
 */
public interface UmsAdminLoginLogService {

    /**
     * 新增日志
     *
     * @param umsAdminLoginLog {@link UmsAdminLoginLog}
     * @return {@code int} 大于 0 则表示添加成功
     */
    int insert(UmsAdminLoginLog umsAdminLoginLog);

}
