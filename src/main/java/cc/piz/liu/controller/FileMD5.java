package cc.piz.liu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MD5加密
 * 
 * @author Administrator
 *
 */
public class FileMD5 {

	public static String getMd5ByFile(File file) throws FileNotFoundException {
		String value = null;
		FileInputStream in = new FileInputStream(file);
		try {
			MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(byteBuffer);
			BigInteger bi = new BigInteger(1, md5.digest());
			value = bi.toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

	public static String dataFormat(Long data) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
		java.util.Date dt = new Date(data);
		String sDateTime = sdf.format(dt); // 得到精确到秒的表示：08/31/2006
											// 21:08:00
		return sDateTime;

	}

	public static void main(String[] args) throws IOException {

//		String path = "E:\\commons-codec-1.9-bin.zip";

//		String v = FileMD5.getFileSizes(new File(path));
//		System.out.println("MD5:" + v.toUpperCase());

//		FileInputStream fis = new FileInputStream(path);

	}

	public static String getFileSizes(File f) {// 取得文件大小
		String size = "unknow";
		try {
			double s = 0;
			if (f.exists()) {
				FileInputStream fis = null;

				fis = new FileInputStream(f);

				s = fis.available();
			} else {
				f.createNewFile();
				System.out.println("文件不存在");
			}
			
			if (s > 1024) {
				s = (double) (s / 1024);
				if (s > 1024) {
					s = (double) (s / 1024);
					if (s > 1024) {
						s = (double) (s / 1024);
						if (s > 1024) {
							s = (double) (s / 1024);
						} else {
							size = "GB";
						}
					} else {
						size = "MB";
					}
				} else {
					size = "KB";
				}
				BigDecimal b = new BigDecimal(s);
				double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				size = f1 + size;
			} else {
				size = s + "B";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return size;
	}

}