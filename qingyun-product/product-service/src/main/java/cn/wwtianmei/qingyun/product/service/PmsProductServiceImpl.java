package cn.wwtianmei.qingyun.product.service;

import cn.wwtianmei.qingyun.product.api.entity.PmsProduct;
import cn.wwtianmei.qingyun.product.api.service.PmsProductService;
import cn.wwtianmei.qingyun.product.dao.PmsProductDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品信息(PmsProduct)表服务实现类
 *
 * @author makejava
 * @since 2020-03-05 00:17:23
 */
@Service
public class PmsProductServiceImpl implements PmsProductService {
    @Resource
    private PmsProductDao pmsProductDao;

    @Override
    public PmsProduct queryById(Long id) {
        PmsProduct pmsProducts = new PmsProduct();
        cn.wwtianmei.qingyun.product.entity.PmsProduct pmsProduct = pmsProductDao.queryById(id);
        BeanUtils.copyProperties(pmsProduct,pmsProducts);
        return pmsProducts;
    }

    @Override
    public List<PmsProduct> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public PmsProduct insert(PmsProduct pmsProduct) {
        return null;
    }

    @Override
    public PmsProduct update(PmsProduct pmsProduct) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}