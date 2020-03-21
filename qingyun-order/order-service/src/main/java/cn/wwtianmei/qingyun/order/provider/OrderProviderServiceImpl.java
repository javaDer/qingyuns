package cn.wwtianmei.qingyun.order.provider;

import cn.wwtianmei.qingyun.order.api.entity.OmsOrderDto;
import cn.wwtianmei.qingyun.order.api.service.OrderServiceAPI;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service
public class OrderProviderServiceImpl implements OrderServiceAPI {

    @Override
    public OmsOrderDto queryById(Long id) {
        return null;
    }

    @Override
    public List<OmsOrderDto> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public OmsOrderDto insert(OmsOrderDto omsOrder) {
        return null;
    }

    @Override
    public OmsOrderDto update(OmsOrderDto omsOrder) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
