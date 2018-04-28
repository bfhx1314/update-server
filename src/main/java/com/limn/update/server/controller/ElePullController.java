package com.limn.update.server.controller;

import com.limn.update.server.bean.ResponseVo;
import com.limn.update.server.common.BaseUtil;
import com.limn.update.server.entity.FindCoordinateRecordEntity;
import com.limn.update.server.service.ElePullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 自动化测试运行类
 * 
 * @author 李孟楠
 *
 */
@Controller
@RequestMapping("/ele")
public class ElePullController {


	@Autowired
	ElePullService elePullService;


	@RequestMapping("saveShop")
	@ResponseBody
	public Object saveShop(HttpServletRequest request, HttpServletResponse response , String latitude , String longitude , String update) throws IOException {

		Map<String, Object> data = new HashMap<String, Object>();

		if(BaseUtil.isEmpty(latitude)){
			data.put("data", "latitude不能为空");
			return data;
		}
		if(BaseUtil.isEmpty(longitude)){
			data.put("data", "longitude不能为空");
			return data;
		}

		boolean up = false;
		if(!BaseUtil.isEmpty(update) &&( "1".equalsIgnoreCase(update) || "true".equalsIgnoreCase(update))){
			up = true;
		}

		try {
			FindCoordinateRecordEntity fcre = elePullService.saveShopByCoordinate(latitude, longitude,up);
			data.put("data", "查询成功");
			data.put("detail", fcre);
		}catch (Exception e){
			e.printStackTrace();
			data.put("data", "查询失败");
		}

		return data;
	}

	@RequestMapping("analysis")
	@ResponseBody
	public Object analysis(HttpServletRequest request, HttpServletResponse response,String type) throws IOException {
		ResponseVo responseVo = new ResponseVo();
		if(BaseUtil.isEmpty(type)){
			responseVo.setDetail("type不能为空");
			responseVo.setStatus("2");
			return responseVo;
		}else if(type.equalsIgnoreCase("shop")){
			responseVo = elePullService.analysisShop();
		}else if(type.equalsIgnoreCase("menu")) {
			responseVo = elePullService.analysisMenu();
		}else if(type.equalsIgnoreCase("food")){
			responseVo = elePullService.analysisFood();
		}else{
			responseVo.setDetail("type类型错误");
			return responseVo;
		}
		return responseVo;
	}

	@RequestMapping("search")
	@ResponseBody
	public Object search(HttpServletRequest request, HttpServletResponse response,String name) throws IOException {
		ResponseVo responseVo = new ResponseVo();
		if(BaseUtil.isEmpty(name)) {
			responseVo.setDetail("name不能为空");
			responseVo.setStatus("2");
			return responseVo;
		}
		responseVo.setData(elePullService.search(name));
		responseVo.setStatus("1");
		return responseVo;
	}
}