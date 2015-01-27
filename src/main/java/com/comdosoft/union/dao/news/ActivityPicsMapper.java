package com.comdosoft.union.dao.news;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.comdosoft.union.bean.app.ActivityPics;

public interface ActivityPicsMapper {

    List<ActivityPics> findAll(RowBounds rowBounds);

    ActivityPics findById(int id);

}
