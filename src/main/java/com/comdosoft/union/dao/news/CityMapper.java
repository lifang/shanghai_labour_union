package com.comdosoft.union.dao.news;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.comdosoft.union.bean.City;

public interface CityMapper {
    public List<City> findAll();
    public List<City> findAllChildren(@Param("area_id")int area_id);
    public List<City> findAllParent();
}
