package com.comdosoft.union.service.student;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.AppStudent;
import com.comdosoft.union.dao.student.StudentMapper;

/**
 * 用户（学生）业务层实现类<br>
 * <功能描述>
 *
 * @author zengguang 2014年12月9日
 *
 */
@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    /**
     * 修改
     * 
     * @param bean
     */
    public void update(AppStudent bean) {
        studentMapper.update(bean);
    }

    /**
     * 查询
     * 
     * @param id
     * @return
     */
    public AppStudent getStudentById(int id) {
        return studentMapper.getStudentById(id);
    }

    /**
     * 查询
     * 
     * @param studentEmail
     *            邮箱
     * @return
     */
    public AppStudent getStudentByStudentEmail(String studentEmail) {
        return studentMapper.getStudentByStudentEmail(studentEmail);
    }

}
