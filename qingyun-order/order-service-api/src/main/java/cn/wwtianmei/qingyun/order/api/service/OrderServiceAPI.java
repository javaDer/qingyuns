package cn.wwtianmei.qingyun.order.api.service;

import cn.wwtianmei.qingyun.order.api.entity.OmsOrderDto;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * 订单表(OmsOrder)表服务接口
 *
 * @author makejava
 * @since 2020-03-05 00:08:38
 */
@Service
public interface OrderServiceAPI {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OmsOrderDto queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OmsOrderDto> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param omsOrder 实例对象
     * @return 实例对象
     */
    OmsOrderDto insert(OmsOrderDto omsOrder);

    /**
     * 修改数据
     *
     * @param omsOrder 实例对象
     * @return 实例对象
     */
    OmsOrderDto update(OmsOrderDto omsOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}