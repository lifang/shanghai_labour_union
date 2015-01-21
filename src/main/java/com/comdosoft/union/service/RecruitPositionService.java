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
    
    
    public List<RecruitPosition> findNewJob(int offset,int limit,RecruitPosition recruitPosition, int type) {
        if(offset<=0)  
            offset = 1;  
        offset = (offset-1)*limit;
        if(type==1){//搜索
        	return recruitPositionMapper.searchJob(new RowBounds(offset, limit),recruitPosition);
        }
        	return recruitPositionMapper.findNewJob(new RowBounds(offset, limit),recruitPosition);
    }


    public RecruitPosition findById(Integer id) {
        return recruitPositionMapper.findById(id);
    }


	/**
	 * 根据职位Id，查询该职位所在单位的其他职位
	 * @param id 
	 * @return
	 */
	public List<RecruitPosition> findOtherJobById(int id) {
		return recruitPositionMapper.findOtherJobById(id);
	}
}
