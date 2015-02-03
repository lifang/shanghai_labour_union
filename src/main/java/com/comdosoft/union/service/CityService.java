package com.comdosoft.union.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.City;
import com.comdosoft.union.dao.news.CityMapper;

@Service
public class CityService {
    
    @Resource
    private CityMapper cityMapper;
    
    public List<Object> findAll(){
        List<City> citys = cityMapper.findAllParent();
        List<Object> lists = new LinkedList<Object>();
        Map<String,Object> map = null;
        for(City c:citys){
            map = new HashMap<String,Object>();
            map.put("city_area_id", c.getArea_id());
            map.put("city_name", c.getArea_name());
            List<City> children_citys = cityMapper.findAllChildren(c.getArea_id());
            map.put("childrens",children_citys );
            lists.add(map);
        }
        return lists;
    }
    
}
