package com.comdosoft.union.api;

import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
     * 获取新闻信息列表
     * @param news
     * @param offset 页数
     * @return
     */
    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    public SysResponse findAll(News news,String offset) {
        Integer limit = 14;
        if(null != news.getLm3() && news.getLm3().equals("57")){
            limit = 10;//法规查询 每页10条  
        }
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
        List<News> newsList = newsService.findAll(Integer.parseInt(offset),limit,news);
        if(newsList.size()>0){
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            sysResponse.setResult(newsList);
        }else{
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("数据不存在,列表为空");
        }
        
        return sysResponse;
    }
    
    /**
     * 获取单条新闻信息
     * @param id
     * @return
     */
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
    /**
     * 法规查询
     * @param title 搜索条件
     * @param offset
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public SysResponse search(@RequestParam(value="title", required=true) String title,String offset) {
        Integer limit = 10;
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
        List<News> newsList = newsService.search(Integer.parseInt(offset),limit,title);
        if(newsList.size()>0){
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            sysResponse.setResult(newsList);
        }else{
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("数据不存在,列表为空");
        }
        
        return sysResponse;
    }
}
