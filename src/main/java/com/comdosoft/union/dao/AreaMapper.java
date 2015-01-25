package com.comdosoft.union.dao;

import java.util.List;

import com.comdosoft.union.bean.app.Area;

/**
 * 
 * 区域<br>
 * <功能描述>
 *
 * @author gch 2015年1月19日
 *
 */
public interface AreaMapper {
    /**
     * @param id 排除这个id
     * @return
     */
    List<Area> findAll(Area area);
}
