package com.comdosoft.union.api;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comdosoft.union.bean.APIRequestParameter;
import com.comdosoft.union.bean.app.Merchant;
import com.comdosoft.union.bean.app.AppStudent;
import com.comdosoft.union.common.SysConstant;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.common.SysToken;
import com.comdosoft.union.service.merchant.MerchantService;
import com.comdosoft.union.service.notification.NotificationService;
import com.comdosoft.union.service.student.StudentService;

/**
 * APP服务接口<br>
 * <功能描述>
 *
 * @author zengguang 2014年12月8日
 * 
 */
@Controller
@RequestMapping(value = "api")
public class APPServiceInterface {

    /**
     * 日志记录器
     */
    private static final Log logger = LogFactory.getLog(APPServiceInterface.class);

    @Resource
    private StudentService studentService;
    
    @Resource
    private MerchantService merchantService;

    @Resource
    private NotificationService notificationService;

    /**
     * 获取商户信息列表 每页10条
     * @param merchant
     * @param offset 页数
     * @return
     */
    @RequestMapping(value = "findAllMerchants", method = RequestMethod.POST)
    @ResponseBody
    public SysResponse findAllMerchants(Merchant merchant,String offset) {
        if(null == offset)offset = "0";
        SysResponse sysResponse = new SysResponse();
        List<Merchant> merchants = merchantService.findAllMerchants(Integer.parseInt(offset),10,merchant);
        sysResponse.setCode(SysResponse.SUCCESS);
        sysResponse.setMessage("请求成功");
        sysResponse.setResult(merchants);
        return sysResponse;
    }
    
    /**
     * [01]用户注册
     * 
     * @param bean
     * @return
     */
    @RequestMapping(value = "studentRegister", method = RequestMethod.POST)
    @ResponseBody
    public SysResponse studentRegister(@RequestBody AppStudent bean) {
        SysResponse sysResponse = new SysResponse();
        try {
            // 判断激活码的有效性
            AppStudent student = studentService.getStudentByStudentEmail(bean.getStudentEmail());
            if (null == student || !student.getActivationCode().equalsIgnoreCase(bean.getActivationCode())) {
                sysResponse.setCode(SysResponse.FAILURE);
                sysResponse.setMessage("用户注册失败:无效的Email帐号或激活码");
            } else if (student.getStudentStatus() == SysConstant.USER_STATUS_2 || student.getStudentStatus() == SysConstant.USER_STATUS_3) {
                sysResponse.setCode(SysResponse.FAILURE);
                sysResponse.setMessage("用户注册失败:您已注册过该账号，请直接登录");
            } else if (StringUtils.isEmpty(bean.getStudentPassword())) {
                sysResponse.setCode(SysResponse.FAILURE);
                sysResponse.setMessage("用户注册失败:注册密码不能为空");
            } else {
                Date now = new Date();
                student.setUpdateTime(now);
                student.setStudentPassword(bean.getStudentPassword());
                student.setStudentMobilePhone(bean.getStudentMobilePhone());
                student.setStudentStatus(SysConstant.USER_STATUS_2);
                studentService.update(student);
                sysResponse.setMessage("用户注册成功");
            }
        } catch (Exception e) {
            logger.error("用户注册失败", e);
            sysResponse.setCode(SysResponse.EXCEPTION);
            sysResponse.setMessage("用户注册失败:系统异常");
        }
        return sysResponse;
    }

    /**
     * [02]用户登录
     * 
     * @param bean
     * @return
     */
    @RequestMapping(value = "studentLogin", method = RequestMethod.POST)
    @ResponseBody
    public SysResponse studentLogin(@RequestBody AppStudent bean, HttpSession session) {
        SysResponse sysResponse = new SysResponse();
        try {
            // 1.判断用户存在与否
            AppStudent student = studentService.getStudentByStudentEmail(bean.getStudentEmail());
            if (null == student || !bean.getStudentPassword().equalsIgnoreCase(student.getStudentPassword())) {// 2.判断密码是否正确
                sysResponse.setCode(SysResponse.FAILURE);
                sysResponse.setMessage("用户登录失败:Email帐号或密码错误");
            } else if (student.getStudentStatus() == SysConstant.USER_STATUS_1) {
                sysResponse.setCode(SysResponse.FAILURE);
                sysResponse.setMessage("用户登录失败:Email帐号尚未激活");
            } else {
                Map<Object, Object> result = new HashMap<Object, Object>();
                result.put("studentId", student.getId());
                result.put("studentEmail", student.getStudentEmail());
                result.put("studentStatus", student.getStudentStatus());
                sysResponse.setResult(result);
                sysResponse.setToken(SysToken.getNewToken(session, student.getId()));

                // 获取登录设备的信息
                student.setPushDeviceType(bean.getPushDeviceType());
                Date now = new Date();
                student.setUpdateTime(now);
                studentService.update(student);
                sysResponse.setMessage("用户登录成功");
            }
        } catch (Exception e) {
            logger.error("用户登录失败", e);
            sysResponse.setCode(SysResponse.EXCEPTION);
            sysResponse.setMessage("用户登录失败:系统异常");
        }
        return sysResponse;
    }

