package cc.piz.liu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.MessageDigest;
import java.security.PrivilegedAction;
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
			byteBuffer.force();
			clean(byteBuffer);
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				in.close();
				
			} catch (IOException e) {
				e.printStackTrace();
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

	/**
	 * 强制关闭 MappedByteBuffer
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

		String path = "F:\\apache-tomcat-7.0.63\\webapps\\apk\\hhr\\HaowuAgent3.2.1.apk";

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