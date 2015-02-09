/**
 * 
 */
package com.comdosoft.union.api;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
        try{
            if(list.size()>0){
                sysResponse = SysResponse.buildSuccessResponse(list);
                int total = downloadService.getTotal();
                sysResponse.setTotal(total);
           }else{
               logger.debug("相关下载没有找到数据列表");
                sysResponse = SysResponse.buildFailResponse("没有找到相关数据");
           }
        }catch(Exception e){
            return SysResponse.buildFailResponse("请求失败");
        }
        return sysResponse;
    }
    
    @RequestMapping(value = "ioslist", method = RequestMethod.GET)
    public ModelAndView  ioslist(Model model){
        ModelAndView mv = new ModelAndView();  
        List<Downloads> list = downloadService.findAll();
        mv.addObject("list", list);  
        mv.setViewName("download");  
        return mv;  
    }
    
}
