package cn.wwtianmei.qingyun.order.config;

import cn.wwtianmei.qingyun.order.api.Constants;
import cn.wwtianmei.qingyun.order.service.SendLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RabbitConfig {
    private final CachingConnectionFactory cachingConnectionFactory;
    private final SendLogService sendLogService;

    public RabbitConfig(CachingConnectionFactory cachingConnectionFactory, SendLogService sendLogService) {
        this.cachingConnectionFactory = cachingConnectionFactory;
        this.sendLogService = sendLogService;
    }

    @Bean
    RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setConfirmCallback((data, ack, cause) -> {
            String msgId = data.getId();
            if (ack) {

                log.info("信息发送成功:{}", msgId);
                //修改数据库中的数据
                sendLogService.updateSendLogStatus(msgId, 1);
            } else {
                log.info("信息发送失败:{}", msgId);
            }
        });
        rabbitTemplate.setReturnCallback((msg, repCode, repText, exchange, routingkey) -> {
            log.info("信息发送失败");
        });
        return rabbitTemplate;
    }

    @Bean
    Queue orderQueue() {
        return new Queue(Constants.PMS_ORDER_QUEUE_NAME, true);
    }

    @Bean
    DirectExchange orderExchange() {
        return new DirectExchange(Constants.PMS_ORDER_EXCHANGE_NAME, Boolean.TRUE, Boolean.FALSE);
    }

    @Bean
    Binding orderBinding() {
        return BindingBuilder.bind(orderQueue()).to(orderExchange()).with(Constants.PMS_ORDER_ROUTING_KEY_NAME);
    }
}
