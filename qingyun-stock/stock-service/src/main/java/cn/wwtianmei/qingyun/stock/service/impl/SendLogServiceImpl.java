package cn.wwtianmei.qingyun.stock.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.wwtianmei.qingyun.stock.mapper.SendLogMapper;
import cn.wwtianmei.qingyun.stock.entity.SendLog;
import cn.wwtianmei.qingyun.stock.service.impl.SendLogService;
@Service
public class SendLogServiceImpl extends ServiceImpl<SendLogMapper, SendLog> implements SendLogService{

}
