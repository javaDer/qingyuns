package cn.wwtianmei.qingyun.product.provider;

import cn.wwtianmei.qingyun.product.api.entity.PmsProductDto;
import cn.wwtianmei.qingyun.product.api.service.ProductServiceApi;
import cn.wwtianmei.qingyun.product.entity.PmsProduct;
import cn.wwtianmei.qingyun.product.mapper.PmsProductmapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

import java.util.List;
@Service
public class ProductProviderServiceImpl implements ProductServiceApi {
    public final PmsProductmapper pmsProductDao;

    public ProductProviderServiceImpl(PmsProductmapper pmsProductDao) {
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
