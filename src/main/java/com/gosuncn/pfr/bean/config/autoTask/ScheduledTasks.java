package com.gosuncn.pfr.bean.config.autoTask;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author ningjinxiang
 * @date 20190517
 * govideo一些参数定时同步到本地
 */
@Component
@Configurable
@EnableScheduling
public class ScheduledTasks {
    /**
     * @Author:ningjinxiang
     * @Description:定时导出任务
     * @Date:2019/1/23_10:10
     * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
     * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
     * @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
     * @Scheduled(cron = "${task.cron}") 也可以通过cron表达式
     */
//    @Scheduled(cron = "0/10 * * * * ?")//每10秒执行，测试用
//    @Scheduled(cron = "${task.cron}")//每15分钟执行（）

    /**
     * 定时检测设备心跳，判断设备是否在线
     */
    @Scheduled(fixedDelay = 12000)//两分钟执行一次
//    @Scheduled(cron = "0 0 2 * * ?")//每天凌晨2点同步一次
    public void checkHeartbeat() {
    }

}
