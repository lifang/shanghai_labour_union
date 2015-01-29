package com.comdosoft.union.service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Hex;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import com.comdosoft.union.bean.app.User;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.dao.news.UserMapper;

@SuppressWarnings("deprecation")
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Resource
    private UserMapper userMapper;

    /**
     * 根据手机号发送验证码
     * @param phone
     * @return
     * @throws UnsupportedEncodingException 
     */
    public String getCode(String phone) throws UnsupportedEncodingException {
        String code = sendMsg(phone);
        return code;
    }
    

    /**
     * 注册
     * @param user
     * @return
     */
    public SysResponse regist(User user) {
        SysResponse sysResponse = null;
        if(null == user.getUsername()){
            sysResponse = SysResponse.buildFailResponse("请填写用户名");
            return sysResponse;
        }
        User u = new User();
        u = userMapper.findByName(user.getUsername());
        if(null != u ){
            sysResponse = SysResponse.buildFailResponse("用户名已存在");
        }else{
            if(null == user.getPassword()){
                sysResponse = SysResponse.buildFailResponse("请填写密码");
                return sysResponse;
            }
            if(null == user.getPhone()){
                sysResponse = SysResponse.buildFailResponse("请填写手机号");
                return sysResponse;
            }
            try{
                User uu = userMapper.findByPhone(user.getPhone());
                uu.setUsername(user.getUsername());
                uu.setPassword(user.getPassword());
                userMapper.update(uu);
                sysResponse = SysResponse.buildSuccessResponse(uu);
            }catch(Exception e){
                logger.debug("注册失败"+e);
                sysResponse = SysResponse.buildExceptionResponse("注册失败");
            }
        }
        return sysResponse;
    }

    public SysResponse update(User user) {
        SysResponse sysResponse = null;
        try{
            //根据id更新
            String email = user.getEmail() == null ? "" : user.getEmail();
            String code = user.getLabourUnionCode() == null ? "" : user.getLabourUnionCode();
            String username = user.getUsername() == null ? "" : user.getUsername();
            String phone = user.getPhone() == null ? "" : user.getPhone();
            String password = user.getPassword() == null ? "" : user.getPassword();
            String id = user.getId()==null ?"":user.getId().toString();
            user = userMapper.findById(Integer.parseInt(id));
            if("" != email){
                user.setEmail(email);
            }
            if("" != code){
                user.setLabourUnionCode(code);
            }
            if("" != username){
                user.setUsername(username);
            }
            if("" != phone){
                user.setPhone(phone);
            }
            if("" != password){
                user.setPassword(password);
            }
            if("" == id){
                logger.debug("更新用户时丢失id,更新失败");
                SysResponse.buildExceptionResponse("更新失败");
            }
            userMapper.update(user);
            sysResponse = SysResponse.buildSuccessResponse(user);
        }catch(Exception e){
            logger.debug("更新用户出错:"+e);
            sysResponse = SysResponse.buildExceptionResponse("用户更新失败");
        }
        return sysResponse;
    }

    public User findEntityById(Integer id) {
        User user = userMapper.findById(id);
        return user;
    }

    public SysResponse login(User user) {
        User u = userMapper.login(user);
        SysResponse sysResponse =null;
        if(null !=u){
            sysResponse = SysResponse.buildSuccessResponse(u);
        }else{
            sysResponse = SysResponse.buildFailResponse("用户名或密码错误");
        }
        return sysResponse;
    }
    /**
     * 根据手机号返回验证码
     * @param phone
     * @return
     */
    public String sendMsg(String phone){
        String mtUrl="http://esms2.etonenet.com/sms/mt";
      //操作命令、SP编号、SP密码，必填参数
        String command = "MT_REQUEST";
        String spid = "5088";
        String sppassword = "shzgh123";
        //sp服务代码，可选参数，默认为 00
        String spsc = "00";
        //源号码，可选参数
        String sa = "10";
        //目标号码，必填参数
        String da = "86"+phone;
        //下行内容以及编码格式，必填参数
        int dc = 15;
        
        char[] randomChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            stringBuffer.append(randomChar[Math.abs(random.nextInt()) % randomChar.length]);
        }
        String mobilecode = stringBuffer.toString();
        String sm = encodeHexStr(dc, "您的工会验证代码为 "+mobilecode);//下行内容进行Hex编码，此处dc设为15，即使用GBK编码格式

        //组成url字符串
        String smsUrl = mtUrl + "?command=" + command + "&spid=" + spid + "&spsc=" + spsc +"&sppassword=" + sppassword +  "&sa=" + sa + "&da=" + da  + "&dc=" + dc+ "&sm=" + sm;
        logger.debug("smsUrl:"+smsUrl);
        //发送http请求，并接收http响应
        String resStr = doGetRequest(smsUrl.toString());
        logger.debug("smsUrl返回字符串："+resStr);
        return mobilecode;
    }
    
    /**
     * 将普通字符串转换成Hex编码字符串
     * 
     * @param dataCoding 编码格式，15表示GBK编码，8表示UnicodeBigUnmarked编码，0表示ISO8859-1编码
     * @param realStr 普通字符串
     * @return Hex编码字符串
     * @throws UnsupportedEncodingException 
     */
    public static String encodeHexStr(int dataCoding, String realStr) {
        String hexStr = null;
        if (realStr != null) {
            try {
                if (dataCoding == 15) {
                    hexStr = new String(Hex.encodeHex(realStr.getBytes("GBK")));
                } else if ((dataCoding & 0x0C) == 0x08) {
                    hexStr = new String(Hex.encodeHex(realStr.getBytes("UnicodeBigUnmarked")));
                } else {
                    hexStr = new String(Hex.encodeHex(realStr.getBytes("ISO8859-1")));
                }
            } catch (UnsupportedEncodingException e) {
                System.out.println(e.toString());
            }
        }
        return hexStr;
    }
    
    /**
     * 发送http GET请求，并返回http响应字符串
     * 
     * @param urlstr 完整的请求url字符串
     * @return
     */
    @SuppressWarnings({ "rawtypes", "resource" })
    public static String doGetRequest(String urlstr) {
        HttpClient client = new DefaultHttpClient();
        client.getParams().setIntParameter("http.socket.timeout", 10000);
        client.getParams().setIntParameter("http.connection.timeout", 5000);
        
        HttpEntity entity = null;
        String entityContent = null;
        try {
            HttpGet httpGet = new HttpGet(urlstr.toString());

            HttpResponse httpResponse = client.execute(httpGet);
            entityContent = EntityUtils.toString(httpResponse.getEntity());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entity != null) {
                try {
                    ((org.apache.http.HttpEntity) entity).consumeContent();
                } catch (Exception e) {
                }
            }
        }
        return entityContent;
    }


    public User findByPhone(String phone) {
        User u = userMapper.findByPhone(phone);
        return u;
    }


    public int insertCode(User user) {
        return userMapper.insertCode(user);
    }


    public void updateCode(User u) {
        userMapper.updateCode(u);
    }

    /**
     * 根据id 更新手机号
     * @param user
     * @param verify_code 
     * @return
     */
    public SysResponse updatePhone(User user, String verify_code) {
        User u = userMapper.findById(user.getId());
        SysResponse sysResponse = null;
        if(u.getPhoneCode().equals(verify_code)){
            u.setPhone(user.getPhone());
            userMapper.update(u);
            sysResponse = SysResponse.buildSuccessResponse(u);
        }else{
            sysResponse = SysResponse.buildFailResponse("验证码错误");
        }
        return sysResponse;
    }
}
