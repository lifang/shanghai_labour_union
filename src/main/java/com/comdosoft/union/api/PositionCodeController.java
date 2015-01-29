package com.comdosoft.union.api;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.comdosoft.union.bean.app.RecruitIndustry;
import com.comdosoft.union.bean.app.RecruitPosition;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.common.SysUtils;
import com.comdosoft.union.service.AreaService;
import com.comdosoft.union.service.RecruitIndustryService;
import com.comdosoft.union.service.RecruitPositionService;
/**
 * 
 * 岗位查询<br>
 * <功能描述>
 *
 * @author gch 2015年1月19日
 *
 */
@RestController
@RequestMapping("api/job")
public class PositionCodeController {
    private static final Logger logger = LoggerFactory.getLogger(PositionCodeController.class);
    @Resource
    private RecruitIndustryService recruitIndustryService;
    @Resource
    private AreaService areaService;
    @Resource
    private RecruitPositionService recruitPositionService;
    
    /**
     * 查询所有行业
     * @return
     */
    @RequestMapping(value = "findAllRI", method = RequestMethod.POST)
    public SysResponse findAllRI(){
        SysResponse sysResponse = new SysResponse();
        List<RecruitIndustry> RIList = recruitIndustryService.findAll();
        sysResponse.setTotal(RIList.size());
        sysResponse.setCode(SysResponse.SUCCESS);
        sysResponse.setMessage("请求成功");
        sysResponse.setResult(RIList);
        return sysResponse;
    }
    
   /**
    * 查询所有工作区域,如果存在id,则排除此id
    * @param id
    * @return
    */
    @RequestMapping(value = "findAllAddr", method = RequestMethod.POST)
    public SysResponse findAllAddr(String id){
        SysResponse sysResponse = new SysResponse();
        List<Area> areaList = null;
        if(null ==id || id==""){
            areaList = areaService.findAll(null);
        }else{
            Area area = new Area();
            if(SysUtils.isNum(id)){
                area.setId(Integer.parseInt(id));
                areaList = areaService.findAll(area);
            }else{
                sysResponse.setCode(SysResponse.FAILURE);
                sysResponse.setMessage("id参数错误");
                return sysResponse;
            }
        }
        ArrayList<Object> alList = new ArrayList<Object>();
        LinkedHashMap<String, String> map = null;
        if(areaList.size()>0){
            for (Area area : areaList) {
                map = new LinkedHashMap<String,String>();
                map.put("name", area.getName());
                map.put("id", area.getId().toString());
                alList.add(map);
            }
            sysResponse.setTotal(alList.size());
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            sysResponse.setResult(alList);
        }else{
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("数据不存在,列表为空");
        }
        
        return sysResponse;
    }
    
    /**
     * 最新职位
     * @return
     */
    @RequestMapping(value = "findNewJob", method = RequestMethod.POST)
    public SysResponse findNewJob(RecruitPosition recruitPosition){
        return getJobs("0","5",recruitPosition,0);
    }
    
   /**
    * 根据条件查询所有岗位
    * @param offset
    * @param limit
    * @param recruitPosition
    * @int type 类型  0 全部  1搜索
    * @return
    */
    public SysResponse getJobs(String offset,String limit,RecruitPosition recruitPosition,int type) {
        SysResponse sysResponse = new SysResponse();
        if(null == offset || null == limit){
            offset = "0";
            limit = "10";
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
        try {
            List<RecruitPosition> recruitPositionList = recruitPositionService.findNewJob(Integer.parseInt(offset),Integer.parseInt(limit),recruitPosition,type);
            ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
            HashMap<String,String>  map = null;
            for(RecruitPosition rp :recruitPositionList){
            	map = new HashMap<String,String>();
            	map.put("id", rp.getId().toString());
            	map.put("job_name", rp.getZwmc());
            	map.put("unit_name", rp.getDwid()==null ? "":rp.getDwid().getDwmc());
            	list.add(map);
            }
            int total = recruitPositionService.countByVo(recruitPosition);
            sysResponse.setTotal(total);
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            sysResponse.setResult(list);
        } catch (Exception e) {
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("请求失败");
            logger.debug("获取职位出错:"+e);
        }
        return sysResponse;
    }
    
    
    
    /**
     * 岗位搜索
     *   q 搜索条件  职位 公司 地点
     * @param offset
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public SysResponse search(String offset,RecruitPosition recruitPosition,String q) {
        return getJobs(offset,"10",recruitPosition,1);
    }

    /**
     * 根据id查询实体
     * @param offset
     * @param recruitPosition
     * @return
     */
    @RequestMapping(value = "findById", method = RequestMethod.POST)
    public SysResponse findById(String id){
        SysResponse sysResponse = new SysResponse();
        try {
            RecruitPosition recruitPosition = recruitPositionService.findById(Integer.parseInt(id));
            HashMap<String,String>  map = null;
            if(null != recruitPosition){
            	map = new HashMap<String,String>();
            	map.put("id", recruitPosition.getId().toString());
            	map.put("job_name", recruitPosition.getZwmc());
            	map.put("rs", recruitPosition.getRs()==null ? "":recruitPosition.getRs().toString());
            	map.put("job_about", recruitPosition.getZwms());//职位描述
            	map.put("unit_name", recruitPosition.getDwid()==null ? "":recruitPosition.getDwid().getDwmc());
            	map.put("locate", recruitPosition.getDwid()==null ? "":recruitPosition.getDwid().getLocate());
            	map.put("lxfs", recruitPosition.getDwid()==null ? "":recruitPosition.getDwid().getDwmc());
            	map.put("unit_about", recruitPosition.getDwid()==null ? "":recruitPosition.getDwid().getDwjs());
            	//还少一时间
            	sysResponse.setCode(SysResponse.SUCCESS);
            	sysResponse.setMessage("请求成功");
            	sysResponse.setResult(map);
            }
        } catch (Exception e) {
            sysResponse.setCode(SysResponse.FAILURE);
            sysResponse.setMessage("请求失败");
            logger.debug("获取职位出错:"+e);
        }
        return sysResponse;
    }
    
    /**
     * 查询该公司其他职位
     * @param id 当前职位id
     * @return
     */
    @RequestMapping(value = "findOtherJobById", method = RequestMethod.POST)
    public SysResponse findOtherJobById(String id){
    	SysResponse sysResponse = new SysResponse();
    	try {
    		List<RecruitPosition> recruitPosition = recruitPositionService.findOtherJobById(Integer.parseInt(id));
    		if(recruitPosition.size()>0){
    			HashMap<String,String>  map = null;
    			ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
    			for(RecruitPosition rp :recruitPosition){
    				map = new HashMap<String,String>();
    				map.put("id", rp.getId().toString());
    				map.put("job_name", rp.getZwmc());
    				list.add(map);
    			} 
    			sysResponse.setTotal(recruitPosition.size());
    			sysResponse.setCode(SysResponse.SUCCESS);
            	sysResponse.setMessage("请求成功");
            	sysResponse.setResult(list);
    		}else{
    			sysResponse.setCode(SysResponse.FAILURE);
        		sysResponse.setMessage("列表为空");
    		}
    	} catch (Exception e) {
    		sysResponse.setCode(SysResponse.FAILURE);
    		sysResponse.setMessage("请求失败");
    		logger.debug("查询该公司其他职位出错:"+e);
    	}
    	return sysResponse;
    }
}
