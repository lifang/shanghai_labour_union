package com.comdosoft.union.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.RecruitPosition;
import com.comdosoft.union.dao.RecruitPositionMapper;

@Service
public class RecruitPositionService {
    @Autowired
    private RecruitPositionMapper recruitPositionMapper;
    
    
    public List<RecruitPosition> findNewJob(int offset,int limit,RecruitPosition recruitPosition) {
        if(offset<=0)  
            offset = 1;  
        offset = (offset-1)*limit;
        return recruitPositionMapper.findNewJob(new RowBounds(offset, limit),recruitPosition);
    }


    public RecruitPosition findById(Integer id) {
        return recruitPositionMapper.findById(id);
    }
}
