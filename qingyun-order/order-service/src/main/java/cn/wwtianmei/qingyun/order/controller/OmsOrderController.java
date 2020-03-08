package cn.wwtianmei.qingyun.order.controller;

import cn.wwtianmei.qingyun.order.entity.OmsOrder;
import cn.wwtianmei.qingyun.order.service.OmsOrderService;
import cn.wwtianmei.qingyun.product.api.entity.PmsProductDto;
import cn.wwtianmei.qingyun.product.api.service.ProductService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单表(OmsOrder)表控制层
 *
 * @author makejava
 * @since 2020-03-05 00:08:40
 */
@RestController
@RequestMapping("omsOrder")
@Api(tags = "订单API")
public class OmsOrderController {
    /**
     * 服务对象
     */
    @Resource
    private OmsOrderService omsOrderService;
    @Reference
    private ProductService pmsProductService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    @ApiOperationSupport(ignoreParameters = "ids")
    @ApiOperation(value = "根据id查询订单")
    public OmsOrder selectOne(Long id) {
        return this.omsOrderService.queryById(id);
    }

    @GetMapping("/selectOneProduct")
    @ApiOperationSupport(ignoreParameters = "ids")
    @ApiOperation(value = "查询Product")
    public PmsProductDto selectOneProduct(Long id) {
        return pmsProductService.queryById(id);
    }

}