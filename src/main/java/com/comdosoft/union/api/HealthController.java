package com.comdosoft.union.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.comdosoft.union.common.MD5Utils;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.service.CityService;
/**
 * 
 * 健康服务<br>
 * <功能描述>
 *
 * @author gch 2015年2月2日
 *
 */
@RestController
@RequestMapping("api/health")
public class HealthController {
    private static final Logger logger = LoggerFactory.getLogger(HealthController.class);
    public static final String POST_URL = "http://116.228.55.124:58030/healthinterface/portal.do";
    public static final String S_KEY = "do3f6m2DJaAJ0Bqa";
    
    @Resource
    private CityService cityService;
    /**
     * 发送post请求获取百事通返回信息
     * @param encode 加密后的字符串
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static List<String> sendPost(String encode) throws IOException, ClassNotFoundException {
        URL postUrl = new URL(POST_URL);
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        String content = "requestdata=" + URLEncoder.encode(encode, "utf-8");
        out.writeBytes(content); 
        out.flush();
        out.close(); // flush and close
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        List<String> contents = new ArrayList<String>();  
        while ((line = reader.readLine()) != null) {
            contents.add(line);
        }
        reader.close();
        connection.disconnect();
        return contents;
    }
    
    /**
     * 查询医院信息
     * @param phone
     * @param offset
     * @param keyword
     * @param request
     * @return
     * @throws Exception 
     * @throws ClassNotFoundException 
     * @throws Exception
     */
    @RequestMapping(value = "findHospital", method = RequestMethod.POST)
    public SysResponse findHospital(@RequestParam(value = "phone", required = false) String phone,
                                    @RequestParam(value = "offset", required = false) String offset, 
                                    @RequestParam(value = "keyword", required = false) String keyword, 
                                    HttpServletRequest request) throws ClassNotFoundException, Exception, Exception{
        SysResponse sysResponse = new SysResponse();
//        try{
            Map<String, Object> map1 = getAll("20001",phone, offset, keyword); 
            sysResponse = getHospital(map1);
            return sysResponse;
//        }catch(Exception e){
//            logger.debug("findHospital 出错==》"+e);
//            sysResponse.setCode(-1);;
//            sysResponse.setMessage("缺少必要参数");
//            return sysResponse;
//        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private SysResponse getHospital(Map<String, Object> map1) {
        SysResponse sysResponse = new SysResponse();
        List<Object> list_obj = new LinkedList<Object>();
        Map<String,Object> map_obj = null;
        String total = null;
        for (Object o : map1.entrySet()) { 
            Map.Entry<String,Object> entry = (Map.Entry<String,Object>)o; 
            if(entry.getKey().equals("items")){ //医院信息对象数组
                Object obj2 =  entry.getValue();
                String s = JSONObject.toJSONString(obj2,true);
                JSONArray jsonArray = JSON.parseArray(s); 
                for (Object o2 : jsonArray) { 
                  Map map2 = (Map) o2; 
                  map_obj = new HashMap<String,Object>();
                  for (Object oo : map2.entrySet()) { 
                    Map.Entry<String,Object> en = (Map.Entry<String,Object>)oo; 
                    if(en.getKey().equals("hospitalid")){
                        String id = (String) en.getValue();
                        map_obj.put("hospitalid", id);
                    }
                    if(en.getKey().equals("hospitalleve")){
                        String lev = (String) en.getValue();
                        map_obj.put("hospitalleve", lev);
                    }
                    if(en.getKey().equals("hospitalname")){
                        String name = (String) en.getValue();
                        map_obj.put("hospitalname", name);
                    }
                    if(en.getKey().equals("cpid")){
                        map_obj.put("cpid", en.getValue());
                    }
                  }
                  list_obj.add(map_obj);
                } 
            }
            if(entry.getKey().equals("totalrecord")){
                String v = (String) entry.getValue();
                total = v;
            }
        }
        sysResponse.setTotal(Integer.parseInt(total));
        sysResponse.setResult(list_obj);
        return sysResponse;
    }
    
