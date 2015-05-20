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
		String username = protectRight.getUsername();
		if(null != username){
		    protectRight.setUsername(URLDecoder.decode(username.trim(), "utf-8"));
		}
		String title = protectRight.getTitle();
		if(null != title){
		    protectRight.setTitle(URLDecoder.decode(title.trim(), "utf-8"));
		}
		String address = protectRight.getAddress();
		if(null != address){
		    protectRight.setAddress(URLDecoder.decode(address.trim(), "utf-8"));
		}
		String content = protectRight.getContent();
		if(null != content){
		    protectRight.setContent(URLDecoder.decode(content.trim(), "utf-8"));
		}
		if(null !=protectRight.getMobile()){
			protectRight.setMobile(protectRight.getMobile().trim());
		}
		if(null != protectRight.getEmail()){
			protectRight.setEmail(protectRight.getEmail().trim());
		}
		protectRightMapper.insertProtectRight(protectRight);
	}

}
