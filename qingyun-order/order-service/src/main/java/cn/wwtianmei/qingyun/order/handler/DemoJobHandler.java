package cn.wwtianmei.qingyun.order.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

@Slf4j
@Component
public class DemoJobHandler{
    @XxlJob("jobDemo")
    public ReturnT<String> execute(String s) throws Exception {
        XxlJobLogger.log("This is a demo job.");
        Thread.sleep(5 * 1000L);
        log.info("xxl-job执行成功");
        return SUCCESS;
    }
}
