package cn.wwtianmei.qingyun.order.controller;

import cn.wwtianmei.qingyun.order.entity.OmsOrder;
import cn.wwtianmei.qingyun.order.service.OmsOrderService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "2.0.2版本-20200226",position = 286)
public class OmsOrderController {
    /**
     * 服务对象
     */
    @Resource
    private OmsOrderService omsOrderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    @ApiOperationSupport(ignoreParameters = "ids")
    @ApiOperation(value = "忽略参数值-Form类型")
    public OmsOrder selectOne(Long id) {
        return this.omsOrderService.queryById(id);
    }

}