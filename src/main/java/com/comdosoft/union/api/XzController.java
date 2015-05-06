package com.comdosoft.union.api;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.comdosoft.union.bean.app.XzType;
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
@RequestMapping("api/mutualAid")
public class XzController {
    private static final Logger logger = LoggerFactory.getLogger(XzController.class);
    @Resource
    private TcardcxService tcardcxService;

    /**
     * 获取互助保障信息列表
     * 
     * @param tcardcx
     * @param offset
     *            页数
     * @param type
     *            1在职 0 退休 默认在职查询
     * @return
     */
    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    public SysResponse findAll(Tcardcx tcardcx, String offset, String type) {
        Integer limit = 10;
        SysResponse sysResponse = new SysResponse();
        if (null == offset) {
            offset = "0";
        } else {
            Pattern pattern = Pattern.compile("[0-9]*");
            Boolean isNum = pattern.matcher(offset).matches();
            if (!isNum) {
                sysResponse.setCode(SysResponse.FAILURE);
                sysResponse.setMessage("请求失败");
                logger.debug("请求页数错误,页数为：" + offset);
                return sysResponse;
            }
        }
        List<XzType> tcardcxList = tcardcxService.findAll(Integer.parseInt(offset), limit, tcardcx, type);
        if (tcardcxList.size() > 0) {
            HashMap<String, String> map = null;
            ArrayList<Object> list = new ArrayList<Object>();
            for (XzType t : tcardcxList) {
                map = new HashMap<String, String>();
                    map.put("id", t.getId().toString());
                    map.put("name", t.getName());
                    map.put("img", t.getImg());
                    list.add(map);
            }
            int total = 0;
            if (null != type ) { // 退休
                if( type.equals("0")){
                    total = tcardcxService.countByLZ(tcardcx);
                }else{
                    total = tcardcxService.countByZZ(tcardcx);
                }
            } else {
                total = tcardcxService.countByAll(tcardcx);
            }
            sysResponse.setTotal(total);
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            sysResponse.setResult(list);
        } else {
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("查询无结果");
        }
        return sysResponse;
    }

    /**
     * 获取单条信息
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "findById", method = RequestMethod.POST)
    public SysResponse findById(String id) {
        SysResponse sysResponse = new SysResponse();
        try {
            XzType xzType = tcardcxService.findById(Integer.parseInt(id));
            if (null != xzType) {
                sysResponse.setCode(SysResponse.SUCCESS);
                sysResponse.setMessage("请求成功");
                sysResponse.setResult(xzType);
            } else {
                sysResponse.setCode(SysResponse.FAILURE);
                sysResponse.setMessage("数据不存在");
            }
        } catch (Exception e) {
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("请求失败");
            logger.debug("根据id查商户,请求失败,id=" + id + " " + e);
        }

        return sysResponse;
    }

    /**
     * 互助保障
     * 
     * @param title
     *            搜索条件
     * @param offset
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public SysResponse search(@RequestParam(value = "name", required = false) String name, String offset,String type) {
        Integer limit = 10;
        SysResponse sysResponse = new SysResponse();
        if (null == offset) {
            offset = "0";
        } else {
            Pattern pattern = Pattern.compile("[0-9]*");
            Boolean isNum = pattern.matcher(offset).matches();
            if (!isNum) {
                sysResponse.setCode(SysResponse.FAILURE);
                sysResponse.setMessage("请求失败");
                logger.debug("请求页数错误,页数为：" + offset);
                return sysResponse;
            }
        }
        logger.debug("转码前====>>>offset==>"+offset+" name===>>"+name);
        try{
            List<XzType> xzTypeList = tcardcxService.search(Integer.parseInt(offset), limit, name.trim(),type);
            if (xzTypeList.size() > 0) {
                sysResponse.setCode(SysResponse.SUCCESS);
                sysResponse.setMessage("请求成功");
                sysResponse.setTotal(xzTypeList.size());
                sysResponse.setResult(xzTypeList);
            } else {
                sysResponse.setCode(SysResponse.FAILURE);
                sysResponse.setMessage("查询无结果");
            }
            return sysResponse;
        }catch(Exception e){
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("请求失败");
            return sysResponse;
        }
    }
}
