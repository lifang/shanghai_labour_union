package com.comdosoft.union.dao.merchant;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.comdosoft.union.bean.app.Merchant;
import com.comdosoft.union.bean.app.MerchantType;

public interface MerchantMapper {

    int countByVo(MerchantType merchantType);
    List<Merchant> findAllMerchants(RowBounds rowBounds);
    List<Merchant> findMerchantsByType(RowBounds rowBounds ,Integer id);
    Merchant findById(Integer id);
}
