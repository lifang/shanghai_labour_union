package com.comdosoft.union.service.merchant;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.Merchant;
import com.comdosoft.union.dao.merchant.MerchantMapper;

@Service
public class MerchantService {

    @Resource
    private MerchantMapper merchantMapper;
    
    public List<Merchant> findAllMerchants() {
        return merchantMapper.findAllMerchants();
    }
}
