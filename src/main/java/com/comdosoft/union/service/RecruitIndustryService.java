package com.comdosoft.union.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.RecruitIndustry;
import com.comdosoft.union.dao.zpdw.RecruitIndustryMapper;
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
    @Resource
    private RecruitIndustryMapper recruitIndustryMapper;

    public List<RecruitIndustry> findAll() {
        return  recruitIndustryMapper.findAll();
    }

}
