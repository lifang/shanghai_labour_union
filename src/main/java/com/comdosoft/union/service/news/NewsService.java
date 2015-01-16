package com.comdosoft.union.service.news;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.News;
import com.comdosoft.union.dao.news.NewsMapper;

@Service
public class NewsService {

    @Resource
    private NewsMapper newsMapper;
    
    public List<News> findAll(int offset,int limit,News news) {
        if(offset<=0)  
            offset = 1;  
        offset = (offset-1)*limit;
        return newsMapper.findAll(new RowBounds(offset, limit),news);
    }
    
    public int countByVo(News news){
        return newsMapper.countByVo(news);
    }
    
    public News findById(Integer id){
        return newsMapper.findById(id);
    }
}
