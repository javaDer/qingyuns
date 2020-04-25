package cn.wwtianmei.qingyun.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="cn-wwtianmei-qingyun-order-entity-OmsOrderOperateHistory")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "oms_order_operate_history")
public class OmsOrderOperateHistory implements Serializable {
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
     * 操作人：用户；系统；后台管理员
     */
    @TableField(value = "operate_man")
    @ApiModelProperty(value="操作人：用户；系统；后台管理员")
    private String operateMan;

    /**
     * 操作时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="操作时间")
    private Date createTime;

    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     */
    @TableField(value = "order_status")
    @ApiModelProperty(value="订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
    private Integer orderStatus;

    /**
     * 备注
     */
    @TableField(value = "note")
    @ApiModelProperty(value="备注")
    private String note;

    private static final long serialVersionUID = 1L;
}