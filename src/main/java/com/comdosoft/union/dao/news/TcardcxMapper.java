package com.comdosoft.union.dao.news;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.comdosoft.union.bean.app.Tcardcx;
import com.comdosoft.union.bean.app.XzType;

public interface TcardcxMapper {

    int countByZZ(Tcardcx tcardcx);
    int countByLZ(Tcardcx tcardcx);
    //在职
    List<XzType> findStaffAll(RowBounds rowBounds);
    //退休
    List<XzType> findRetireAll(RowBounds rowBounds, Tcardcx tcardcx);
    
    XzType findById(Integer id);
    List<XzType> searchAll(RowBounds rowBounds);
    int countBySearch(String csfzh);
    List<XzType> searchzz(RowBounds rowBounds, String csfzh);
    List<XzType> searchlz(RowBounds rowBounds, String csfzh);
//	List<Tcardcx> searchRetire(RowBounds rowBounds, String name);
}
