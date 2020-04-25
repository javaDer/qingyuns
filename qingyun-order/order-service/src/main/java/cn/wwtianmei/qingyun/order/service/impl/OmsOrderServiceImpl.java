package cn.wwtianmei.qingyun.order.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.wwtianmei.qingyun.order.api.Constants;
import cn.wwtianmei.qingyun.order.api.entity.OmsOrderDto;
import cn.wwtianmei.qingyun.order.entity.OmsOrder;
import cn.wwtianmei.qingyun.order.entity.SendLog;
import cn.wwtianmei.qingyun.order.mapper.OmsOrderMapper;
import cn.wwtianmei.qingyun.order.query.OrderQuery;
import cn.wwtianmei.qingyun.order.service.OmsOrderService;
import cn.wwtianmei.qingyun.order.service.SendLogService;
import cn.wwtianmei.qingyun.product.api.entity.PmsProductDto;
import cn.wwtianmei.qingyun.product.api.service.ProductServiceApi;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 订单表(OmsOrder)表服务实现类
 *
 * @author makejava
 * @since 2020-03-05 00:08:39
 */
@Slf4j
@Service("omsOrderService")
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderMapper, OmsOrder> implements OmsOrderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private SendLogService logService;
    @Autowired
    private OmsOrderMapper orderMapper;
    @Reference
    ProductServiceApi productApi;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveOrder(OrderQuery orderQuery) {
        //查看商品
        PmsProductDto pmsProductDto = queryProduct(orderQuery.getProductId());
        OmsOrder order = new OmsOrder();
        BeanUtils.copyProperties(orderQuery, order);
        order.setCommentTime(new Date());
        order.setCreateTime(new Date());
        int insert = this.orderMapper.insert(order);
        if (insert > 0) {
            OmsOrder omsOrder = orderMapper.selectById(order.getId());
            OmsOrderDto orderDto = new OmsOrderDto();
            BeanUtils.copyProperties(omsOrder, orderDto);
            orderDto.setProductId(pmsProductDto.getId() + "");
            log.info("omsOrder:{}", omsOrder);
            String msgId = IdUtil.fastSimpleUUID();
            SendLog logs = SendLog.builder()
                    .count(1)
                    .createTime(new Date())
                    .msgId(msgId)
                    .exchange(Constants.PMS_ORDER_EXCHANGE_NAME)
                    .status(Constants.MSG_DELIVERING)
                    .routeKey(Constants.PMS_ORDER_ROUTING_KEY_NAME)
                    .orderId(orderDto.getId() + "")
                    .tryTime(DateUtil.offset(new Date(), DateField.MINUTE, Constants.MSG_TIMEOUT))
                    .build();
            this.logService.save(logs);
            rabbitTemplate.convertAndSend(Constants.PMS_ORDER_EXCHANGE_NAME,
                    Constants.PMS_ORDER_ROUTING_KEY_NAME, orderDto,
                    new CorrelationData(msgId));
            log.info(order.toString());
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public OmsOrder selectByOrderId(Long id) {
        return this.orderMapper.selectById(id);
    }

    private PmsProductDto queryProduct(Long id) {
        PmsProductDto productDto = productApi.queryById(id);
        return productDto;
    }
}