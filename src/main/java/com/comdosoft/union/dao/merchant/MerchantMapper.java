package com.comdosoft.union.dao.merchant;

import java.util.List;

import com.comdosoft.union.bean.app.Merchant;

public interface MerchantMapper {

    List<Merchant> findAllMerchants();
}
