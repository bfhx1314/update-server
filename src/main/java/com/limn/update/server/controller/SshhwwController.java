package com.limn.update.server.controller;

import com.limn.update.server.bean.ResponseVo;
import com.limn.update.server.bean.TaskRecordVo;
import com.limn.update.server.bean.WXCMUpdateVO;
import com.limn.update.server.common.BaseUtil;
import com.limn.update.server.dao.SshhwwTaskRecordDao;
import com.limn.update.server.dao.SshhwwUpdateDao;
import com.limn.update.server.dao.SshhwwinfoDao;
import com.limn.update.server.entity.SshhhwwInfoEntity;
import com.limn.update.server.entity.SshhwwTaskRecordEntity;
import com.limn.update.server.entity.SshhwwUpdateEntity;
import com.limn.update.server.service.SshhwwService;
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
public class SshhwwController {

	@Autowired
	SshhwwinfoDao sshhwwinfoDao;

	@Autowired
	SshhwwUpdateDao sshhwwUpdateDao;

	@Autowired
	SshhwwService sshhwwService;


	@Autowired
	SshhwwTaskRecordDao sshhwwTaskRecordDao;

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

		SshhhwwInfoEntity sshhhwwInfoEntity = new SshhhwwInfoEntity();
		sshhhwwInfoEntity.setType(type);
		sshhhwwInfoEntity.setRequestUrl(requestUrl);
		sshhhwwInfoEntity.setResponseData(responseData);
		sshhhwwInfoEntity.setDate(nousedate);
		sshhwwinfoDao.save(sshhhwwInfoEntity);

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

		SshhwwUpdateEntity sshhwwUpdateEntity = new SshhwwUpdateEntity();
		sshhwwUpdateEntity.setVersion(Integer.valueOf(version));
		sshhwwUpdateEntity.setType(type);
		sshhwwUpdateEntity.setMd5(md5);
		SshhwwUpdateEntity up = sshhwwUpdateDao.getUpdateVersion(sshhwwUpdateEntity);

		wxcmUpdateVO.setStatus("1");
		if(up == null || up.getUpdatePath() == null || up.getUpdatePath().isEmpty()){
			wxcmUpdateVO.setVersion(Integer.valueOf(version));
			wxcmUpdateVO.setUpdate("N");
		}else{
			wxcmUpdateVO.setVersion(up.getVersion());
			wxcmUpdateVO.setUpdateFilePath(up.getUpdatePath());
			wxcmUpdateVO.setMd5(up.getMd5());
			wxcmUpdateVO.setUpdate("Y");
		}

		return wxcmUpdateVO;
	}


	@Transactional
	@RequestMapping("task")
	@ResponseBody
	public Object task(HttpServletRequest request, HttpServletResponse response, String uuid, String type , String deviceName){

		TaskRecordVo taskRecordVo = sshhwwService.getTask(uuid, type,deviceName);
		return taskRecordVo;
	}

	@Transactional
	@RequestMapping("taskDone")
	@ResponseBody
	public Object taskDone(HttpServletRequest request, HttpServletResponse response, String uuid, String taskRecordId, String result){
		ResponseVo responseVo = new ResponseVo();

		if(BaseUtil.isEmpty(uuid)){
			responseVo.setStatus("0");
			responseVo.setDetail("uuid不能为空");
			return responseVo;
		}
		if(BaseUtil.isEmpty(taskRecordId)){
			responseVo.setStatus("0");
			responseVo.setDetail("taskRecordId不能为空");
			return responseVo;
		}
		if(BaseUtil.isEmpty(result)){
			responseVo.setStatus("0");
			responseVo.setDetail("result不能为空");
			return responseVo;
		}


		SshhwwTaskRecordEntity taskRecord = new SshhwwTaskRecordEntity();
		taskRecord.setUuid(uuid);
		taskRecord.setId(Integer.valueOf(taskRecordId));
		taskRecord.setStatus("0");
		SshhwwTaskRecordEntity tRecord = sshhwwTaskRecordDao.getTaskRecord(taskRecord);

		if(tRecord == null){
			responseVo.setStatus("0");
			responseVo.setDetail("请求失败");
			return responseVo;
		}

		tRecord.setStatus(result);
		sshhwwTaskRecordDao.saveOrUpdate(tRecord);
		responseVo.setStatus("1");
		responseVo.setDetail("提交成功");
		return responseVo;
	}

	@Transactional
	@RequestMapping("insurance")
	@ResponseBody
	public Object insurance(HttpServletRequest request, HttpServletResponse response){



		return "YES";
	}


}