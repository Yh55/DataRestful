package com.cn.Service;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("restful")
public interface RestfulIService {
	
	
	    /** 
	     * 推荐使用，这种可以解决绝大多数问题 
	     * @param person 
	     * @return 
	     */  
	    @RequestMapping(value = "/dataInfo_udp", method = RequestMethod.POST,   
	            produces = "application/json;charset=UTF-8",  
	            consumes = "application/json;charset=UTF-8" )  
	    public @ResponseBody void dataInfo_udp(@RequestBody JSONObject dataJson,HttpServletResponse response);  
	      
	    
	    
	    
	    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")  
	    public @ResponseBody  
	    String getPerson(@PathVariable("id") String id); 
	    
	    
	    
	
}
