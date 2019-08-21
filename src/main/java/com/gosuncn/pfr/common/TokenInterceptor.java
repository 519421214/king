/**
 * @Title: CheckSessionTimeoutProcessorImpl.java
 * @Package com.gosuncn.vdiagnosis.validator
 * @Description: TODO
 * @author Linnan
 * @date 2018年9月10日
 * @version V1.0
 */

package com.gosuncn.pfr.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Copyright © 1997 - 2018 Gosuncn. All Rights Reserved.
 *
 * @author Michael
 * @description Token 拦截器
 * @date 10/24/2018
 * @email 2751358839@qq.com
 */
@Configuration
public class TokenInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HttpServletRequest request;




    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub
    }


    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub


    }

    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {


        logger.info("http>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        //请求信息
        logger.info("Method={}", request.getMethod());
        String requestUrl = request.getRequestURL().toString();
        logger.info("RequestURL={}", requestUrl);
        logger.info("Protocol={}", request.getProtocol());
        logger.info("CharacterEncoding={}", request.getCharacterEncoding());
        logger.info("srcHost:Port={}", request.getRemoteHost() + ":" + request.getRemotePort());
        //请求参数
        logger.info("QueryString= {}", request.getQueryString());
       // logger.info("ParameterMap = {}", JSON.toJSONString(request.getParameterMap()));


        String token = request.getParameter("token");
        //TOKEN 校验：
//        if (!tokenService.verifyToken(token)) {
//            logger.error("ERROR:token 错误-------：{}", token);
//            arg1.setStatus(200);
//            arg1.setCharacterEncoding("UTF-8");
//            arg1.setHeader("content-type", "application/json;charset=UTF-8");
//            PrintWriter out = null;
//
//            try {
//                ApiResult result = new ApiResult(ResultCode.TOKEN_ERROR, null);
//                out = arg1.getWriter();
//                out.append(JSON.toJSONString(result));
//            } catch (IOException e) {
//                logger.error(e.toString());
//
//            } finally {
//                if (out != null) {
//                    out.close();
//                }
//            }
//            return false;
//        }

//        logger.info("http<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return true;
    }

}
