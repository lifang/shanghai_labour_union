package com.comdosoft.union.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.Tcardcx;
import com.comdosoft.union.bean.app.XzType;
import com.comdosoft.union.dao.news.TcardcxMapper;

@Service
public class TcardcxService {

    @Resource
    private TcardcxMapper tcardcxMapper;
    
    public List<XzType> findAll(int offset,int limit,Tcardcx tcardcx, String type) {
        if(offset<=0)  
            offset = 1;  
        offset = (offset-1)*limit;
        
        if(null != type){ 
            if( type.equals("0")){ //退休
                return tcardcxMapper.findRetireAll(new RowBounds(offset, limit),tcardcx);
            }else{//在职
                return tcardcxMapper.findStaffAll(new RowBounds(offset, limit));
            }
        }else{
            return tcardcxMapper.searchAll(new RowBounds(offset, limit));//默认展示列
        }
    }
    
    public int countByZZ(Tcardcx tcardcx){
        return tcardcxMapper.countByZZ(tcardcx);
    }
    
    public int countByLZ(Tcardcx tcardcx){
        return tcardcxMapper.countByLZ(tcardcx);
    }
    
    public XzType findById(Integer id){
        return tcardcxMapper.findById(id);
    }

    public List<XzType> search(int offset, Integer limit, String name,String type) {
        if(offset<=0)  
            offset = 1;  
        offset = (offset-1)*limit;
        if(null != name || !"".equals(name)){
            try {
                name = URLDecoder.decode(name, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if(type.equals("0")){
            return tcardcxMapper.searchlz(new RowBounds(offset, limit),name);
        }else{
            return tcardcxMapper.searchzz(new RowBounds(offset, limit),name);
        }
    }

    public int countByAll(Tcardcx tcardcx) {
        int i = tcardcxMapper.countByLZ(tcardcx);
        int j = tcardcxMapper.countByZZ(tcardcx);
        return i+j;
    }
}
