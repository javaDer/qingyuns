package cn.wwtianmei.qingyun.order.handler;

import cn.wwtianmei.qingyun.order.api.Constants;
import cn.wwtianmei.qingyun.order.entity.OmsOrder;
import cn.wwtianmei.qingyun.order.entity.SendLog;
import cn.wwtianmei.qingyun.order.service.OmsOrderService;
import cn.wwtianmei.qingyun.order.service.SendLogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

@Slf4j
@Component
public class RabbitMQTask {
    private final SendLogService sendLogService;

    private final RabbitTemplate rabbitTemplate;
    private final OmsOrderService orderService;

    public RabbitMQTask(SendLogService sendLogService, RabbitTemplate rabbitTemplate, OmsOrderService orderService) {
        this.sendLogService = sendLogService;
        this.rabbitTemplate = rabbitTemplate;
        this.orderService = orderService;
    }

    @XxlJob("orderRsSendTask")
    public ReturnT<String> execute(String s) throws Exception {
        log.info("XXL-job开始自动扫描未成功的信息");
        //获取发送失败的信息
        List<SendLog> logs = sendLogService.selectNotSuccess(Constants.MSG_DELIVERING);
        log.info("发送失败的信息:{}", logs);
        logs.forEach(log -> {
            if (log.getCount() >= Constants.MSG_TRY_COUNT) {
                sendLogService.updateSendLogStatus(log.getMsgId(), Constants.MSG_FAILUER);
            } else {
                sendLogService.updateSendLogCount(log.getMsgId(), new Date());
                OmsOrder order = orderService.getById(log.getOrderId());
                rabbitTemplate.convertAndSend(log.getExchange(), log.getRouteKey(), order, new CorrelationData(log.getMsgId()));
            }
        });
        return SUCCESS;
    }
}
