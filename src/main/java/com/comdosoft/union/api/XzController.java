package com.comdosoft.union.api;

import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comdosoft.union.bean.app.Tcardcx;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.service.TcardcxService;
/**
 * 
 * 互助保障<br>
 * <功能描述>
 *
 * @author gch 2015年1月16日
 *
 */
@RestController
@RequestMapping("api/xz")
public class XzController {
    private static final Logger logger = LoggerFactory.getLogger(XzController.class);
    @Resource
    private TcardcxService tcardcxService;
    
    /**
     * 获取互助保障信息列表 
     * @param tcardcx
     * @param offset 页数
     * @return
     */
    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    public SysResponse findAll(Tcardcx tcardcx,String offset) {
        Integer limit = 10;
        SysResponse sysResponse = new SysResponse();
        if(null == offset){
            offset = "0";
        }else{
            Pattern pattern = Pattern.compile("[0-9]*");
            Boolean isNum = pattern.matcher(offset).matches();
            if(!isNum){
                sysResponse.setCode(SysResponse.FAILURE);
                sysResponse.setMessage("请求失败");
                logger.debug("请求页数错误,页数为："+offset);
                return sysResponse;
            }
        }
        List<Tcardcx> tcardcxList = tcardcxService.findAll(Integer.parseInt(offset),limit,tcardcx);
        if(tcardcxList.size()>0){
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            sysResponse.setResult(tcardcxList);
        }else{
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("数据不存在,列表为空");
        }
        
        return sysResponse;
    }
    
    /**
     * 获取单条新闻信息
     * @param id
     * @return
     */
    @RequestMapping(value = "findById", method = RequestMethod.POST)
    public SysResponse findById(String id){
        SysResponse sysResponse = new SysResponse();
        try {
            Tcardcx tcardcx = tcardcxService.findById(Integer.parseInt(id));
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            sysResponse.setResult(tcardcx);
        } catch (Exception e) {
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("请求失败");
            logger.debug("根据id查商户,请求失败,id="+id+" "+e);
        }
        
        return sysResponse;
    }
    /**
     * 互助保障
     * @param title 搜索条件
     * @param offset
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public SysResponse search(@RequestParam(value="name", required=true) String name,String offset) {
        Integer limit = 10;
        SysResponse sysResponse = new SysResponse();
        if(null == offset){
            offset = "0";
        }else{
            Pattern pattern = Pattern.compile("[0-9]*");
            Boolean isNum = pattern.matcher(offset).matches();
            if(!isNum){
                sysResponse.setCode(SysResponse.FAILURE);
                sysResponse.setMessage("请求失败");
                logger.debug("请求页数错误,页数为："+offset);
                return sysResponse;
            }
        }
        List<Tcardcx> tcardcxList = tcardcxService.search(Integer.parseInt(offset),limit,name);
        if(tcardcxList.size()>0){
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            sysResponse.setResult(tcardcxList);
        }else{
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("数据不存在,列表为空");
        }
        
        return sysResponse;
    }
}