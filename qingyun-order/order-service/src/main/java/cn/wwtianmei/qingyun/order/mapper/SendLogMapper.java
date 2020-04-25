package cn.wwtianmei.qingyun.order.mapper;

import cn.wwtianmei.qingyun.order.entity.SendLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface SendLogMapper extends BaseMapper<SendLog> {
    Boolean updateSendLogStatus(@Param("msgId") String msgId, @Param("status") int status);

    boolean updateSendLogCount(@Param("msgId") String msgId, @Param("date") Date date);
}