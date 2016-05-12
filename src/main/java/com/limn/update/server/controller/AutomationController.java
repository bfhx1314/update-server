package com.limn.update.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.limn.frame.control.ConsoleFrame;
import com.limn.frame.control.StartConfigBean;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自动化测试运行类
 * 
 * @author 李孟楠
 *
 */
@Controller
@RequestMapping("/auto")
public class AutomationController {

	/**
	 * 运行 详情可以参考 StartConfigBean 类
	 * 
	 * @param request
	 * @param response
	 * @param appFilePath
	 * @param browserType
	 * @param computer
	 * @param excelPath
	 * @param executeMode
	 * @param frontSteps
	 * @param debug
	 * @param initDB
	 * @param iP
	 * @param notServer
	 * @param runTestModel
	 * @param sheetsNum
	 * @param specify
	 * @param specifyRow
	 * @param specifySheet
	 * @param specifyStep
	 * @param sqlData
	 * @param startPlatform
	 * @param uploadResults
	 * @param URL
	 * @param isLoop
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("run")
	@ResponseBody
	public Object weixinMsg(HttpServletRequest request, HttpServletResponse response, String appFilePath,
			String browserType, String computer, String excelPath, String executeMode, String frontSteps, String debug,
			String initDB, String iP, String notServer, String runTestModel, String sheetsNum, String specify,
			String specifyRow, String specifySheet, String specifyStep, String sqlData, String startPlatform,
			String uploadResults, String URL, String isLoop) throws IOException {
		StartConfigBean scb = new StartConfigBean();
		scb.setAppFilePath(appFilePath);
		scb.setBrowserType(browserType);
		scb.setComputer(computer);
		scb.setDeBug(debug == null ? debug == "true" ? true : false : false);
		scb.setExcelPath(excelPath);
		scb.setExecuteMode(executeMode);
		scb.setFrontSteps(frontSteps == null ? frontSteps == "true" ? true : false : false);
		scb.setInitDB(initDB == null ? initDB == "true" ? true : false : false);
		scb.setIP(iP);
		scb.setNotServer(notServer == null ? notServer == "true" ? true : false : false);
		scb.setRunTestModel(runTestModel);
		scb.setSheetsNum(sheetsNum);
		scb.setSpecify(specify);
		scb.setSpecifyRow(specifyRow);
		scb.setSpecifySheet(specifySheet);
		scb.setSpecifyStep(specifyStep);
		scb.setSqlData(sqlData);
		scb.setStartPlatform(startPlatform);
		scb.setUploadResults(uploadResults == null ? uploadResults == "true" ? true : false : false);
		scb.setURL(URL);
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			ConsoleFrame cf = new ConsoleFrame();
			cf.startByStartConfigBean(scb, isLoop == null ? isLoop == "true" ? true : false : false);
			data.put("status", "1");
			data.put("detail", "正在执行中...");
		} catch (Exception e) {
			e.printStackTrace();
			data.put("status", "2");
			data.put("detail", "程序异常");
		}
		return data;
	}

}