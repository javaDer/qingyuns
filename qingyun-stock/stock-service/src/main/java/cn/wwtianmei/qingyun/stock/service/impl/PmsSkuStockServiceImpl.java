package cn.wwtianmei.qingyun.stock.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.wwtianmei.qingyun.stock.entity.PmsSkuStock;
import cn.wwtianmei.qingyun.stock.mapper.PmsSkuStockMapper;
import cn.wwtianmei.qingyun.stock.service.PmsSkuStockService;

@Service
public class PmsSkuStockServiceImpl extends ServiceImpl<PmsSkuStockMapper, PmsSkuStock> implements PmsSkuStockService {
    private final PmsSkuStockMapper skuStockMapper;

    public PmsSkuStockServiceImpl(PmsSkuStockMapper skuStockMapper) {
        this.skuStockMapper = skuStockMapper;
    }

    @Override
    public Boolean inventoryDeduction(String productId) {

        Boolean isFlag = skuStockMapper.inventoryDeduction(productId);
        return isFlag;
    }
}
