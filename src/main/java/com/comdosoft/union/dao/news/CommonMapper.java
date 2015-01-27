package com.comdosoft.union.dao.news;

import java.util.List;
import java.util.Map;

import com.comdosoft.union.bean.app.AppPicture;

/**
 * 公共服务数据接口
 * 
 * @author shine
 * 
 */
public interface CommonMapper {

    /**
     * 查询
     * 
     * @param query
     * @return
     */
    List<AppPicture> getPictures(Map<Object, Object> query);

    /**
     * 新增图片
     * 
     * @param bean
     */
    void insertPicture(AppPicture bean);

    /**
     * 新增图片(批量)
     * 
     * @param bean
     */
    void insertPictureBatch(List<AppPicture> list);

    /**
     * 删除图片
     * 
     * @param foreignId
     */
    void removePicture(Map<Object, Object> query);

    int getEnumId(Map<Object, Object> query);

}