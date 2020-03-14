package cn.wwtianmei.qingyun.oauth2.server.service;

import cn.wwtianmei.qingyun.oauth2.server.entity.TbUser;

public interface TbUserService {
    TbUser getByUsername(String userName);
}
