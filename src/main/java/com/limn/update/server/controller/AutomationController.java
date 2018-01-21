package com.limn.update.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.limn.frame.control.BeforeTest;
import com.limn.frame.keyword.BaseAppKeyWordDriverImpl;
import com.limn.frame.keyword.BaseAppKeyWordType;
import com.limn.frame.keyword.BaseKeyWordDriverImpl;
import com.limn.frame.keyword.BaseKeyWordType;
import com.limn.tool.bean.StartConfigBean;
import com.limn.tool.common.DateFormat;
import com.limn.tool.parameter.Parameter;
import com.limn.update.server.common.Utils;

import java.io.File;
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

	private static LinkedHashMap<String, BeforeTest> testingRC = new LinkedHashMap<String, BeforeTest>();
	private static HashMap<String,String> fileData = new HashMap<String,String>();






	/**
	 * 运行 详情可以参考 StartConfigBean 类
	 * @param request
	 * @param response
	 * @param appFile
	 * @param browserType
	 * @param computer
	 * @param testCaseFile
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
	public Object runAutomationTest(HttpServletRequest request, HttpServletResponse response, String appFile, String browserType, String computer, String testCaseFile, String executeMode, String frontSteps, String debug, String initDB, String iP, String notServer, String runTestModel, String sheetsNum, String specify, String specifyRow, String specifySheet, String specifyStep, String sqlData,
			String startPlatform, String uploadResults, String URL, String isLoop) throws IOException {
		Map<String, Object> data = new HashMap<String, Object>();
		
		
		String appFilePath = new File(fileData.get(appFile)).getAbsolutePath();
		String excelPath = new File(fileData.get(testCaseFile)).getAbsolutePath();
		
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
		
  		Parameter.DFAULT_RESULTSFOLDER_PATH = request.getSession().getServletContext().getRealPath("/") + "/ResultsFolder/";
		
		

		BaseKeyWordDriverImpl keyWordDriver = new BaseKeyWordDriverImpl();
		keyWordDriver.addKeyWordDriver("基础关键字", new BaseKeyWordDriverImpl(), BaseKeyWordType.class);
		keyWordDriver.addKeyWordDriver("App基础关键字", new BaseAppKeyWordDriverImpl(), BaseAppKeyWordType.class);

		BeforeTest bt = new BeforeTest(scb, keyWordDriver, isLoop == null ? isLoop == "true" ? true : false : false, false);
		String res = bt.checkStartConfig();
		if (res != null) {
			data.put("status", "2");
			data.put("detail", res);
			return data;
		}
		try {
			new Thread(bt).start();
			String id = DateFormat.getCurrentTimeMillis();
			testingRC.put(id, bt);
			data.put("status", "1");
			data.put("id", id);
			data.put("detail", "正在执行中...");
		} catch (Exception e) {
			e.printStackTrace();
			data.put("status", "2");
			data.put("detail", "程序异常");
		}
		return data;
	}

	@RequestMapping("getProgress")
	@ResponseBody
	public Object getProgress(HttpServletRequest request, HttpServletResponse response, String id) throws IOException {
		Map<String, Object> data = new HashMap<String, Object>();

//		data.put("caseCount", "100");
//		data.put("executeCaseCount", "88");
//		data.put("sucessCaseCount", "77");
//		data.put("status", "1");
//		return data;
		
		if (testingRC.containsKey(id)) {
			data.put("caseCount", testingRC.get(id).getRecordResult().getCaseCount());
			data.put("executeCaseCount", testingRC.get(id).getRecordResult().getExecuteCaseCount());
			data.put("sucessCaseCount", testingRC.get(id).getRecordResult().getSucessCaseCount());
			data.put("status", "1");
		} else {
			data.put("status", "2");
			data.put("detail", "无此id记录");
		}
		return data;
	}
	
	
	@RequestMapping("list")
	@ResponseBody
	public Object getList(HttpServletRequest request, HttpServletResponse response, String id) throws IOException {
		Map<String, Object> data = new HashMap<String, Object>();
		ArrayList<String> list = new ArrayList<String>();
		for(String key:testingRC.keySet()){
			list.add(key);
		}
		data.put("data", list);
		return data;
	}

	@RequestMapping("getCurrentStep")
	@ResponseBody
	public Object getCurrentStep(HttpServletRequest request, HttpServletResponse response, String id) throws IOException {
		Map<String, Object> data = new HashMap<String, Object>();
		
//		data.put("testStep", "ddddddd\neeeeee\nccccc\nbbbbb");
//		data.put("testStepNo", "testcase11");
//		data.put("testStepIndex", "2");
//		data.put("status", "1");
		
		
		if (testingRC.containsKey(id)) {
			data.put("testStep", testingRC.get(id).getTest().getCurrentStep());
			data.put("testStepNo", testingRC.get(id).getTest().getCurrentStepNo());
			data.put("testStepIndex", testingRC.get(id).getTest().runTimeStepNum);
			data.put("resultPath", testingRC.get(id).getTest().getRCB().getResultFolder());
			data.put("status", "1");
		} else {
			data.put("status", "2");
			data.put("detail", "无此id记录");
		}
		return data;
	}

	@RequestMapping("getResults")
	@ResponseBody
	public Object getResults(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> data = new HashMap<String, Object>();
		Parameter.DFAULT_RESULTSFOLDER_PATH =  request.getSession().getServletContext().getRealPath("/") + "/ResultsFolder/";
		File resultsPath = new File(Parameter.DFAULT_RESULTSFOLDER_PATH);
		ArrayList<Map<String, Object>> resultsArray = new ArrayList<Map<String, Object>>();
		for(File results:resultsPath.listFiles()){
			Map<String, Object> resultsData = new HashMap<String, Object>();
			resultsData.put("name", results.getName());
			ArrayList<Map<String, String>> resultArray = new ArrayList<Map<String, String>>();
			for(File result:results.listFiles()){
				Map<String, String> resultData = new HashMap<String, String>();
				resultData.put("time",result.getName());
				resultData.put("url","ResultsFolder/" + results.getName() + "/" + result.getName() + "/Report/ReportFrame.htm");
				resultArray.add(resultData);
			}
			resultsData.put("data",resultArray);
			resultsArray.add(resultsData);
		}
		data.put("data", resultsArray);
		data.put("status", "1");
		return data;
		
	}
	
	@RequestMapping("getResult")
	@ResponseBody
	public Object getResult(HttpServletRequest request, HttpServletResponse response, String id) throws IOException {
		Map<String, Object> data = new HashMap<String, Object>();
		if (testingRC.containsKey(id)) {
			
			File res = new File(testingRC.get(id).getTest().getRCB().getResultFolder());
			
			
			data.put("url", "ResultsFolder/" + res.getParentFile().getName() + "/" + res.getName() + "/Report/ReportFrame.htm");
			data.put("status", "1");
			data.put("detail", "");
		} else {
			data.put("url", "");
			data.put("status", "2");
			data.put("detail", "无此id记录");
		}
		return data;
		
	}
	
	@RequestMapping("uploadByFile")
	@ResponseBody
	public Object upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Map<String, Object> data = new HashMap<String, Object>();

		if (null == file) {

			data.put("status", "0");
			data.put("detail", "文件不能为空");
			return data;
		}
		String key  = DateFormat.getCurrentTimeMillis();
		String path = key + file.getOriginalFilename();
		
		try{
			Utils.writeFile(file, path);
		}catch(Exception e){
			e.printStackTrace();
			data.put("key", "");
			data.put("name", "");
			data.put("status", "2");
			data.put("detail", "文件写入异常");
			return data;
		}
		
		fileData.put(key, path);
		data.put("name", file.getOriginalFilename());
		data.put("key", key);
		data.put("status", "1");
		data.put("detail", "文件上传成功");

		return data;

	}


}