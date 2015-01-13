package com.comdosoft.union.dao.student;

import com.comdosoft.union.bean.app.AppStudent;

/**
 * 用户（学生）Dao层接口
 * 
 * @author zengguang
 * 
 */
public interface StudentMapper {

    /**
     * 新增
     * 
     * @param bean
     */
    void insert(AppStudent bean);

    /**
     * 修改
     * 
     * @param bean
     */
    void update(AppStudent bean);

    /**
     * 查询
     * 
     * @param id
     * @return
     */
    AppStudent getStudentById(int id);

    /**
     * 查询
     * 
     * @param studentEmail
     *            邮箱
     * @return
     */
    AppStudent getStudentByStudentEmail(String studentEmail);

}