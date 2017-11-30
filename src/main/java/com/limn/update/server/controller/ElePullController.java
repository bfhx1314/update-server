package com.limn.update.server.controller;

import com.limn.frame.control.BeforeTest;
import com.limn.frame.keyword.BaseAppKeyWordDriverImpl;
import com.limn.frame.keyword.BaseAppKeyWordType;
import com.limn.frame.keyword.BaseKeyWordDriverImpl;
import com.limn.frame.keyword.BaseKeyWordType;
import com.limn.tool.bean.StartConfigBean;
import com.limn.tool.common.DateFormat;
import com.limn.tool.parameter.Parameter;
import com.limn.update.server.common.Utils;
import com.limn.update.server.dao.EleShopDao;
import com.limn.update.server.dao.FindCoordinateRecordDao;
import com.limn.update.server.dao.PersonEntityDao;
import com.limn.update.server.entity.PersonEntity;
import com.limn.update.server.service.ElePullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
	PersonEntityDao personEntityDao;

	@Autowired
	ElePullService elePullService;

	@RequestMapping("testSql")
	@ResponseBody
	public Object testSql(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PersonEntity personEntity = new PersonEntity();
		personEntity.setUser_name("aaaaaa");
		personEntityDao.save(personEntity);


		Map<String, Object> data = new HashMap<String, Object>();
		data.put("data", "2222");
		return data;
	}


	@RequestMapping("saveShop")
	@ResponseBody
	public Object saveShop(HttpServletRequest request, HttpServletResponse response) throws IOException {

		elePullService.saveShopByCoordinate( "31.30","121.13");

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("data", "111");
		return data;
	}


	
}