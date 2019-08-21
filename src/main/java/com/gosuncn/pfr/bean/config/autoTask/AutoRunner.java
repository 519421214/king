package com.gosuncn.pfr.bean.config.autoTask;

import com.gosuncn.pfr.service.impl.TblResidentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 项目启动后缓存数据
 */
@Component//被spring容器管理
//@Order(1)//如果多个自定义ApplicationRunner，用来标明执行顺序
public class AutoRunner implements ApplicationRunner {
    @Autowired
    private TblResidentServiceImpl residentService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        faceRegisterAgain();
    }

    //缓存1
    public void faceRegisterAgain() {
        residentService.faceRegisterAgain();
        System.exit(0);
    }

//定时任务测试(线程)
//    public static void myTimer(){
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("------定时任务,0秒后开始执行，每1秒执行一次--------");
//            }
//        }, 0, 1000);
//    }
}
