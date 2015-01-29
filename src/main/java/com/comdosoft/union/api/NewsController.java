package com.comdosoft.union.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
/**
 * 
 * 新闻公告<br>
 * <功能描述>
 *
 * @author gch 2015年1月19日
 *
 */
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
    @RequestMapping(value = "findTopNews", method = RequestMethod.POST)
    public SysResponse findTopNews(News news,String offset) {
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
        List<News> newsList = newsService.findTopNews(Integer.parseInt(offset),4);
        sysResponse = putData(sysResponse, newsList,1,news);
        return sysResponse;
    }

    /**
     * 
     * @param sysResponse
     * @param newsList
     * @param i 1是滑动图片新闻  
     * @return
     */
    private SysResponse putData(SysResponse sysResponse, List<News> newsList, int i,News news) {
        ArrayList<Object> alList = new ArrayList<Object>();
        LinkedHashMap<String, String> map = null;
        if(newsList.size()>0){
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            for (News news2 : newsList) {
                map = new LinkedHashMap<String,String>();
                map.put("id", news2.getId().toString());
                map.put("title", news2.getTitle());
                map.put("time", news2.getTime() == null ? "": news2.getTime().toString());
                if(i==1)
                    map.put("imgPath", news2.getImgPath());
                alList.add(map);
            }
            int total = newsService.countByVo(news);
            sysResponse.setTotal(total);
            sysResponse.setResult(alList);
        }else{
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("数据不存在,列表为空");
        }
        return sysResponse;
    }
    
    /**
     * 获取新闻信息列表
     * @param news
     * @param offset 页数
     * @return
     */
    @RequestMapping(value = "findNews", method = RequestMethod.POST)
    public SysResponse findNews(News news,String offset) {
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
        List<News> newsList = newsService.findAll(Integer.parseInt(offset),10,news);
        sysResponse = putData(sysResponse, newsList,0,news);
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
            HashMap<String,String> hashMap = null;
            if(null !=news){
                hashMap = new HashMap<String,String>();
                hashMap.put("id", news.getId().toString());
                hashMap.put("title", news.getTitle());
                hashMap.put("content", news.getContent());
                hashMap.put("time", news.getTime().toString());
            }
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            sysResponse.setResult(hashMap);
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
    @RequestMapping(value = "findLaws", method = RequestMethod.POST)
    public SysResponse findLaws(News news,String offset) {
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
        List<News> newsList = newsService.search(Integer.parseInt(offset),limit,news.getTitle());
        if(newsList.size()>0){
        	HashMap<String,String> map = null;
        	ArrayList<Object> list = new ArrayList<Object>();
        	for(News n: newsList){
        		map = new HashMap<String,String>();
        		map.put("id", n.getId().toString());
        		map.put("title", n.getTitle());
        		list.add(map);
        	}
        	news.setLm3("57");
        	int total = newsService.countByVo(news);
        	sysResponse.setTotal(total);
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            sysResponse.setResult(list);
        }else{
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("数据不存在,列表为空");
        }
        return sysResponse;
    }
    
    @RequestMapping(value = "findLawsById", method = RequestMethod.POST)
    public SysResponse findLawsById(String id){
        SysResponse sysResponse = new SysResponse();
        try {
            News news = newsService.findLawsById(Integer.parseInt(id));
            HashMap<String,String> hashMap = null;
            if(null !=news){
                hashMap = new HashMap<String,String>();
                hashMap.put("id", news.getId().toString());
                hashMap.put("title", news.getTitle());
                hashMap.put("content", news.getContent());
                hashMap.put("time", news.getTime().toString());
            }
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            sysResponse.setResult(hashMap);
        } catch (Exception e) {
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("请求失败");
            logger.debug("根据id查商户,请求失败,id="+id+" "+e);
        }
        
        return sysResponse;
    }
    
}
