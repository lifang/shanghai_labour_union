package com.comdosoft.union.dao.news;

import java.util.List;

import com.comdosoft.union.bean.app.Downloads;

/**
 * 
 * 相关下载<br>
 * <功能描述>
 *
 * @author gch 2015年1月22日
 *
 */
public interface DownloadsMapper {
    int countByVo();
    List<Downloads> findAll();
    Object getVersion();

}
