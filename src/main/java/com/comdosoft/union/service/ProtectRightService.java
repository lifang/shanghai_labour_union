package com.comdosoft.union.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.ProtectRight;
import com.comdosoft.union.dao.ProtectRightMapper;

@Service
public class ProtectRightService {
	
	@Autowired
	private ProtectRightMapper protectRightMapper;
	
	public void registProtectRight(ProtectRight protectRight){
		protectRightMapper.insertProtectRight(protectRight);
	}

}
