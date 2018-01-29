package com.limn.update.server.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.limn.tool.common.DateFormat;
import com.limn.tool.common.FileUtil;
import com.limn.update.server.common.Utils;




@Controller
@RequestMapping("/pgyer")
public class PgyerAppPackageInfoController {

	@RequestMapping("upload")
	@ResponseBody
	public Object upload(MultipartFile file, String description ,HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> data = new HashMap<String, Object>();

		if (null == file) {

			data.put("status", "0");
			data.put("detail", "文件不能为空");
			return data;
		}
		InputStream input = file.getInputStream();

		String filePath = request.getSession().getServletContext().getRealPath("/");
		String path = "temp";
		path = Utils.getAPKPath(filePath) + path + "/" + DateFormat.getDateString() + "/";

		if (!new File(path).exists()) {
			new File(path).mkdirs();
		}

		filePath = path + "/temp/" + file.getOriginalFilename();

		if(!new File(path + "/temp/").exists()){
			new File(path + "/temp/").mkdirs();
		}
		
		File saveFile = new File(filePath);

		if (saveFile.exists()) {
			data.put("status", "0");
			data.put("detail", "文件已存在");
			return data;
		} else if (!FileUtil.getFileType(filePath).equalsIgnoreCase("ipa")) {
			data.put("status", "0");
			data.put("detail", "拒绝上传非ios的文件");
			return data;
		}

		FileOutputStream fos = new FileOutputStream(filePath);

		// 把数据存入路径+文件名
		byte buf[] = new byte[1024];
		do {
			// 循环读取
			int numread = input.read(buf);
			if (numread == -1) {
				break;
			}
			fos.write(buf, 0, numread);
		} while (true);
		try {
			fos.flush();
			fos.close();
			input.close();
		} catch (Exception ex) {

		}

		data.put("status", "1");
		data.put("detail", "文件上传成功");
		upload(new File(filePath),description);
		return data;

	}



	/**
	 * 发布应用获取上传凭证
	 * 
	 * @param bundleId
	 */
	public void upload(File apkFile,String description) {
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost("http://www.pgyer.com/apiv1/app/upload");
		MultipartEntityBuilder multipartEntity = MultipartEntityBuilder.create();
		multipartEntity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		multipartEntity.setContentType(ContentType.MULTIPART_FORM_DATA);
		String uKey = Utils.getConfigVar("uKey");
		String _api_key = Utils.getConfigVar("_api_key");
		
		multipartEntity.addTextBody("uKey", uKey);
		multipartEntity.addTextBody("_api_key", _api_key);
		multipartEntity.addPart("file", new FileBody(apkFile));
		multipartEntity.addTextBody("updateDescription", description);
		
		try {
			httppost.setEntity(multipartEntity.build());
			System.out.println("executing request " + httppost.getURI());
			CloseableHttpResponse response1 = httpclient.execute(httppost);
			try {
				HttpEntity entity = response1.getEntity();
				if (entity != null) {
					String res = EntityUtils.toString(entity, "UTF-8");

					System.out.println("--------------------------------------");
					System.out.println("Response content: " + res);
					System.out.println("--------------------------------------");
				}
			} finally {
				response1.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