    /**
     * [03]用户退出
     * 
     * @param bean
     * @return
     */
    @RequestMapping(value = "studentLoginOut", method = RequestMethod.POST)
    @ResponseBody
    public SysResponse studentLoginOut(@RequestBody APIRequestParameter bean, HttpSession session) {
        SysResponse sysResponse = new SysResponse();
        try {
            SysToken.removeToken(bean.getToken(), session);
            sysResponse.setMessage("用户退出成功");
        } catch (Exception e) {
            logger.error("用户退出失败", e);
            sysResponse.setCode(SysResponse.EXCEPTION);
            sysResponse.setMessage("用户退出失败:系统异常");
        }
        return sysResponse;
    }

    /**
     * [04]用户信息修改
     * 
     * @param bean
     * @return
     */
    @RequestMapping(value = "studentModification", method = RequestMethod.POST)
    @ResponseBody
    public SysResponse studentModification(@RequestBody AppStudent bean, HttpSession session) {
        SysResponse sysResponse = new SysResponse();
        try {
            if (SysToken.isTokenValid(bean.getToken(), bean.getId(), session)) {
                AppStudent student = studentService.getStudentById(bean.getId());
                if (student == null) {
                    sysResponse.setCode(SysResponse.FAILURE);
                    sysResponse.setMessage("用户信息修改失败:用户不存在");
                } else if (!student.getActivationCode().equals(bean.getActivationCode())) {
                    sysResponse.setCode(SysResponse.FAILURE);
                    sysResponse.setMessage("用户信息修改失败:无效的激活码");
                } else {
                    student.setStudentEmail(bean.getStudentEmail());
                    student.setStudentMobilePhone(bean.getStudentMobilePhone());
                    Date now = new Date();
                    bean.setUpdateTime(now);
                    studentService.update(student);
                    sysResponse.setMessage("用户信息修改成功");
                }
            } else {
                sysResponse.setCode(SysResponse.TOKEN_INVALID);
                sysResponse.setMessage("用户信息修改失败:无效的token");
            }
        } catch (Exception e) {
            logger.error("用户信息修改失败", e);
            sysResponse.setCode(SysResponse.EXCEPTION);
            sysResponse.setMessage("用户信息修改失败:系统异常");
        }
        return sysResponse;
    }

    /**
     * [05]用户修改密码
     * 
     * @param bean
     * @return
     */
    @RequestMapping(value = "studentModifyPassword", method = RequestMethod.POST)
    @ResponseBody
    public SysResponse studentModifyPassword(@RequestBody AppStudent bean, HttpSession session) {
        SysResponse sysResponse = new SysResponse();
        try {
            if (SysToken.isTokenValid(bean.getToken(), bean.getId(), session)) {
                AppStudent student = studentService.getStudentById(bean.getId());
                if (student == null) {
                    sysResponse.setCode(SysResponse.FAILURE);
                    sysResponse.setMessage("用户修改密码失败:用户不存在");
                } else if (!student.getStudentPassword().equalsIgnoreCase(bean.getStudentOldPassword())) {
                    sysResponse.setCode(SysResponse.FAILURE);
                    sysResponse.setMessage("用户修改密码失败:旧密码不正确");
                } else {
                    student.setStudentPassword(bean.getStudentPassword());
                    Date now = new Date();
                    bean.setUpdateTime(now);
                    studentService.update(student);
                    sysResponse.setMessage("用户修改密码成功");
                }
            } else {
                sysResponse.setCode(SysResponse.TOKEN_INVALID);
                sysResponse.setMessage("用户修改密码失败:无效的token");
            }
        } catch (Exception e) {
            logger.error("用户修改密码失败", e);
            sysResponse.setCode(SysResponse.EXCEPTION);
            sysResponse.setMessage("用户修改密码失败:系统异常");
        }
        return sysResponse;
    }

