package cn.wwtianmei.qingyun.stock.mapper;

import cn.wwtianmei.qingyun.stock.entity.PmsSkuStock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface PmsSkuStockMapper extends BaseMapper<PmsSkuStock> {
    Boolean inventoryDeduction(@Param("productId") String productId);
}