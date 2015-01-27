package com.comdosoft.union.dao.zpdw;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.comdosoft.union.bean.app.RecruitPosition;

public interface RecruitPositionMapper {
    List<RecruitPosition> findNewJob(RowBounds rowBounds,RecruitPosition recruitPosition);

    RecruitPosition findById(Integer id);

	List<RecruitPosition> searchJob(RowBounds rowBounds,	RecruitPosition recruitPosition);

	List<RecruitPosition> findOtherJobById(int id);
}
