package com.comdosoft.union.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.Tcardcx;
import com.comdosoft.union.bean.app.XzType;
import com.comdosoft.union.dao.tcardcx.TcardcxMapper;

@Service
public class TcardcxService {

    @Resource
    private TcardcxMapper tcardcxMapper;
    
    public List<Tcardcx> findAll(int offset,int limit,Tcardcx tcardcx, String type) {
        if(offset<=0)  
            offset = 1;  
        offset = (offset-1)*limit;
        if(null != type && type.equals("0")){ //退休
        	return tcardcxMapper.findRetireAll(new RowBounds(offset, limit),tcardcx);
        }//在职
        return tcardcxMapper.findAll(new RowBounds(offset, limit),tcardcx);
    }
    
    public int countByVo(Tcardcx tcardcx){
        return tcardcxMapper.countByVo(tcardcx);
    }
    
    public XzType findById(Integer id){
        return tcardcxMapper.findById(id);
    }

    public List<XzType> search(int offset, Integer limit, String name) {
        if(offset<=0)  
            offset = 1;  
        offset = (offset-1)*limit;
        return tcardcxMapper.search(new RowBounds(offset, limit),name);
    }
}
