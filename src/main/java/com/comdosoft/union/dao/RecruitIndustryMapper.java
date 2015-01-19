package com.comdosoft.union.dao;

import java.util.List;

import com.comdosoft.union.bean.app.RecruitIndustry;
/**
 * 
 * 招聘行业<br>
 * <功能描述>
 *
 * @author gch 2015年1月19日
 *
 */
public interface RecruitIndustryMapper {
    List<RecruitIndustry> findAll();

    List<RecruitIndustry> search();
}
