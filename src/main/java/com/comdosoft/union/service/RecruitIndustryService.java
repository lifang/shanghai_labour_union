package com.comdosoft.union.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.RecruitIndustry;
import com.comdosoft.union.dao.RecruitIndustryMapper;
/**
 * 
 * 招聘行业<br>
 * <功能描述>
 *
 * @author gch 2015年1月19日
 *
 */
@Service
public class RecruitIndustryService {
    @Autowired
    private RecruitIndustryMapper recruitIndustryMapper;

    public List<RecruitIndustry> findAll() {
        return  recruitIndustryMapper.findAll();
    }

    public List<RecruitIndustry> search(int parseInt, Integer limit, String title) {
        // TODO Auto-generated method stub
        return recruitIndustryMapper.search();
    }
}
