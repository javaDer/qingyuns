package cn.wwtianmei.qingyun.product.provider;

import cn.wwtianmei.qingyun.product.api.entity.PmsProductDto;
import cn.wwtianmei.qingyun.product.api.service.ProductService;
import cn.wwtianmei.qingyun.product.dao.PmsProductDao;
import cn.wwtianmei.qingyun.product.entity.PmsProduct;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

import java.util.List;
@Service
public class ProductProviderServiceImpl implements ProductService {
    public final PmsProductDao pmsProductDao;

    public ProductProviderServiceImpl(PmsProductDao pmsProductDao) {
        this.pmsProductDao = pmsProductDao;
    }


    @Override
    public PmsProductDto queryById(Long id) {
        PmsProductDto pmsProductDto = new PmsProductDto();
        PmsProduct pmsProduct = pmsProductDao.queryById(id);
        BeanUtils.copyProperties(pmsProduct,pmsProductDto);
        return pmsProductDto;
    }

    @Override
    public List<PmsProductDto> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public PmsProductDto insert(PmsProductDto pmsProduct) {
        return null;
    }

    @Override
    public PmsProductDto update(PmsProductDto pmsProduct) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
