package com.limn.update.server.controller;

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
	public Object saveShop(HttpServletRequest request, HttpServletResponse response , String latitude , String longitude) throws IOException {

		Map<String, Object> data = new HashMap<String, Object>();
		try {
			FindCoordinateRecordEntity fcre = elePullService.saveShopByCoordinate(latitude, longitude);
			data.put("data", "查询成功");
			data.put("detail", fcre);
		}catch (Exception e){
			e.printStackTrace();
			data.put("data", "查询失败");
		}

		return data;
	}


	
}