package com.comdosoft.union.dao;

import java.util.List;

import com.comdosoft.union.bean.app.SysCode;

/**
 * 
 * 数据字典<br>
 * <功能描述>
 *
 * @author gch 2015年1月19日
 *
 */
public interface SysCodeMapper {
    /**
     * 根据类型查询所有code,如果存在code,则排除此code
     * @param type 类型
     * @param code 排除code
     * @return
     */
    List<SysCode> findAll(SysCode sysCode);
}
