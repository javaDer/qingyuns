package cn.wwtianmei.qingyun.stock.consumer;

import cn.wwtianmei.qingyun.order.api.Constants;
import cn.wwtianmei.qingyun.order.api.entity.OmsOrder;
import cn.wwtianmei.qingyun.order.api.entity.OmsOrderDto;
import cn.wwtianmei.qingyun.stock.entity.SendLog;
import cn.wwtianmei.qingyun.stock.service.PmsSkuStockService;
import cn.wwtianmei.qingyun.stock.service.impl.SendLogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Slf4j
@Component
public class ProductConsumer {
    private final SendLogService sendLogService;
    private final StringRedisTemplate redisTemplate;
    private final PmsSkuStockService stockService;

    public ProductConsumer(SendLogService sendLogService, StringRedisTemplate redisTemplate, PmsSkuStockService stockService) {
        this.sendLogService = sendLogService;
        this.redisTemplate = redisTemplate;
        this.stockService = stockService;
    }

    @RabbitListener(queues = Constants.PMS_ORDER_QUEUE_NAME)
    public void handler(Message message, Channel channel) throws IOException {

        OmsOrderDto order = (OmsOrderDto) message.getPayload();
        MessageHeaders headers = message.getHeaders();
        Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        String msgId = (String) headers.get("spring_returned_message_correlation");
        try {
        if (redisTemplate.opsForHash().entries("order_log").containsKey(msgId)) {
            //redis包含该key
            log.info("消息已经被消费 msgId:{}", msgId);
            //确认消息已经被消费

                channel.basicAck(tag, Boolean.FALSE);

            return;
        }
        log.info("消息消费:{}", order);
        SendLog sendLog = new SendLog();
        sendLog.setStatus(Constants.MSG_SUCCESS);
        sendLog.setUpdateTime(new Date());
        QueryWrapper<SendLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", order.getId());
        redisTemplate.opsForHash().put("order_log", msgId, order.getId()+"");
        log.info("信息已消费:{}", msgId);

        //减少库存
        Boolean flag = stockService.inventoryDeduction(order.getProductId());
        if (flag) {
            channel.basicAck(tag, Boolean.FALSE);
            boolean update = sendLogService.update(sendLog, queryWrapper);
        } else {
            channel.basicNack(tag, Boolean.FALSE, Boolean.TRUE);
            log.info("消息失败:{}", msgId);
        }
        } catch (IOException e) {
            channel.basicNack(tag, Boolean.FALSE, Boolean.TRUE);
            log.info("消息失败:{}", msgId);
        }
    }
}
