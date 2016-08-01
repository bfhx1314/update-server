package com.limn.update.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.limn.update.server.common.Utils;
import com.limn.update.server.common.FileMD5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author limn
 *
 */
@Controller
@RequestMapping("/")
public class UpdataController {

	/**
	 * 获取以文件夹为单位的APP类型
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */

	@RequestMapping("/index")
	@ResponseBody
	public Object weixinMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Map<String, Object> data = new HashMap<String, Object>();

		String filePath = request.getSession().getServletContext().getRealPath("/");
		File file = new File(Utils.getAPKPath(filePath));
		data.put("path", filePath);

		int size = 0;
		if (file.exists() || file.isDirectory()) {
			File[] fileList = file.listFiles();

			ArrayList<String> dirList = new ArrayList<String>();
			for (File fileType : fileList) {
				if (fileType.isDirectory()) {
					dirList.add(fileType.getName());
					size++;
				}
				data.put("appType", dirList);
			}

		}
		data.put("size", size);
		return data;
	}

	/**
	 * 获取文件夹下所有内容
	 * 
	 * @param version
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("getVersion")
	@ResponseBody
	public Object getVersion(String version, HttpServletRequest request) throws IOException {

		Map<String, Object> data = new HashMap<String, Object>();

		String filePath = request.getSession().getServletContext().getRealPath("/");

		filePath = Utils.getAPKPath(filePath) + "/" + version;

		File file = new File(filePath);

		int apkSize = 0;
		int typeSize = 0;
		if (file.exists() || file.isDirectory()) {
			File[] fileList = orderByDate(file.listFiles());

			ArrayList<String> dirList = new ArrayList<String>();
			ArrayList<Map<String, String>> apkList = new ArrayList<Map<String, String>>();
			for (File fileType : fileList) {
				if (fileType.isDirectory()) {
					dirList.add(fileType.getName());
					typeSize++;
				} else {

					String type = fileType.getName().substring(fileType.getName().lastIndexOf(".") + 1);
					if (type.equalsIgnoreCase("apk")) {
						Map<String, String> map = new HashMap<String, String>();
						map.put("MD5", FileMD5.getMd5ByFile(fileType));
						map.put("fileName", version + "/" + fileType.getName());

						SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						// 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
						java.util.Date dt = new Date(fileType.lastModified());
						String sDateTime = sdf.format(dt); // 得到精确到秒的表示：08/31/2006
															// 21:08:00
						System.out.println(sDateTime);

						map.put("updateTime", sDateTime);

						apkList.add(map);
						apkSize++;
					}
				}
				data.put("appType", dirList);
				data.put("appList", apkList);
				data.put("typeSize", typeSize);
				data.put("apkSize", apkSize);
			}
		}

		return data;
	}

	@RequestMapping({ "/download" })
	public Object download(String version, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		String filePath = request.getSession().getServletContext().getRealPath("/");

		filePath = Utils.getAPKPath(filePath) + "/" + version;

		String downLoadPath = filePath;

		File file = new File(downLoadPath);
		if ((file.exists()) && (file.isFile())) {
			try {
				long fileLength = new File(downLoadPath).length();
				response.setContentType("application/x-msdownload;");
				response.setHeader("Content-disposition",
						"attachment; filename=" + new String(file.getName().getBytes("utf-8"), "ISO8859-1"));
				response.setHeader("Content-Length", String.valueOf(fileLength));
				bis = new BufferedInputStream(new FileInputStream(downLoadPath));
				bos = new BufferedOutputStream(response.getOutputStream());
				byte[] buff = new byte[2048];
				int bytesRead;
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length)))
					bos.write(buff, 0, bytesRead);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			}
		}
		return null;
	}

	public File[] orderByDate(File[] fs) {
		Arrays.sort(fs, new Comparator<File>() {
			public int compare(File f1, File f2) {
				long diff = f1.lastModified() - f2.lastModified();
				if (diff < 0)
					return 1;
				else if (diff == 0)
					return 0;
				else
					return -1;
			}

			public boolean equals(Object obj) {
				return true;
			}

		});
		for (int i = fs.length - 1; i > -1; i--) {
			System.out.println(fs[i].getName());
			System.out.println(new Date(fs[i].lastModified()));
		}
		return fs;
	}

	@RequestMapping("rename")
	@ResponseBody
	public Object renameFile(String modifyName, String sourcePath, HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, String> data = new HashMap<String, String>();

		String filePath = request.getSession().getServletContext().getRealPath("/");

		String path = Utils.getAPKPath(filePath) + sourcePath;

		File file = new File(path);
		if (file.exists() && file.isFile()) {
			File newFile = new File(file.getParent() + "/" + modifyName);
			if (!getFileExtension(newFile).equalsIgnoreCase("apk")) {
				newFile = new File(file.getParent() + "/" + modifyName + ".apk");
			}
			if (!newFile.exists()) {
				file.renameTo(newFile);
				data.put("status", "1");
				data.put("detail", "文件修改成功");
			} else {
				data.put("status", "0");
				data.put("detail", "已经存在此文件");
			}
		} else {
			data.put("status", "0");
			data.put("detail", "未找到改文件");
		}

		return data;
	}

	@RequestMapping("deleteFile")
	@ResponseBody
	public Object deleteFile(String sourcePath, HttpServletRequest request, HttpServletResponse response) {

		Map<String, String> data = new HashMap<String, String>();

		String filePath = request.getSession().getServletContext().getRealPath("/");

		String path = Utils.getAPKPath(filePath) + sourcePath;

		File file = new File(path);
		if (file.exists() && file.isFile()) {
			boolean isDeleted = file.delete();
			if (isDeleted) {
				data.put("status", "1");
				data.put("detail", "文件已删除");
			} else {
				data.put("status", "0");
				data.put("detail", "文件被占用");
			}
		} else {
			data.put("status", "0");
			data.put("detail", "未找到改文件");
		}

		return data;
	}

	@RequestMapping("createFile")
	@ResponseBody
	public Object createFile(String sourcePath, HttpServletRequest request, HttpServletResponse response) {

		Map<String, String> data = new HashMap<String, String>();

		String filePath = request.getSession().getServletContext().getRealPath("/");

		String path = Utils.getAPKPath(filePath) + sourcePath;

		File file = new File(path);
		if (file.exists()) {
			data.put("status", "0");
			data.put("detail", "文件已存在");
		} else {
			file.mkdirs();
			data.put("status", "1");
			data.put("detail", "文件创建成功");
		}

		return data;
	}

	@RequestMapping("upload")
	@ResponseBody
	public Object upload(String path, MultipartFile file, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Map<String, Object> data = new HashMap<String, Object>();

		if (null == file) {

			data.put("status", "0");
			data.put("detail", "文件不能为空");
			return data;
		}
		InputStream input = file.getInputStream();

		String filePath = request.getSession().getServletContext().getRealPath("/");

		path = Utils.getAPKPath(filePath) + path + "/";

		if (!new File(path).exists()) {
			new File(path).mkdirs();
		}

		filePath = path + file.getOriginalFilename();

		File saveFile = new File(filePath);

		if (saveFile.exists()) {
			data.put("status", "0");
			data.put("detail", "文件已存在");
			return data;
			
		}else if(getFileExtension(saveFile).equalsIgnoreCase("ipa")){
			
//			new PgyerAppPackageInfoController().upload(file, "默认上传", request, response);
			data.put("status", "1");
			data.put("detail", "上传成功!");
			return data;

		}else if (!getFileExtension(saveFile).equalsIgnoreCase("apk")) {
			data.put("status", "0");
			data.put("detail", "拒绝上传非APK的文件");
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

		return data;

	}

	
	
	private String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		} else {
			return "";
		}
	}

}
