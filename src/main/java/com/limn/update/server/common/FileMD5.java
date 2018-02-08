package com.limn.update.server.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.MessageDigest;
import java.security.PrivilegedAction;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;

/**
 * MD5加密
 * 
 * @author Administrator
 *
 */
public class FileMD5 {

	static char hexdigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	private static HashMap<String,String> md5Data = new HashMap<String,String>();

	public static String getMd5ByFile(File file) {
		String value = null;
		
		if(md5Data.containsKey(file.getName()+file.getTotalSpace()+file.lastModified())){
			return md5Data.get(file.getName()+file.getTotalSpace()+file.lastModified());
		}
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(byteBuffer);
			byte[] b = md5.digest();
			clean(byteBuffer);
			value = byteToHexString(b);
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				in.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		md5Data.put(file.getName()+file.getTotalSpace()+file.lastModified(),value);
		return value;
	}


	private static String byteToHexString(byte[] tmp) {

		String s;

		// 用字节表示就是 16 个字节

		// 每个字节用 16 进制表示的话，使用两个字符，所以表示成 16 进制需要 32 个字符

		// 比如一个字节为01011011，用十六进制字符来表示就是“5b”

		char str[] = new char[16 * 2];

		int k = 0; // 表示转换结果中对应的字符位置

		for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节转换成 16 进制字符的转换

			byte byte0 = tmp[i]; // 取第 i 个字节

			str[k++] = hexdigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移

			str[k++] = hexdigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换

		}



		s = new String(str); // 换后的结果转换为字符串

		return s;

	}

	public static String dataFormat(Long data) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
		java.util.Date dt = new Date(data);
		String sDateTime = sdf.format(dt); // 得到精确到秒的表示：08/31/2006
											// 21:08:00
		return sDateTime;

	}

	/**
	 * 强制关闭 MappedByteBuffer
	 * 
	 * @param buffer
	 * @throws Exception
	 */
	private static void clean(final Object buffer) throws Exception {
		if (buffer != null) {
			AccessController.doPrivileged(new PrivilegedAction() {
				public Object run() {
					try {
						Method getCleanerMethod = buffer.getClass().getMethod("cleaner", new Class[0]);
						getCleanerMethod.setAccessible(true);
						sun.misc.Cleaner cleaner = (sun.misc.Cleaner) getCleanerMethod.invoke(buffer, new Object[0]);
						cleaner.clean();
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
			});
		}

	}

	public static void main(String[] args) throws IOException {

		String path = "/Users/limengnan/Documents/wxcm/lua/test.lua";

		String md5 = FileMD5.getMd5ByFile(new File(path));

		System.out.println(md5);

	}

	public static String getFileSizes(File f) {// 取得文件大小
		String size = "unknow";
		FileInputStream fis = null;
		try {
			double s = 0;
			if (f.exists()) {

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
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return size;
	}

	

}
