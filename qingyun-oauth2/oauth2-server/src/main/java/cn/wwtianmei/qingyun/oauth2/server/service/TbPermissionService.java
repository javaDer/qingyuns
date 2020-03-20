package cn.wwtianmei.qingyun.oauth2.server.service;

import cn.wwtianmei.qingyun.oauth2.server.entity.TbPermission;

import java.util.List;

public interface TbPermissionService{

    List<TbPermission> selectByUserId(Long id);
}
