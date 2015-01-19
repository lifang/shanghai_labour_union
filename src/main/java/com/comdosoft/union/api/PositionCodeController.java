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

import com.comdosoft.union.bean.app.RecruitIndustry;
import com.comdosoft.union.bean.app.RecruitPosition;
import com.comdosoft.union.bean.app.SysCode;
import com.comdosoft.union.common.SysResponse;
import com.comdosoft.union.service.RecruitIndustryService;
import com.comdosoft.union.service.RecruitPositionService;
import com.comdosoft.union.service.SysCodeService;
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
    private SysCodeService sysCodeService;
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
        sysResponse.setCode(SysResponse.SUCCESS);
        sysResponse.setMessage("请求成功");
        sysResponse.setResult(RIList);
        return sysResponse;
    }
    
   /**
    * 查询所有工作区域,如果存在code,则排除此code
    * @param code
    * @return
    */
    @RequestMapping(value = "findAllAddr", method = RequestMethod.POST)
    public SysResponse findAllAddr(@RequestParam(value="code", required=false) String code){
        SysResponse sysResponse = new SysResponse();
        List<SysCode> sysCodeList = sysCodeService.findAll("10001",code);//类型10001为区域
        sysResponse.setCode(SysResponse.SUCCESS);
        sysResponse.setMessage("请求成功");
        sysResponse.setResult(sysCodeList);
        return sysResponse;
    }
    
    /**
     * 最新职位
     * @return
     */
    @RequestMapping(value = "findNewJob", method = RequestMethod.POST)
    public SysResponse findNewJob(RecruitPosition recruitPosition){
        return getJobs("0","5",recruitPosition);
    }
    
   /**
    * 根据条件查询所有岗位
    * @param offset
    * @param limit
    * @param recruitPosition
    * @return
    */
    public SysResponse getJobs(String offset,String limit,RecruitPosition recruitPosition) {
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
            List<RecruitPosition> recruitPositionList = recruitPositionService.findNewJob(Integer.parseInt(offset),Integer.parseInt(limit),recruitPosition);
            sysResponse.setCode(SysResponse.SUCCESS);
            sysResponse.setMessage("请求成功");
            sysResponse.setResult(recruitPositionList);
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
    public SysResponse search(String offset,RecruitPosition recruitPosition) {
        return getJobs(offset,"10",recruitPosition);
    }

}
