package com.comdosoft.union.dao.merchant;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.comdosoft.union.bean.app.Merchant;

public interface MerchantMapper {

    int countByVo(Merchant merchant);
    List<Merchant> findAllMerchants(RowBounds rowBounds ,Merchant merchant);
    Merchant findById(Integer id);
}
