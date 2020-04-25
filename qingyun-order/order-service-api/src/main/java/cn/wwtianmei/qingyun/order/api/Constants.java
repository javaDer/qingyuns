package cn.wwtianmei.qingyun.order.api;

public class Constants {
    public static final Integer MSG_DELIVERING = 0;
    public static final Integer MSG_SUCCESS = 1;
    public static final Integer MSG_FAILUER = 2;
    public static final Integer MSG_TRY_COUNT = 3;
    public static final Integer MSG_TIMEOUT = 1;
    public static final String PMS_ORDER_QUEUE_NAME = "pms.order.queue";
    public static final String PMS_ORDER_EXCHANGE_NAME = "pms.order.exchange";
    public static final String PMS_ORDER_ROUTING_KEY_NAME = "pms.order.routing.key";
}
