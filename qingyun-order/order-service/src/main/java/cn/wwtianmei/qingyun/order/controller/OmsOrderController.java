package cn.wwtianmei.qingyun.order.controller;

import cn.hutool.http.HttpStatus;
import cn.wwtianmei.qingyun.order.common.Result;
import cn.wwtianmei.qingyun.order.entity.OmsOrder;
import cn.wwtianmei.qingyun.order.query.OrderQuery;
import cn.wwtianmei.qingyun.order.service.OmsOrderService;
import cn.wwtianmei.qingyun.product.api.entity.PmsProductDto;
import cn.wwtianmei.qingyun.product.api.service.ProductServiceApi;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

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
    private ProductServiceApi pmsProductService;

    /**
     * 通过主键查询单条数据
     *f
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    @ApiOperationSupport(ignoreParameters = "ids")
    @ApiOperation(value = "根据id查询订单")
    public OmsOrder selectOne(Long id) {
        return this.omsOrderService.selectByOrderId(id);
    }

    @GetMapping("/selectOneProduct")
    @ApiOperationSupport(ignoreParameters = "ids")
    @ApiOperation(value = "查询Product")
    public PmsProductDto selectOneProduct(Long id) {
        return pmsProductService.queryById(id);
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存订单")
    public Result<Boolean> saveOrder(@RequestBody OrderQuery orderQuery  ){
     Boolean flag =  this.omsOrderService.saveOrder(orderQuery);
     return new Result<Boolean>(HttpStatus.HTTP_OK,"保存成功",flag);

    }

}