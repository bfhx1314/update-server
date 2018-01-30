package com.limn.update.server.controller;

import com.limn.update.server.dao.RecordLogDao;
import com.limn.update.server.entity.RecordLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
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
@RequestMapping("/record")
public class RecordLogController {

	@Autowired
	RecordLogDao recordLogDao;

	@Transactional
	@RequestMapping("log")
	@ResponseBody
	public Object info(String type ,
					   String source, String exeResult , String log1 , String log2 , String log3 , String log4, String uuid, String deviceName) throws IOException {


		Map<String, Object> data = new HashMap<String, Object>();
		if(type == null || type.isEmpty()){
			data.put("data", "type不能为空");
			return data;
		}

		if(source == null || source.isEmpty()){
			data.put("source", "source不能为空");
			return data;
		}

		if(exeResult == null || exeResult.isEmpty()){
			data.put("exeResult", "exeResult不能为空");
			return data;
		}

		if(uuid == null || uuid.isEmpty()){
			data.put("uuid", "uuid不能为空");
			return data;
		}


		RecordLogEntity recordLogEntity = new RecordLogEntity();

		recordLogEntity.setType(type);
		recordLogEntity.setExeResult(exeResult);
		recordLogEntity.setSource(source);
		recordLogEntity.setLog1(log1);
		recordLogEntity.setLog2(log2);
		recordLogEntity.setLog3(log3);
		recordLogEntity.setLog4(log4);
		recordLogEntity.setCreateDate(new Date());
		recordLogEntity.setUuid(uuid);
		recordLogEntity.setDeviceName(deviceName);
		recordLogDao.save(recordLogEntity);

		return data;
	}


	public static void main(String[] args){
		System.out.println(new Date());

	}


}