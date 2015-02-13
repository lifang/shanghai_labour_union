package com.comdosoft.union.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.ProtectRight;
import com.comdosoft.union.dao.news.ProtectRightMapper;

@Service
public class ProtectRightService {
	
	@Autowired
	private ProtectRightMapper protectRightMapper;
	
	public void registProtectRight(ProtectRight protectRight) throws UnsupportedEncodingException{
		protectRight.setAddtime(new Date());
		String username = protectRight.getUsername().trim();
		if(null != username){
		    protectRight.setUsername(URLDecoder.decode(username, "utf-8"));
		}
		String title = protectRight.getTitle().trim();
		if(null != title){
		    protectRight.setTitle(URLDecoder.decode(title, "utf-8"));
		}
		String address = protectRight.getAddress().trim();
		if(null != address){
		    protectRight.setAddress(URLDecoder.decode(address, "utf-8"));
		}
		String content = protectRight.getContent().trim();
		if(null != content){
		    protectRight.setContent(URLDecoder.decode(content, "utf-8"));
		}
		protectRight.setMobile(protectRight.getMobile().trim());
		protectRight.setEmail(protectRight.getEmail().trim());
		protectRightMapper.insertProtectRight(protectRight);
	}

}
