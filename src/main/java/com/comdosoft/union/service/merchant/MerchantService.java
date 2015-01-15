package com.comdosoft.union.service.merchant;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.Merchant;
import com.comdosoft.union.dao.merchant.MerchantMapper;

@Service
public class MerchantService {

    @Resource
    private MerchantMapper merchantMapper;
    
    public List<Merchant> findAllMerchants(int offset,int limit,Merchant merchant) {
        if(offset<=0)  
            offset = 1;  
        offset = (offset-1)*10;
        return merchantMapper.findAllMerchants(new RowBounds(offset, limit),merchant);
    }
    
    public int countByVo(Merchant merchant){
        return merchantMapper.countByVo(merchant);
    }
    
    public Object findById(Integer id){
        return merchantMapper.findById(id);
    }
}
