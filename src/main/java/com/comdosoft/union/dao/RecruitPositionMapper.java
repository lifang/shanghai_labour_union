package com.comdosoft.union.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.comdosoft.union.bean.app.RecruitPosition;

public interface RecruitPositionMapper {
    List<RecruitPosition> findNewJob(RowBounds rowBounds,RecruitPosition recruitPosition);
}
