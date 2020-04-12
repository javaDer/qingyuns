package cn.wwtianmei.qingyun.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.wwtianmei.qingyun.order.entity.SendLog;
import cn.wwtianmei.qingyun.order.mapper.SendLogMapper;
import cn.wwtianmei.qingyun.order.service.SendLogService;
@Service
public class SendLogServiceImpl extends ServiceImpl<SendLogMapper, SendLog> implements SendLogService{

    @Override
    public void updateSendLogStatus(String msgId, int status) {
        this.baseMapper.updateSendLogStatus(msgId,status);
    }

    @Override
    public List<SendLog> selectNotSuccess(Integer msgFailuer) {
        QueryWrapper<SendLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",msgFailuer)
                .le("try_time",new Date());
        List<SendLog> sendLogs = baseMapper.selectList(queryWrapper);
        return sendLogs;
    }

    @Override
    public void updateSendLogCount(String msgId, Date date) {
        boolean flag = baseMapper.updateSendLogCount(msgId,date);
    }
}
