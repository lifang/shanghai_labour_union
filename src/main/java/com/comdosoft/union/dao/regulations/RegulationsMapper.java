package com.comdosoft.union.dao.regulations;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.comdosoft.union.bean.PageRequest;
import com.comdosoft.union.bean.app.Regulations;

public interface RegulationsMapper {
	
	/**
	 * 记录总数
	 * @return
	 */
	Long countByTitle(@Param("title") String title);

	/**
	 * 根据title分页查询
	 * @param title
	 * @param pageRequest
	 * @return
	 */
	List<Regulations> pageByTitle(String title,PageRequest pageRequest);
}
