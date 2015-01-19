package com.comdosoft.union.api;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comdosoft.union.bean.app.ActivityPics;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.service.ActivityService;
/**
 * 
 * 活动图片<br>
 * <功能描述>
 *
 * @author gch 2015年1月19日
 *
 */
@RestController
@RequestMapping("api/activity")
public class ActivityPicsController {
    private static final Logger logger = LoggerFactory.getLogger(ActivityPicsController.class);
    @Resource
    private ActivityService activityService;
    
    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    public SysResponse findAll() {
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

    @RequestMapping(value = "findById", method = RequestMethod.POST)
    public SysResponse findById(String id){
        SysResponse sysResponse = new SysResponse();
        try {
            ActivityPics activityPics = activityService.findById(Integer.parseInt(id));
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            sysResponse.setResult(activityPics);
        } catch (Exception e) {
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("请求失败");
            logger.debug("根据id查活动,请求失败,id="+id+" "+e);
        }
        
        return sysResponse;
    }
}
