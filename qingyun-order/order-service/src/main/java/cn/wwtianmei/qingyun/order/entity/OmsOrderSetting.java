package cn.wwtianmei.qingyun.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="cn-wwtianmei-qingyun-order-entity-OmsOrderSetting")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "oms_order_setting")
public class OmsOrderSetting implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 秒杀订单超时关闭时间(分)
     */
    @TableField(value = "flash_order_overtime")
    @ApiModelProperty(value="秒杀订单超时关闭时间(分)")
    private Integer flashOrderOvertime;

    /**
     * 正常订单超时时间(分)
     */
    @TableField(value = "normal_order_overtime")
    @ApiModelProperty(value="正常订单超时时间(分)")
    private Integer normalOrderOvertime;

    /**
     * 发货后自动确认收货时间（天）
     */
    @TableField(value = "confirm_overtime")
    @ApiModelProperty(value="发货后自动确认收货时间（天）")
    private Integer confirmOvertime;

    /**
     * 自动完成交易时间，不能申请售后（天）
     */
    @TableField(value = "finish_overtime")
    @ApiModelProperty(value="自动完成交易时间，不能申请售后（天）")
    private Integer finishOvertime;

    /**
     * 订单完成后自动好评时间（天）
     */
    @TableField(value = "comment_overtime")
    @ApiModelProperty(value="订单完成后自动好评时间（天）")
    private Integer commentOvertime;

    private static final long serialVersionUID = 1L;
}