    /**
     * [06]获取推送消息未读数量
     * 
     * @param bean
     * @return
     */
    @RequestMapping(value = "getNotificationUnReadCount", method = RequestMethod.POST)
    @ResponseBody
    public SysResponse getNotificationUnReadCount(@RequestBody APIRequestParameter bean, HttpSession session) {
        SysResponse sysResponse = new SysResponse();
        try {
            if (SysToken.isTokenValid(bean.getToken(), bean.getStudentId(), session)) {
                sysResponse.setResult(notificationService.getNotificationUnReadCount(bean));
                sysResponse.setMessage("获取推送消息未读数量成功");
            } else {
                sysResponse.setCode(SysResponse.TOKEN_INVALID);
                sysResponse.setMessage("获取推送消息未读数量失败:无效的token");
            }
        } catch (Exception e) {
            logger.error("获取推送消息未读数量失败", e);
            sysResponse.setCode(SysResponse.EXCEPTION);
            sysResponse.setMessage("获取推送消息未读数量失败:系统异常");
        }
        return sysResponse;
    }

    /**
     * [07]获取推送消息列表
     * 
     * @param bean
     * @return
     */
    @RequestMapping(value = "getNotifications", method = RequestMethod.POST)
    @ResponseBody
    public SysResponse getNotifications(@RequestBody APIRequestParameter bean, HttpSession session) {
        SysResponse sysResponse = new SysResponse();
        try {
            if (SysToken.isTokenValid(bean.getToken(), bean.getStudentId(), session)) {
                sysResponse.setResult(notificationService.getList(bean));
                sysResponse.setMessage("获取Notification列表成功");
            } else {
                sysResponse.setCode(SysResponse.TOKEN_INVALID);
                sysResponse.setMessage("获取Notification列表失败:无效的token");
            }
        } catch (Exception e) {
            logger.error("获取Notification列表失败", e);
            sysResponse.setCode(SysResponse.EXCEPTION);
            sysResponse.setMessage("获取Notification列表失败:系统异常");
        }
        return sysResponse;
    }

    /**
     * [08]获取推送消息详情
     * 
     * @param bean
     * @return
     */
    @RequestMapping(value = "getNotification", method = RequestMethod.POST)
    @ResponseBody
    public SysResponse getNotification(@RequestBody Map<Object, Object> param, HttpSession session) {
        SysResponse sysResponse = new SysResponse();
        try {
            if (SysToken.isTokenValid(param.get("token").toString(), Integer.parseInt(param.get("studentId").toString()), session)) {
                sysResponse.setResult(notificationService.getOneByConditions(param));
                notificationService.readNotification(param);// 更新通知为已读
                sysResponse.setMessage("获取Notification详情成功");
            } else {
                sysResponse.setCode(SysResponse.TOKEN_INVALID);
                sysResponse.setMessage("获取Notification详情失败:无效的token");
            }
        } catch (Exception e) {
            logger.error("获取Notification详情失败", e);
            sysResponse.setCode(SysResponse.EXCEPTION);
            sysResponse.setMessage("获取Notification详情失败:系统异常");
        }
        return sysResponse;
    }

    /**
     * [09]全部已读推送消息
     * 
     * @param bean
     * @return
     */
    @RequestMapping(value = "readAllNotification", method = RequestMethod.POST)
    @ResponseBody
    public SysResponse readAllNotification(@RequestBody Map<Object, Object> param, HttpSession session) {
        SysResponse sysResponse = new SysResponse();
        try {
            if (SysToken.isTokenValid(param.get("token").toString(), Integer.parseInt(param.get("studentId").toString()), session)) {
                notificationService.readAllNotification(param);
                sysResponse.setMessage("全部已读Notification成功");
            } else {
                sysResponse.setCode(SysResponse.TOKEN_INVALID);
                sysResponse.setMessage("全部已读Notification失败:无效的token");
            }
        } catch (Exception e) {
            logger.error("全部已读Notification失败", e);
            sysResponse.setCode(SysResponse.EXCEPTION);
            sysResponse.setMessage("全部已读Notification失败:系统异常");
        }
        return sysResponse;
    }

}