package com.limn.update.server.controller;

import com.limn.update.server.bean.ResponseVo;
import com.limn.update.server.common.BaseUtil;
import com.limn.update.server.entity.FindCoordinateRecordEntity;
import com.limn.update.server.service.ElePullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
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
	public Object saveShop(String latitude , String longitude , String update, int version) throws IOException {

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
			FindCoordinateRecordEntity fcre = elePullService.saveShopByCoordinate(latitude, longitude,up,version);
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
			responseVo = elePullService.analysis(type);
		}else if(type.equalsIgnoreCase("menu")) {
			responseVo = elePullService.analysis(type);
		}else if(type.equalsIgnoreCase("food")){
			responseVo = elePullService.analysis(type);
		}else{
			responseVo.setDetail("type类型错误");
			return responseVo;
		}
		return responseVo;
	}

	@RequestMapping("search")
	@ResponseBody
	public Object search(String name,int version,String sales) throws IOException {
		ResponseVo responseVo = new ResponseVo();
		if(BaseUtil.isEmpty(name) && BaseUtil.isEmpty(sales)) {
			responseVo.setDetail("名称和销量不能都为空");
			responseVo.setStatus("2");
			return responseVo;
		}
		int count = 0;
		if(!BaseUtil.isEmpty(sales)){
			try {
				count = Integer.valueOf(sales);
			}catch (Exception e){
				responseVo.setStatus("2");
				return responseVo;
			}
		}
		responseVo.setData(elePullService.search(name,version,count));
		responseVo.setStatus("1");
		return responseVo;
	}
}