    /**
     * 查询所有科室信息
     * @param phone
     * @param offset
     * @param keyword
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findSection", method = RequestMethod.POST)
    public SysResponse findSection(@RequestParam(value = "phone", required = false) String phone,
                                    @RequestParam(value = "offset", required = false) String offset, 
                                    @RequestParam(value = "keyword", required = false) String keyword, 
                                    HttpServletRequest request) throws Exception{
        SysResponse sysResponse = new SysResponse();
        try{
            Map<String, Object> map1 = getAll("20002",phone, offset, keyword); 
            sysResponse = getSection(map1);
            return sysResponse;
        }catch(Exception e){
            logger.debug("findSection 出错==》"+e);
            sysResponse.setCode(-1);;
            sysResponse.setMessage("缺少必要参数");
            return sysResponse;
        }
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private SysResponse getSection(Map<String, Object> map1) {
        SysResponse sysResponse = new SysResponse();
        List<Object> list_obj = new LinkedList<Object>();
        Map<String,Object> map_obj = null;
        String total = null;
        for (Object o : map1.entrySet()) { 
            Map.Entry<String,Object> entry = (Map.Entry<String,Object>)o; 
            if(entry.getKey().equals("items")){ //医院信息对象数组
                Object obj2 =  entry.getValue();
                String s = JSONObject.toJSONString(obj2,true);
                JSONArray jsonArray = JSON.parseArray(s); 
                for (Object o2 : jsonArray) { 
                  Map map2 = (Map) o2; 
                  map_obj = new HashMap<String,Object>();
                  for (Object oo : map2.entrySet()) { 
                    Map.Entry<String,Object> en = (Map.Entry<String,Object>)oo; 
                    if(en.getKey().equals("deptname")){
                        String deptname =  (String) en.getValue();
                        map_obj.put("deptname", deptname);
                    }
                    if(en.getKey().equals("deptnum")){
                        String deptnum = (String) en.getValue();
                        map_obj.put("deptnum", deptnum);
                    }
                    if(en.getKey().equals("cpid")){
                        map_obj.put("cpid", en.getValue());
                    }
                    if(en.getKey().equals("deptid")){
                        String deptid = (String) en.getValue();
                        map_obj.put("deptid", deptid);
                    }
                  }
                  list_obj.add(map_obj);
                } 
            }
            if(entry.getKey().equals("totalrecord")){
                String v = (String) entry.getValue();
                total = v;
            }
        }
        sysResponse.setTotal(Integer.parseInt(total));
        sysResponse.setResult(list_obj);
        return sysResponse;
    }

    /**
     * 根据医院编号和cpid查询科室信息
     * @param phone
     * @param offset
     * @param hospitalid 医院编号
     * @param cpid 返回的cpid号 
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findSectionByHospitalId", method = RequestMethod.POST)
    public SysResponse findSectionByHospitalId(@RequestParam(value = "phone", required = false) String phone,
                                   @RequestParam(value = "offset", required = false) String offset, 
                                   @RequestParam(value = "hospitalid", required = false) String hospitalid, 
                                   @RequestParam(value = "cpid", required = false) String cpid, 
                                   HttpServletRequest request) throws Exception{
        SysResponse sysResponse = new SysResponse();
        Map<String, Object> map1 = null; 
        try{
            map1 = getSection("20003",phone, offset, hospitalid,cpid); 
            sysResponse = getSection(map1);
        }catch(Exception e){
            logger.debug("出错==》"+e);
            sysResponse.setCode(-1);;
            sysResponse.setMessage("缺少必要参数");
            return sysResponse;
        }
        return sysResponse;
    }
    
    /**
     * 查找医生信息  搜索
     * @param phone
     * @param offset
     * @param keyword
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findDoctor", method = RequestMethod.POST)
    public SysResponse findSearchDoctor(@RequestParam(value = "phone", required = false) String phone,
                                               @RequestParam(value = "offset", required = false) String offset, 
                                               @RequestParam(value = "keyword", required = false) String keyword, 
                                               HttpServletRequest request) throws Exception{
        SysResponse sysResponse = new SysResponse();
        Map<String, Object> map1 = null; 
        try{
            map1 = getAll("20004",phone, offset, keyword); 
            sysResponse = getSearchDoctor(map1);
        }catch(Exception e){
            logger.debug("出错==》"+e);
            sysResponse.setCode(-1);;
            sysResponse.setMessage("缺少必要参数");
            return sysResponse;
        }
        return sysResponse;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private SysResponse getSearchDoctor(Map<String, Object> map1) {
        SysResponse sysResponse = new SysResponse();
        List<Object> list_obj = new LinkedList<Object>();
        Map<String,Object> map_obj = null;
        String total = null;
        for (Object o : map1.entrySet()) { 
            Map.Entry<String,Object> entry = (Map.Entry<String,Object>)o; 
            if(entry.getKey().equals("items")){ //医院信息对象数组
                Object obj2 =  entry.getValue();
                String s = JSONObject.toJSONString(obj2,true);
                JSONArray jsonArray = JSON.parseArray(s); 
                for (Object o2 : jsonArray) { 
                  Map map2 = (Map) o2; 
                  map_obj = new HashMap<String,Object>();
                  for (Object oo : map2.entrySet()) { 
                    Map.Entry<String,Object> en = (Map.Entry<String,Object>)oo; 
                    if(en.getKey().equals("docname")){
                        map_obj.put("docname", (String)en.getValue());
                    }
                  }
                  list_obj.add(map_obj);
                } 
            }
            if(entry.getKey().equals("totalrecord")){
                String v = (String) entry.getValue();
                total = v;
            }
        }
        sysResponse.setTotal(Integer.parseInt(total));
        sysResponse.setResult(list_obj);
        return sysResponse;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private SysResponse getDoctor(Map<String, Object> map1) {
        SysResponse sysResponse = new SysResponse();
        List<Object> list_obj = new LinkedList<Object>();
        Map<String,Object> map_obj = null;
        String total = null;
        for (Object o : map1.entrySet()) { 
            Map.Entry<String,Object> entry = (Map.Entry<String,Object>)o; 
            if(entry.getKey().equals("items")){ //医院信息对象数组
                Object obj2 =  entry.getValue();
                String s = JSONObject.toJSONString(obj2,true);
                JSONArray jsonArray = JSON.parseArray(s); 
                for (Object o2 : jsonArray) { 
                  Map map2 = (Map) o2; 
                  map_obj = new HashMap<String,Object>();
                  for (Object oo : map2.entrySet()) { 
                    Map.Entry<String,Object> en = (Map.Entry<String,Object>)oo; 
                    if(en.getKey().equals("docname")){
                        map_obj.put("docname", en.getValue());
                    }
                    if(en.getKey().equals("doclevel")){
                        map_obj.put("doclevel", en.getValue());
                    }
                    if(en.getKey().equals("hospitalname")){
                        map_obj.put("hospitalname", en.getValue());
                    }
                    if(en.getKey().equals("deptname")){
                        map_obj.put("deptname", en.getValue());
                    }
                    if(en.getKey().equals("docimageurl")){
                        map_obj.put("docimageurl", en.getValue());
                    }
                    if(en.getKey().equals("cpid")){
                        map_obj.put("cpid", en.getValue());
                    }
                    if(en.getKey().equals("docid")){
                        map_obj.put("docid", en.getValue());
                    }
                  }
                  list_obj.add(map_obj);
                } 
            }
            if(entry.getKey().equals("totalrecord")){
                String v = (String) entry.getValue();
                total = v;
            }
        }
        sysResponse.setTotal(Integer.parseInt(total));
        sysResponse.setResult(list_obj);
        return sysResponse;
    }

    /**
     * 根据科室编号查找医生信息
     * @param phone
     * @param offset
     * @param hospitalid
     * @param deptid
     * @param cpid
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findDoctorByDeptId", method = RequestMethod.POST)
    public SysResponse findDoctorByDeptId(@RequestParam(value = "phone", required = false) String phone,
                                   @RequestParam(value = "offset", required = false) String offset, 
                                   @RequestParam(value = "hospitalid", required = false) String hospitalid, 
                                   @RequestParam(value = "deptid", required = false) String deptid, 
                                   @RequestParam(value = "cpid", required = false) String cpid, 
                                   HttpServletRequest request) throws Exception{
        SysResponse sysResponse = new SysResponse();
        Map<String, Object> map1 = null; 
        try{
            map1 = getDoctor("20005",phone, offset, hospitalid,cpid,deptid); 
            sysResponse = getDoctor(map1);
            return sysResponse;
        }catch(Exception e){
            logger.debug("出错==》"+e);
            sysResponse.setCode(-1);;
            sysResponse.setMessage("缺少必要参数");
            return sysResponse;
        }
    }

    /**
     * 根据科室编号查找医生信息
     * @param string
     * @param phone
     * @param offset
     * @param hospitalid
     * @param cpid
     * @param deptid
     * @return
     * @throws Exception 
     */
   private Map<String, Object> getDoctor(String fun, String phone, String offset, String hospitalid, String cpid, String deptid) throws Exception {
       if (null == phone)  phone = "0";
       if (null == offset) offset = "0";
       String sid = "sid=42&functionid="+fun+"&guid="+phone+"&areaid=310000&hospitalid="+hospitalid+"&cpid="+cpid+"&deptid="+deptid+"&currentpage="+offset+"&pagesize=10";
       String sign = MD5Utils.MD5(sid);
       String src = sid+"&sign="+sign;
       String encode = MD5Utils.AES(src, S_KEY);
       
       List<String> obj = sendPost(encode);
       String json =  obj.get(1);
       Map<String,Object> map1 = JSON.parseObject(json);
       return map1;
    }

/**
    * 根据医院编号和cpid查询科室信息
    * @param fun
    * @param phone
    * @param offset
    * @param hospitalid
    * @param cpid
    * @return
    * @throws Exception
    */
    private Map<String, Object> getSection(String fun, String phone, String offset, String hospitalid, String cpid) throws Exception {
        if (null == phone)  phone = "0";
        if (null == offset) offset = "0";
        String sid = "sid=42&functionid="+fun+"&guid="+phone+"&areaid=310000&hospitalid="+hospitalid+"&cpid="+cpid+"&currentpage="+offset+"&pagesize=10";
        String sign = MD5Utils.MD5(sid);
        String src = sid+"&sign="+sign;
        String encode = MD5Utils.AES(src, S_KEY);
        
        List<String> obj = sendPost(encode);
        String json =  obj.get(1);
        Map<String,Object> map1 = JSON.parseObject(json);
        return map1;
    }

    private Map<String, Object> getAll(String fun,String phone, String offset, String keyword) throws Exception, IOException, ClassNotFoundException {
        if (null == phone)  phone = "0";
        if (null == offset) offset = "0";
        if(null == keyword) keyword="";
        String sid = "sid=42&functionid="+fun+"&guid="+phone+"&areaid=310000&keyword="+keyword+"&currentpage="+offset+"&pagesize=10";
        String sign = MD5Utils.MD5(sid);
        String src = sid+"&sign="+sign;
        String encode = MD5Utils.AES(src, S_KEY);
        
        List<String> obj = sendPost(encode);
        String json =  obj.get(1);
        Map<String,Object> map1 = JSON.parseObject(json);
        return map1;
    }
    
    /**
     * 查询所有省市
     * @param offset
     * @return
     */
    @RequestMapping(value="findAllCity",method=RequestMethod.POST)
    public SysResponse findAllCity(){
        SysResponse sysResponse = new SysResponse();
        List<Object> citys = cityService.findAll();
        sysResponse.setResult(citys);
        sysResponse.setCode(0);
        return sysResponse;
    }
    
}
