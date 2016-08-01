package com.limn.update.server.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.springframework.web.multipart.MultipartFile;

public class Utils {
	
	public static String getAPKPath(String path) {
		return path + getFilePath();
	}
	
	public static String getConfigVar(String key){
		Properties variableProps = new Properties();
		InputStreamReader isr = null;
		try {
//			System.out.print(FileMD5.class.getClassLoader().getResourceAsStream("config/config.properties"));
			
			isr = new InputStreamReader(new FileInputStream(FileMD5.class.getClassLoader().getResource("/").getPath() + "/config/config.properties"));
			variableProps.load(isr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			try {
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String filePath = variableProps.getProperty(key);

		return filePath;
	}

	private static String getFilePath() {
		Properties variableProps = new Properties();
		InputStreamReader isr = null;
		try {
//			System.out.print(FileMD5.class.getClassLoader().getResourceAsStream("config/config.properties"));
			
			isr = new InputStreamReader(new FileInputStream(FileMD5.class.getClassLoader().getResource("/").getPath() + "/config/config.properties"));
			variableProps.load(isr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			try {
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String filePath = variableProps.getProperty("filepath");
		filePath = filePath == null ? "../apk/" : filePath;

		return filePath;
	}
	
	public static void writeFile(MultipartFile file,String path) throws IOException{
		InputStream input = file.getInputStream();
		FileOutputStream fos = new FileOutputStream(path);

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
	}
}
