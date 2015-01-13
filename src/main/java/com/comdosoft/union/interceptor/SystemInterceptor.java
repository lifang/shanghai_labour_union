/**
 * 
 */
package com.comdosoft.union.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.comdosoft.union.common.SysConstant;

/**
 * 系统总拦截器
 * 
 * @author shine
 * 
 */
public class SystemInterceptor implements HandlerInterceptor {

    private static Log logger = LogFactory.getLog(SystemInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession httpSession = request.getSession();
        int responseStatus = response.getStatus();
        logger.debug("springmvc[preHandle]拦截器入口>>>responseStatus:" + responseStatus + ";httpSession:" + httpSession);

        if (null != httpSession) {
            if (null != httpSession.getAttribute(SysConstant.LOGIN_ADMIN)) {// 管理员已登录
                logger.debug("springmvc[preHandle]拦截器出口>>>admin is logged.");
                return true;
            }
        }
        
        response.sendRedirect(request.getContextPath() + "/");// 重定向至登录页面

        logger.debug("springmvcpreHandle]拦截器出口[>>>admin is not logged.");

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}