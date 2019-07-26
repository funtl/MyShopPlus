package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.api.UmsAdminService;
import com.funtl.myshop.plus.provider.domain.UmsAdmin;
import com.funtl.myshop.plus.provider.mapper.UmsAdminMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户管理服务
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-07-26 09:41:08
 * @see com.funtl.myshop.plus.provider.service
 */
@Service(version = "1.0.0")
public class UmsAdminServiceImpl implements UmsAdminService {

    @Resource
    private UmsAdminMapper umsAdminMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public int insert(UmsAdmin umsAdmin) {
        // 初始化用户对象
        initUmsAdmin(umsAdmin);
        return umsAdminMapper.insert(umsAdmin);
    }

    @Override
    public UmsAdmin get(String username) {
        Example example = new Example(UmsAdmin.class);
        example.createCriteria().andEqualTo("username", username);
        return umsAdminMapper.selectOneByExample(example);
    }

    @Override
    public UmsAdmin get(UmsAdmin umsAdmin) {
        return umsAdminMapper.selectOne(umsAdmin);
    }

    /**
     * 初始化用户对象
     *
     * @param umsAdmin {@link UmsAdmin}
     */
    private void initUmsAdmin(UmsAdmin umsAdmin) {
        // 初始化创建时间
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setLoginTime(new Date());

        // 初始化状态
        if (umsAdmin.getStatus() == null) {
            umsAdmin.setStatus(0);
        }

        // 密码加密
        umsAdmin.setPassword(passwordEncoder.encode(umsAdmin.getPassword()));
    }
}
