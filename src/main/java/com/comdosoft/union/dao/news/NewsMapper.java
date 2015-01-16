package com.comdosoft.union.dao.news;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.comdosoft.union.bean.app.News;

public interface NewsMapper {

    int countByVo(News news);
    List<News> findAll(RowBounds rowBounds ,News news);
    News findById(Integer id);
}
