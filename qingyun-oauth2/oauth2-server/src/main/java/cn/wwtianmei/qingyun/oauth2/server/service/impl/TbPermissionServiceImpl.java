package cn.wwtianmei.qingyun.oauth2.server.service.impl;

import cn.wwtianmei.qingyun.oauth2.server.entity.TbPermission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import cn.wwtianmei.qingyun.oauth2.server.mapper.TbPermissionMapper;
import cn.wwtianmei.qingyun.oauth2.server.service.TbPermissionService;

import java.util.List;

@Service
public class TbPermissionServiceImpl implements TbPermissionService {

    @Resource
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<TbPermission> selectByUserId(Long id) {
        return tbPermissionMapper.selectByUserId(id);
    }
}
