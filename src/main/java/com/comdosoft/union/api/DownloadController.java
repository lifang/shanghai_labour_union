/**
 * 
 */
package com.comdosoft.union.api;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comdosoft.union.bean.app.ActivityPics;
import com.comdosoft.union.bean.app.Downloads;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.service.ActivityService;
import com.comdosoft.union.service.DownloadService;
/**
 * 
 * 相关下载<br>
 * <功能描述>
 *
 * @author gch 2015年1月22日
 *
 */
@RestController
@RequestMapping("/api/download")
public class DownloadController {
    private static final Logger logger = LoggerFactory.getLogger(DownloadController.class);
    @Resource
    private DownloadService downloadService;
    @Resource
    private ActivityService activityService;
    /**
     * 展示所有数据
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public SysResponse list(){
        List<Downloads> list = downloadService.findAll();
        SysResponse sysResponse = null;
        if(list.size()>0){
             sysResponse = SysResponse.buildSuccessResponse(list);
             int total = downloadService.getTotal();
             sysResponse.setTotal(total);
        }else{
            logger.debug("相关下载没有找到数据列表");
             sysResponse = SysResponse.buildFailResponse("没有找到相关数据");
        }
        return sysResponse;
    }
    
    @RequestMapping(value = "testGet", method = RequestMethod.GET)
    public SysResponse testGet(HttpServletRequest request){
        logger.debug("get请求测试 ....."+request.getContextPath());
        SysResponse sysResponse = new SysResponse();
        List<ActivityPics> activityList = activityService.findAll(0,4);
        if(activityList.size()>0){
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            sysResponse.setResult(activityList);
        }else{
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("数据不存在,列表为空");
            logger.debug("没有查询到数据");
        }
        
        return sysResponse;
    }
    
    @RequestMapping(value = "testPost", method = RequestMethod.POST)
    public SysResponse testPost(HttpServletRequest request){
        logger.debug("post请求测试 ....."+request.getContextPath());
        SysResponse sysResponse = SysResponse.buildSuccessResponse("测试post请求成功。。。");
        return sysResponse;
    }

}
