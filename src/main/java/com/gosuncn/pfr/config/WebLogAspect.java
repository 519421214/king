package com.gosuncn.pfr.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Set;

/**
 * 项目名称:  vdd
 * 包:       com.gosun.myproj.framework.aspect
 * 类名称:    WebLogAspect.java
 * 类描述:    记录WEB请求日志.AOP拦截
 * 创建人:    Mr.XiHui
 * 创建时间:  2018/9/2
 */
@Aspect
@Component
@Slf4j//需要设置允许注解处理
public class WebLogAspect {

//    private static final ThreadLocal<Long> START_TIME_THREAD_LOCAL = new ThreadLocal<>();
//    private static final ThreadLocal<Map<String, Object>> REQUEST_MAP_THREAD_LOCAL = new ThreadLocal<>();

    // 两个..代表所有子目录，最后括号里的两个..代表所有参数 模糊写法*Sync(..)
//    @Pointcut("execution(public * com.gosuncn.vdd.controller.*Controller.*(..))"+"|| execution(public * com.gosuncn.vdd.controller.*Controller.*(..))")
    @Pointcut("execution(public * com.gosuncn.pfr.controller.*Controller.*(..))")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {

//        START_TIME_THREAD_LOCAL.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        Signature signature = joinPoint.getSignature();
//
//        String url = request.getRequestURL().toString();
//        String remoteAddr = request.getRemoteAddr();
//        String httpMethod = request.getMethod();
//        String classMethod = signature.getDeclaringTypeName() + "." + signature.getName();

//        Map<String, Object> requestMap = new LinkedHashMap<>();
//        requestMap.put("remoteAddr", remoteAddr);
//        requestMap.put("url", url);
//        requestMap.put("httpMethod", httpMethod);
//        requestMap.put("classMethod", classMethod);

        Object[] args = joinPoint.getArgs();
        if (ObjectUtils.isEmpty(args) || args[0]==null) {
            args = new Object[]{"no parameter，无入参"};
        }else {

            Object[] clone = args.clone();
//        for (int i = 0; i < clone.length; i++) {
//            Object o = clone[i];
//            if (o instanceof ServletRequest
//                    || o instanceof ServletResponse
//                    || o instanceof HttpSession) {
//                clone[i] = o.toString();//防止JsonUtils.toJsonStr操作报错
//            }
//        }
//        requestMap.put("requestBody", clone);

            if (log.isInfoEnabled()) {
                String msg;
                //过滤base64的照片数据打印到info
                if (!ObjectUtils.isEmpty(clone) && "com.gosuncn.pfr.bean.request.travel.TravelVisitModel".equals(clone[0].getClass().getName())) {
                    //提测时开一下，避免遇到问题找不到原因 todo
//                log.warn("imageParms : {} ", JSONObject.toJSONString(clone, SerializerFeature.WriteMapNullValue));
                    SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
                    Set<String> excludes = filter.getExcludes();
                    excludes.add("xczp");
                    excludes.add("zjzp");
                    msg = JSONObject.toJSONString(clone[0], filter, SerializerFeature.WriteMapNullValue);
                } else {
                    msg = JSONObject.toJSONString(clone[0], SerializerFeature.WriteMapNullValue);
                }
                log.info("============>> requst : {} ", msg);
            }
        }
        log.info("http<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//        REQUEST_MAP_THREAD_LOCAL.set(requestMap);
    }

    @AfterReturning(returning = "ret", pointcut = "logPointCut()")
    // returning的值和doAfterReturning的参数名一致
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        if (log.isInfoEnabled()) {
            log.info("<<============ response : {} ", JSONObject.toJSONString(ret, SerializerFeature.WriteMapNullValue));
        }
    }

//    /**
//     * 先进入此异常，在走全局异常
//     * @param ex
//     */
//    @AfterThrowing(value = "logPointCut()", throwing = "ex")
//    public void doAfterThrowing(Exception ex) {
//
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//
//        Map<String, Object> requestMap = REQUEST_MAP_THREAD_LOCAL.get();
//        if (!CollectionUtils.isEmpty(requestMap)) {
//            Object requestBody = requestMap.get("requestBody");
//            //controller第一个入参不是RespBody时requestBody就不是ReqtBody
//            if (requestBody instanceof ReqtBody) {
//                ReqtBody reqtBody = (ReqtBody) requestBody;
//                request.setAttribute("requestId", reqtBody.getRequestId());
//            }
//        }
//        request.setAttribute("requestMap", requestMap);
//        request.setAttribute("startTime", START_TIME_THREAD_LOCAL.get());
//
//        START_TIME_THREAD_LOCAL.remove();
//        REQUEST_MAP_THREAD_LOCAL.remove();
//    }
}

