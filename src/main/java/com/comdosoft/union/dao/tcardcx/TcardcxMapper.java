package com.comdosoft.union.dao.tcardcx;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.comdosoft.union.bean.app.Tcardcx;

public interface TcardcxMapper {

    int countByVo(Tcardcx tcardcx);
    List<Tcardcx> findAll(RowBounds rowBounds ,Tcardcx tcardcx);
    Tcardcx findById(Integer id);
    List<Tcardcx> search(RowBounds rowBounds, String name);
}
