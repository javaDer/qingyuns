package cn.wwtianmei.qingyun.stock.service;

import cn.wwtianmei.qingyun.stock.entity.PmsSkuStock;
import com.baomidou.mybatisplus.extension.service.IService;
public interface PmsSkuStockService extends IService<PmsSkuStock>{


    Boolean inventoryDeduction(String productId);

}
