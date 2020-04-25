package cn.wwtianmei.qingyun.product.mapper;
import cn.wwtianmei.qingyun.product.entity.PmsProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 商品信息(PmsProduct)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-05 00:17:23
 */
public interface PmsProductmapper extends BaseMapper<PmsProduct> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsProduct queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PmsProduct> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param pmsProduct 实例对象
     * @return 对象列表
     */
    List<PmsProduct> queryAll(PmsProduct pmsProduct);

    /**
     * 修改数据
     *
     * @param pmsProduct 实例对象
     * @return 影响行数
     */
    int update(PmsProduct pmsProduct);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}