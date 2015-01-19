package com.comdosoft.union.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.ActivityPics;
import com.comdosoft.union.dao.ActivityPicsMapper;
/**
 * 活动图片
 * <br>
 * <功能描述>
 *
 * @author gch 2015年1月19日
 *
 */
@Service
public class ActivityService {
    @Resource
    private ActivityPicsMapper activityPicsMapper;

    public List<ActivityPics> findAll(int i, int j) {
        return  activityPicsMapper.findAll(new RowBounds(i, j));
    }

    public ActivityPics findById(int id) {
        return activityPicsMapper.findById(id);
    }
}
