package com.comdosoft.union.service.merchant;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.Branch;
import com.comdosoft.union.bean.app.Merchant;
import com.comdosoft.union.dao.merchant.BranchMapper;
import com.comdosoft.union.dao.merchant.MerchantMapper;
/**
 * 商户
 * <br>
 * <功能描述>
 *
 * @author gch 2015年1月19日
 *
 */
@Service
public class MerchantService {

    @Resource
    private MerchantMapper merchantMapper;
    @Resource
    private BranchMapper BranchMapper;
    
    public List<Merchant> findAllMerchants(int offset,int limit,Integer merType_id) {
        if(offset<=0)  
            offset = 1;  
        offset = (offset-1)*10;
        if(null == merType_id){
            return merchantMapper.findAllMerchants(new RowBounds(offset, limit)); 
        }
        return merchantMapper.findMerchantsByType(new RowBounds(offset, limit),merType_id);
    }
    
    public int countByVo(Merchant merchant){
        return merchantMapper.countByVo(merchant);
    }
    
    public Merchant findById(Integer id){
        return merchantMapper.findById(id);
    }
    public List<Branch> findByMerId(Integer mid,String locate){
        return BranchMapper.findByMerId(mid,locate);
    }
}
