package cn.wwtianmei.qingyun.product.api.service;

import cn.wwtianmei.qingyun.product.api.entity.PmsProductDto;

import java.util.List;

/**
 * 商品信息(PmsProduct)表服务接口
 *
 * @author makejava
 * @since 2020-03-05 00:17:23
 */
public interface ProductServiceApi {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsProductDto queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PmsProductDto> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param pmsProduct 实例对象
     * @return 实例对象
     */
    PmsProductDto insert(PmsProductDto pmsProduct);

    /**
     * 修改数据
     *
     * @param pmsProduct 实例对象
     * @return 实例对象
     */
    PmsProductDto update(PmsProductDto pmsProduct);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}