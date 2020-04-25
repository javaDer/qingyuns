package cn.wwtianmei.qingyun.order.query;

import lombok.Data;

@Data
public class OrderQuery {
    private Long productId;
    private Long memberId;
    private String receiverName;
    private String receiverPhone;
    private int deleteStatus;
}
