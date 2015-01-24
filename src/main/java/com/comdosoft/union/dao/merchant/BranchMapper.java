package com.comdosoft.union.dao.merchant;

import java.util.List;

import com.comdosoft.union.bean.app.Branch;
/**
 * 
 * 分店<br>
 * <功能描述>
 *
 * @author gch 2015年1月24日
 *
 */
public interface BranchMapper {
    List<Branch> findByMerId(Integer id,String locate);
}
