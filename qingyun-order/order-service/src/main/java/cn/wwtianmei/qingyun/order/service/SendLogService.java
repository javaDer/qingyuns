package cn.wwtianmei.qingyun.order.service;

import cn.wwtianmei.qingyun.order.entity.SendLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

public interface SendLogService extends IService<SendLog>{


    void updateSendLogStatus(String msgId, int i);

    List<SendLog> selectNotSuccess(Integer msgFailuer);

    void updateSendLogCount(String msgId, Date date);
}
