package com.comdosoft.union.api;

import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comdosoft.union.bean.app.News;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.service.news.NewsService;

@RestController
@RequestMapping("api/news")
public class NewsController {
    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
    @Resource
    private NewsService newsService;
    
    /**
     * 获取商户信息列表 每页14条
     * @param news
     * @param offset 页数
     * @return
     */
    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    public SysResponse findAll(News news,String offset) {
        SysResponse sysResponse = new SysResponse();
        if(null == offset){
            offset = "0";
        }else{
            Pattern pattern = Pattern.compile("[0-9]*");
            Boolean isNum = pattern.matcher(offset).matches();
            if(!isNum){
                sysResponse.setCode(SysResponse.FAILURE);
                sysResponse.setMessage("请求失败");
                logger.debug("请求页数错误,页数为："+offset);
                return sysResponse;
            }
        }
        List<News> merchants = newsService.findAll(Integer.parseInt(offset),14,news);
        sysResponse.setCode(SysResponse.SUCCESS);
        sysResponse.setMessage("请求成功");
        sysResponse.setResult(merchants);
        return sysResponse;
    }
    
    @RequestMapping(value = "findById", method = RequestMethod.POST)
    public SysResponse findById(String id){
        SysResponse sysResponse = new SysResponse();
        try {
            News news = newsService.findById(Integer.parseInt(id));
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            sysResponse.setResult(news);
        } catch (Exception e) {
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("请求失败");
            logger.debug("根据id查商户,请求失败,id="+id+" "+e);
        }
        
        return sysResponse;
    }
}
