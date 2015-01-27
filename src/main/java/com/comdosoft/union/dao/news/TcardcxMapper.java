package com.comdosoft.union.dao.news;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.comdosoft.union.bean.app.Tcardcx;
import com.comdosoft.union.bean.app.XzType;

public interface TcardcxMapper {

    int countByVo(Tcardcx tcardcx);
    //在职
    List<Tcardcx> findStaffAll(RowBounds rowBounds);
    XzType findById(Integer id);
    List<XzType> searchAll(RowBounds rowBounds);
    List<XzType> search(RowBounds rowBounds, String csfzh);
	//退休
	List<Tcardcx> findRetireAll(RowBounds rowBounds, Tcardcx tcardcx);
//	List<Tcardcx> searchRetire(RowBounds rowBounds, String name);
}
