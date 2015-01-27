package com.comdosoft.union.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.Area;
import com.comdosoft.union.dao.merchant.AreaMapper;
/**
 * 地区
 * <功能描述>
 * @author gch 2015年1月19日
 */
@Service
public class AreaService {
    @Resource
    private AreaMapper areaMapper;
    public List<Area> findAll(Area area){
        return areaMapper.findAll(area);
    }

}
