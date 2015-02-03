package com.comdosoft.union.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comdosoft.union.bean.app.Area;
import com.comdosoft.union.bean.app.Branch;
import com.comdosoft.union.bean.app.Merchant;
import com.comdosoft.union.bean.app.MerchantType;
import com.comdosoft.union.common.BaiduMapUtil;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.service.AreaService;
import com.comdosoft.union.service.merchant.MerchantService;
/**
 * 
 * 商户<br>
 * <功能描述>
 *
 * @author gch 2015年1月19日
 *
 */
@RestController
@RequestMapping("api/merchant")
public class MerchantController {
    private static final Logger logger = LoggerFactory.getLogger(MerchantController.class);
    @Resource
    private MerchantService merchantService;
    @Resource
    private AreaService areaService;
    
    /**
     * 获取商户列表信息 每页10条
     * @param merchant
     * @param offset 页数
     * @return
     */
    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    public SysResponse findAllMerchants(Merchant merchant,String offset,String typeId) {
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
        Integer merType_id = null;
        if(null !=typeId){
            merType_id = Integer.parseInt(typeId);
        }else{
            merType_id = 1;
        }
        List<Merchant> merchants = merchantService.findAllMerchants(Integer.parseInt(offset),10,merType_id);
        sysResponse = putData(sysResponse, merchants,typeId);
        return sysResponse;
    }
    
   /**
    * 根据用户经纬度查询用户所在区域的商家
    * @param merchant  传入当前商户id
    * @param offset  
    * @param per_lon 经度  
    * @param per_lat 纬度
    * @return
    */
    @RequestMapping(value = "findOtherMerchants", method = RequestMethod.POST)
    public SysResponse findOtherMerchants(Merchant merchant,String offset,
                                          String per_lon,String per_lat) {
        SysResponse sysResponse = new SysResponse();
        if(null == per_lon || null == per_lat){
            sysResponse = SysResponse.buildFailResponse("请传入用户经纬度坐标");
            return sysResponse;
        }
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
        List<Area> areaList = areaService.findAll(null);
        Double pn = Double.valueOf(per_lon);
        Double pt = Double.valueOf(per_lat);
        Double temp = 0.0;
        Double small= 200000.0;
        String locate = "";
        for(Area area:areaList){
            Double lat = area.getLatitude();
            Double lon = area.getLongitude();
            temp = BaiduMapUtil.GetShortDistance(pn, pt, lon, lat);
            if(temp < small){
                small = temp;
                locate = area.getName();
            }
        }
        logger.debug("small==>>"+small+" 地区是:"+locate);
        List<Branch> branchList = merchantService.findByMerId(merchant.getId(),locate);
        sysResponse = putBranchData(sysResponse, branchList);
        return sysResponse;
    }
    
    private SysResponse putBranchData(SysResponse sysResponse, List<Branch> branchList) {
        ArrayList<Object> alList = new ArrayList<Object>();
        LinkedHashMap<String, String> map = null;
        if(branchList.size()>0){
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            for (Branch mer : branchList) {
                map = new LinkedHashMap<String,String>();
                map.put("id", mer.getId().toString());
                map.put("name", mer.getName());
                map.put("addr", mer.getAddr());
                alList.add(map);
            }
            sysResponse.setTotal(branchList.size());
            sysResponse.setResult(alList);
        }else{
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("数据不存在,列表为空");
        }
        return sysResponse;
}

    /**
     * 获取某个商户的信息
     * @param id
     * @return
     */
    @RequestMapping(value = "findById", method = RequestMethod.POST)
    public SysResponse findById(String id){
        SysResponse sysResponse = new SysResponse();
        try {
            Merchant merchant = merchantService.findById(Integer.parseInt(id));
            LinkedHashMap<String, String> map = null;
            if(null != merchant){
                    map = new LinkedHashMap<String,String>();
                    map.put("id", merchant.getId().toString());
                    map.put("name", merchant.getDwmc());
                    map.put("addr", merchant.getSymd());
                    map.put("tel", merchant.getTel());
                    map.put("about", merchant.getYhhd1());//单位介绍
                sysResponse.setResult(map);
            }else{
                sysResponse.setCode(SysResponse.FAILURE);
                sysResponse.setMessage("数据不存在,列表为空");
            }
        } catch (Exception e) {
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("请求失败");
            logger.debug("根据id查商户,请求失败,id="+id+" "+e);
        }
        
        return sysResponse;
    }
    
    private SysResponse putData(SysResponse sysResponse, List<Merchant> merchantList, String typeId) {
        ArrayList<Object> alList = new ArrayList<Object>();
        LinkedHashMap<String, String> map = null;
        if(merchantList.size()>0){
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            for (Merchant mer : merchantList) {
                map = new LinkedHashMap<String,String>();
                map.put("id", mer.getId().toString());
                map.put("name", mer.getDwmc());
                map.put("addr", mer.getSymd());
                if(null !=typeId){
                    map.put("tel", mer.getTel());
                    map.put("about", mer.getYhhd1());//简介
                    map.put("about_detail", mer.getYhhd());//简介详情
                }
                map.put("logo", mer.getLogoPath());//logo
                alList.add(map);
            }
            int i = 0;
            MerchantType mt = new MerchantType();
            if(null !=typeId){
                mt.setId(Integer.parseInt(typeId));
                i = merchantService.countByVo(mt);
            }else{
                mt.setId(1);
                i = merchantService.countByVo(mt);
            }
            sysResponse.setTotal(i);
            sysResponse.setResult(alList);
        }else{
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("数据不存在,列表为空");
        }
        return sysResponse;
    }
}
