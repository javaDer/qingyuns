package cn.wwtianmei.qingyun.product.service.impl;

import cn.wwtianmei.qingyun.product.entity.PmsProduct;
import cn.wwtianmei.qingyun.product.mapper.PmsProductmapper;
import cn.wwtianmei.qingyun.product.service.PmsProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品信息(PmsProduct)表服务实现类
 *
 * @author makejava
 * @since 2020-03-05 00:17:23
 */
@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductmapper,PmsProduct> implements PmsProductService {
    @Resource
    private PmsProductmapper pmsProductDao;

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