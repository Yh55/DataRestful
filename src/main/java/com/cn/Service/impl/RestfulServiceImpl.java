package com.cn.Service.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.InfoSend.DataInfoSend_UDP;
import com.cn.Service.RestfulIService;
import com.cn.util.ServiceResult;


@Controller
public class RestfulServiceImpl  implements  RestfulIService{

	 /** 日志实例 */  
    private static final Logger logger = Logger.getLogger(RestfulServiceImpl.class);  
    
    public @ResponseBody void dataInfo_udp(@RequestBody JSONObject dataJson ,HttpServletResponse response) {
    	ServiceResult serviceResult = new ServiceResult("500", "未知异常");
    	
		String msg = null;
		String code = "200";
        logger.info("进入接口获取传入数据=="+dataJson );
        DataInfoSend_UDP dataInfoSend = new DataInfoSend_UDP();
        try {
			dataInfoSend.DataInfoSend(dataJson.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.getMessage();
		} finally{
			int status= response.getStatus();
			
			if (StringUtils.isNotBlank(msg)) {
				serviceResult.setCode(code);
				serviceResult.setMsg(msg);
			}
		}
    }  
    
    
    public @ResponseBody  
    String getPerson(@PathVariable("id") String id) {  
    	id=id+1;
        logger.info("获取人员信息id=" + id);  
        return id;  
    }  

}
