package com.cskaoyan.service;

import com.cskaoyan.mapper.SysUserMapper;
import com.cskaoyan.pojo.SysUser;
import com.cskaoyan.pojo.SysUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public boolean ajaxLogin(SysUser sysUser) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();

        criteria.andUsernameEqualTo(sysUser.getUsername());
        criteria.andPasswordEqualTo(sysUser.getPassword());

        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);

        return sysUsers.size() != 0;
    }

}
