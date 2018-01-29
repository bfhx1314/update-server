package com.limn.update.server.controller;

import com.limn.update.server.bean.WXCMUpdateVO;
import com.limn.update.server.common.BaseUtil;
import com.limn.update.server.dao.WXCMUpdateDao;
import com.limn.update.server.dao.WXCMinfoDao;
import com.limn.update.server.entity.WXCMInfoEntity;
import com.limn.update.server.entity.WXCMUpdateEntity;
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

	@Autowired
	WXCMUpdateDao wxcmUpdateDao;

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

	@Transactional
	@RequestMapping("update")
	@ResponseBody
	public Object updatePhpFile(HttpServletRequest request, HttpServletResponse response , String version , String uuid , String type
	,String md5){
		WXCMUpdateVO wxcmUpdateVO = new WXCMUpdateVO();
		if(BaseUtil.isEmpty(version)){
			wxcmUpdateVO.setStatus("0");
			wxcmUpdateVO.setDetail("version不能为空");
			return wxcmUpdateVO;
		}

		if(BaseUtil.isEmpty(type)){
			wxcmUpdateVO.setStatus("0");
			wxcmUpdateVO.setDetail("type不能为空");
			return wxcmUpdateVO;
		}

		if(BaseUtil.isEmpty(md5)){
			wxcmUpdateVO.setStatus("0");
			wxcmUpdateVO.setDetail("md5不能为空");
			return wxcmUpdateVO;
		}

		WXCMUpdateEntity wxcmUpdateEntity = new WXCMUpdateEntity();
		wxcmUpdateEntity.setVersion(Integer.valueOf(version));
		wxcmUpdateEntity.setType(type);
		wxcmUpdateEntity.setMd5(md5);
		WXCMUpdateEntity up = wxcmUpdateDao.getUpdateVersion(wxcmUpdateEntity);

		wxcmUpdateVO.setStatus("1");
		if(up == null || up.getUpdatePath() == null || up.getUpdatePath().isEmpty()){
			wxcmUpdateVO.setVersion(Integer.valueOf(version));
		}else{
			wxcmUpdateVO.setVersion(up.getVersion());
			wxcmUpdateVO.setUpdateFilePath(up.getUpdatePath());
		}

		return wxcmUpdateVO;
	}








}