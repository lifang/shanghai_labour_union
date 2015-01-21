package com.comdosoft.union.service.news;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.News;
import com.comdosoft.union.dao.news.NewsMapper;
/**
 * 新闻公告
 * <br>
 * <功能描述>
 *
 * @author gch 2015年1月19日
 *
 */
@Service
public class NewsService {

    @Resource
    private NewsMapper newsMapper;
    
    public List<News> findAll(int offset,int limit,News news) {
        if(offset<=0)
            offset = 1;
        offset = (offset-1)*(limit+4)+4; 
        return newsMapper.findAll(new RowBounds(offset, limit),news);
    }
    
    public int countByVo(News news){
        return newsMapper.countByVo(news);
    }
    
    public News findById(Integer id){
        return newsMapper.findById(id);
    }

    public List<News> search(int offset, Integer limit, String title) {
        if(offset<=0)  
            offset = 1;  
        offset = (offset-1)*limit;
        return newsMapper.search(new RowBounds(offset, limit),title);
    }
    
    /**
     * 查找前面4条新闻信息
     * @param offset 页数
     * @param limit 
     * @return
     */
    public List<News> findTopNews(int offset, Integer limit) {
        if(offset<=0)  
            offset = 1;  
        offset = (offset-1)*(limit+10); 
        return newsMapper.findTopNews(new RowBounds(offset, limit));
    }

	/**根据id查询法规详情
	 * @param parseInt
	 * @return
	 */
	public News findLawsById(int parseInt) {
		 return newsMapper.findLawsById(parseInt);
	}
}
