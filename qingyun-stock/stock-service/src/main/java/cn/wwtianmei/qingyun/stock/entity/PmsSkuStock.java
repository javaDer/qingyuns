package cn.wwtianmei.qingyun.stock.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "pms_sku_stock")
public class PmsSkuStock implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "product_id")
    private Integer productId;

    /**
     * sku编码
     */
    @TableField(value = "sku_code")
    private String skuCode;

    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 库存
     */
    @TableField(value = "stock")
    private Integer stock;

    /**
     * 预警库存
     */
    @TableField(value = "low_stock")
    private Integer lowStock;

    /**
     * 销售属性1
     */
    @TableField(value = "sp1")
    private String sp1;

    @TableField(value = "sp2")
    private String sp2;

    @TableField(value = "sp3")
    private String sp3;

    /**
     * 展示图片
     */
    @TableField(value = "pic")
    private String pic;

    /**
     * 销量
     */
    @TableField(value = "sale")
    private Integer sale;

    /**
     * 单品促销价格
     */
    @TableField(value = "promotion_price")
    private BigDecimal promotionPrice;

    /**
     * 锁定库存
     */
    @TableField(value = "lock_stock")
    private Integer lockStock;

    private static final long serialVersionUID = 1L;
}