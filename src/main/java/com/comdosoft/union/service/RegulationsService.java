package com.comdosoft.union.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.Page;
import com.comdosoft.union.bean.PageRequest;
import com.comdosoft.union.bean.app.Regulations;
import com.comdosoft.union.common.SysConstant;
import com.comdosoft.union.dao.news.RegulationsMapper;

@Service
public class RegulationsService {
	
	@Autowired
	private RegulationsMapper regulationsMapper;
	
	/**
	 * 分页每页数量
	 */
	private int pageSize = SysConstant.ROWS;

	/**
	 * 法规分页查询
	 * @param page
	 * @param title
	 * @return
	 */
	public Page<Regulations> getPage(int page,String title){
	    if(null != title){
	        try {
                title = URLDecoder.decode(title, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
	    }
		long count = regulationsMapper.countByTitle(title);
		PageRequest request = new PageRequest(page, pageSize);
		List<Regulations> result = regulationsMapper.pageByTitle(title, request);
		return new Page<Regulations>(request, result, count);
	}
	
	public Regulations getInfo(Integer id) {
		return regulationsMapper.find(id);
	}
}
