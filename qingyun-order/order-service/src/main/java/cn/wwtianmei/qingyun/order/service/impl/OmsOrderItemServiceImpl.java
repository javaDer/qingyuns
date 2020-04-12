package cn.wwtianmei.qingyun.order.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.wwtianmei.qingyun.order.entity.OmsOrderItem;
import cn.wwtianmei.qingyun.order.mapper.OmsOrderItemMapper;
import cn.wwtianmei.qingyun.order.service.impl.OmsOrderItemService;
@Service
public class OmsOrderItemServiceImpl extends ServiceImpl<OmsOrderItemMapper, OmsOrderItem> implements OmsOrderItemService{

}
