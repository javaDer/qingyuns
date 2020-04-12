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

@ApiModel(value="cn-wwtianmei-qingyun-order-entity-SendLog")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "send_log")
public class SendLog implements Serializable {
    /**
     * 注键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="注键id")
    private Long id;

    /**
     * 消息id
     */
    @TableField(value = "msg_id")
    @ApiModelProperty(value="消息id")
    private String msgId;

    /**
     * 订单id
     */
    @TableField(value = "order_id")
    @ApiModelProperty(value="订单id")
    private String orderId;

    /**
     * 0:消息投递中;1:成功;2:失败
     */
    @TableField(value = "status")
    @ApiModelProperty(value="0:消息投递中;1:成功;2:失败")
    private Integer status;

    /**
     * 路由key
     */
    @TableField(value = "route_key")
    @ApiModelProperty(value="路由key")
    private String routeKey;

    /**
     * 交换机
     */
    @TableField(value = "exchange")
    @ApiModelProperty(value="交换机")
    private String exchange;

    /**
     * 次数
     */
    @TableField(value = "count")
    @ApiModelProperty(value="次数")
    private Integer count;

    /**
     * 重试时间
     */
    @TableField(value = "try_time")
    @ApiModelProperty(value="重试时间")
    private Date tryTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}