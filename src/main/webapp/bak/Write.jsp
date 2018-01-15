<%@ page contentType="text/html; charset=GB2312"%>
<%@ page language="java" %>
<%@ page import="java.io.*" %>
<HTML>
<HEAD>
<TITLE>将数据写入文件</TITLE>
</HEAD>
<BODY>
<%
String fileinto = request.getParameter("fileinto");
String filename = request.getParameter("filename");
String path_new = request.getParameter("path");
String path = request.getRealPath(path_new+"/"); //取得目前目录在伺服端的实际位置
//FileReader fr = new FileReader(path+ "\\"+filename);
File fileName = new File(path, filename);
fileName.delete();
FileWriter fw = new FileWriter(path + "\\"+filename); //建立FileWrite对象,并设定由fw对象变量引用
//将字串写入文件
fw.write(fileinto);
fw.close(); //关闭文件
response.sendRedirect("main.jsp?id="+path_new);%>
</BODY>
</HTML>