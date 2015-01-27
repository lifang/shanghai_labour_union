package com.comdosoft.union.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.ProtectRight;
import com.comdosoft.union.dao.news.ProtectRightMapper;

@Service
public class ProtectRightService {
	
	@Autowired
	private ProtectRightMapper protectRightMapper;
	
	public void registProtectRight(ProtectRight protectRight){
		protectRight.setAddtime(new Date());
		protectRightMapper.insertProtectRight(protectRight);
	}

}
