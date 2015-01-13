package com.comdosoft.union.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.comdosoft.union.service.CommonService;

@Controller
public class CommonController {

    /**
     * 日志记录器
     */
    private static final Log logger = LogFactory.getLog(CommonController.class);

    @Resource
    private CommonService commonService;

    @RequestMapping(value = "upload/tempImage", method = RequestMethod.POST)
    @ResponseBody
    public String tempImage(MultipartFile img, HttpServletRequest request) {
        String result = null;
        try {
            result = commonService.saveTmpImage(img, request);
        } catch (IOException e) {
            logger.error(e);
            result = "error";
        }
        return result;
    }

    @RequestMapping(value = "upload/cutImage", method = RequestMethod.POST)
    @ResponseBody
    public String cutImage(HttpServletRequest request, String picUrl, String x, String y, String w, String h) {
        String result = null;
        try {
            result = commonService.saveImage(request, picUrl, (int) Float.parseFloat(x), (int) Float.parseFloat(y), (int) Float.parseFloat(w), (int) Float.parseFloat(h));
        } catch (IOException e) {
            logger.error(e);
            result = "error";
        }
        return result;
    }

}