package com.comdosoft.union.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.SysCode;
import com.comdosoft.union.dao.SysCodeMapper;
/**
 * 
 * 根据类型查询所有code,如果存在code,则排除此code<br>
 * <功能描述>
 *
 * @author gch 2015年1月19日
 *
 */
@Service
public class SysCodeService {
    @Resource
    private SysCodeMapper sysCodeMapper;
    public List<SysCode> findAll(String type,String code){
        SysCode sysCode = new SysCode();
        sysCode.setType(type);
        sysCode.setCode(code);
        return sysCodeMapper.findAll(sysCode);
    }

}
