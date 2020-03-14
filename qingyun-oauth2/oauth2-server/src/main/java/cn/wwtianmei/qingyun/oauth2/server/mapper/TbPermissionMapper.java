package cn.wwtianmei.qingyun.oauth2.server.mapper;

import cn.wwtianmei.qingyun.oauth2.server.entity.TbPermission;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface TbPermissionMapper extends MyMapper<TbPermission> {
    List<TbPermission> selectByUserId(@Param("id") Long id);
}