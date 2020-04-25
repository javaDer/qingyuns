package cn.wwtianmei.qingyun.order.service;

import cn.wwtianmei.qingyun.order.entity.OmsOrder;
import cn.wwtianmei.qingyun.order.query.OrderQuery;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 订单表(OmsOrder)表服务接口
 *
 * @author makejava
 * @since 2020-03-05 00:08:38
 */
public interface OmsOrderService extends IService<OmsOrder> {

    Boolean saveOrder(OrderQuery orderQuery);

    OmsOrder selectByOrderId(Long id);
}