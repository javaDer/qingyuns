package cn.wwtianmei.qingyun.stock.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private Long id;

    /**
     * 消息id
     */
    @TableField(value = "msg_id")
    private String msgId;

    /**
     * 订单id
     */
    @TableField(value = "order_id")
    private String orderId;

    /**
     * 0:消息投递中;1:成功;2:失败
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 路由key
     */
    @TableField(value = "route_key")
    private String routeKey;

    /**
     * 交换机
     */
    @TableField(value = "exchange")
    private String exchange;

    /**
     * 次数
     */
    @TableField(value = "count")
    private Integer count;

    /**
     * 重试时间
     */
    @TableField(value = "try_time")
    private Date tryTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}