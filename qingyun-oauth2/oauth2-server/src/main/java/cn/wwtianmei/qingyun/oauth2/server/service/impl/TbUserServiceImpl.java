package cn.wwtianmei.qingyun.oauth2.server.service.impl;

import cn.wwtianmei.qingyun.oauth2.server.entity.TbUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import cn.wwtianmei.qingyun.oauth2.server.mapper.TbUserMapper;
import cn.wwtianmei.qingyun.oauth2.server.service.TbUserService;
import tk.mybatis.mapper.entity.Example;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getByUsername(String userName) {
        Example example = new Example(TbUser.class);
        example.createCriteria().andEqualTo("username", userName);
        return tbUserMapper.selectOneByExample(example);
    }
}
