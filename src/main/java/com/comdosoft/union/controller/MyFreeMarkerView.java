package com.comdosoft.union.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * 自定义MyFreeMarkerView用来定义项目全局路径<br>
 * <功能描述>
 *
 * @author zengguang
 *
 */
public class MyFreeMarkerView extends FreeMarkerView {

    private static final String CONTEXT_PATH = "basePath";

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.view.freemarker.FreeMarkerView#exposeHelpers(java.util.Map,
     * javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
        model.put(CONTEXT_PATH, basePath);
        super.exposeHelpers(model, request);
    }

}