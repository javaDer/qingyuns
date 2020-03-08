package cn.wwtianmei.qingyun.product.controller;

import cn.wwtianmei.qingyun.product.api.entity.PmsProductDto;
import cn.wwtianmei.qingyun.product.entity.PmsProduct;
import cn.wwtianmei.qingyun.product.service.PmsProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品信息(PmsProduct)表控制层
 *
 * @author makejava
 * @since 2020-03-05 00:17:23
 */
@RestController
@RequestMapping("pmsProduct")
public class PmsProductController {
    /**
     * 服务对象
     */
    @Resource
    private PmsProductService pmsProductService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PmsProduct selectOne(Long id) {
        PmsProduct pmsProducts = new PmsProduct();
        PmsProduct pmsProduct = this.pmsProductService.queryById(id);
        BeanUtils.copyProperties(pmsProduct,pmsProducts);
        return pmsProducts;
    }

}