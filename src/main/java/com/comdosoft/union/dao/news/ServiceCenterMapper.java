package com.comdosoft.union.dao.news;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.comdosoft.union.bean.PageRequest;
import com.comdosoft.union.bean.app.ServiceCenter;

/**
 * 服务中心接口
 * @author wu
 *
 */
public interface ServiceCenterMapper {

	/**
	 * 职工援助服务中心
	 */
	byte WORKS = 0;
	/**
	 * 法律援助服务中心
	 */
	byte LAW = 1;
	
	/**
	 * 记录总数
	 * @return
	 */
	Long countByBs(@Param("bs") byte bs);
	
	/**
	 * 根据bs分页查询
	 * @param bs
	 * @param pageRequest
	 * @return
	 */
	List<ServiceCenter> pageByBs(byte bs,PageRequest pageRequest);
	
	
	ServiceCenter find(Integer id);
}
