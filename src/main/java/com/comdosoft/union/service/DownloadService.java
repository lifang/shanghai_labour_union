package com.comdosoft.union.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.Downloads;
import com.comdosoft.union.dao.news.DownloadsMapper;

@Service
public class DownloadService {
    @Resource
    private DownloadsMapper downloadsMapper;

    /**
     * 列出所有应用
     * @return
     */
    public List<Downloads> findAll() {
        return downloadsMapper.findAll();
    }

    public int getTotal() {
        return downloadsMapper.countByVo();
    }

}
