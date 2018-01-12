package com.limn.update.server.controller;

import com.limn.update.server.dao.WXCMinfoDao;
import com.limn.update.server.entity.WXCMInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 自动化测试运行类
 * 
 * @author 李孟楠
 *
 */
@Controller
@RequestMapping("/wxcm")
public class WXCMController {

	@Autowired
	WXCMinfoDao wxcMinfoDao;


	@Transactional
	@RequestMapping("info")
	@ResponseBody
	public Object info(HttpServletRequest request, HttpServletResponse response , String type , String requestUrl, String responseData) throws IOException {
		Map<String, Object> data = new HashMap<String, Object>();
		if(type == null || type.isEmpty()){
			data.put("data", "type不能为空");
			return data;
		}

		if(type == null || type.isEmpty()){
			data.put("requestUrl", "requestUrl不能为空");
			return data;
		}

		if(type == null || type.isEmpty()){
			data.put("responseData", "responseData不能为空");
			return data;
		}
		Date date = new Date();
		Timestamp nousedate = new Timestamp(date.getTime());

		WXCMInfoEntity wxcmInfoEntity = new WXCMInfoEntity();
		wxcmInfoEntity.setType(type);
		wxcmInfoEntity.setRequestUrl(requestUrl);
		wxcmInfoEntity.setResponseData(responseData);
		wxcmInfoEntity.setDate(nousedate);
		wxcMinfoDao.save(wxcmInfoEntity);



		return data;
	}


}