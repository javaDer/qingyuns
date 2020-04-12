package cn.wwtianmei.qingyun.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="cn-wwtianmei-qingyun-order-entity-OmsOrderItem")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "oms_order_item")
public class OmsOrderItem implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 订单id
     */
    @TableField(value = "order_id")
    @ApiModelProperty(value="订单id")
    private Long orderId;

    /**
     * 订单编号
     */
    @TableField(value = "order_sn")
    @ApiModelProperty(value="订单编号")
    private String orderSn;

    @TableField(value = "product_id")
    @ApiModelProperty(value="")
    private Long productId;

    @TableField(value = "product_pic")
    @ApiModelProperty(value="")
    private String productPic;

    @TableField(value = "product_name")
    @ApiModelProperty(value="")
    private String productName;

    @TableField(value = "product_brand")
    @ApiModelProperty(value="")
    private String productBrand;

    @TableField(value = "product_sn")
    @ApiModelProperty(value="")
    private String productSn;

    /**
     * 销售价格
     */
    @TableField(value = "product_price")
    @ApiModelProperty(value="销售价格")
    private BigDecimal productPrice;

    /**
     * 购买数量
     */
    @TableField(value = "product_quantity")
    @ApiModelProperty(value="购买数量")
    private Integer productQuantity;

    /**
     * 商品sku编号
     */
    @TableField(value = "product_sku_id")
    @ApiModelProperty(value="商品sku编号")
    private Long productSkuId;

    /**
     * 商品sku条码
     */
    @TableField(value = "product_sku_code")
    @ApiModelProperty(value="商品sku条码")
    private String productSkuCode;

    /**
     * 商品分类id
     */
    @TableField(value = "product_category_id")
    @ApiModelProperty(value="商品分类id")
    private Integer productCategoryId;

    /**
     * 商品的销售属性
     */
    @TableField(value = "sp1")
    @ApiModelProperty(value="商品的销售属性")
    private String sp1;

    @TableField(value = "sp2")
    @ApiModelProperty(value="")
    private String sp2;

    @TableField(value = "sp3")
    @ApiModelProperty(value="")
    private String sp3;

    /**
     * 商品促销名称
     */
    @TableField(value = "promotion_name")
    @ApiModelProperty(value="商品促销名称")
    private String promotionName;

    /**
     * 商品促销分解金额
     */
    @TableField(value = "promotion_amount")
    @ApiModelProperty(value="商品促销分解金额")
    private BigDecimal promotionAmount;

    /**
     * 优惠券优惠分解金额
     */
    @TableField(value = "coupon_amount")
    @ApiModelProperty(value="优惠券优惠分解金额")
    private BigDecimal couponAmount;

    /**
     * 积分优惠分解金额
     */
    @TableField(value = "integration_amount")
    @ApiModelProperty(value="积分优惠分解金额")
    private BigDecimal integrationAmount;

    /**
     * 该商品经过优惠后的分解金额
     */
    @TableField(value = "real_amount")
    @ApiModelProperty(value="该商品经过优惠后的分解金额")
    private BigDecimal realAmount;

    @TableField(value = "gift_integration")
    @ApiModelProperty(value="")
    private Integer giftIntegration;

    @TableField(value = "gift_growth")
    @ApiModelProperty(value="")
    private Integer giftGrowth;

    /**
     * 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     */
    @TableField(value = "product_attr")
    @ApiModelProperty(value="商品销售属性")
    private String productAttr;

    private static final long serialVersionUID = 1L;
}