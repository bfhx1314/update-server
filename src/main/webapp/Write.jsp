<%@ page contentType="text/html; charset=GB2312"%>
<%@ page language="java" %>
<%@ page import="java.io.*" %>
<HTML>
<HEAD>
<TITLE>������д���ļ�</TITLE>
</HEAD>
<BODY>
<%
String fileinto = request.getParameter("fileinto");
String filename = request.getParameter("filename");
String path_new = request.getParameter("path");
String path = request.getRealPath(path_new+"/"); //ȡ��ĿǰĿ¼���ŷ��˵�ʵ��λ��
//FileReader fr = new FileReader(path+ "\\"+filename);
File fileName = new File(path, filename);
fileName.delete();
FileWriter fw = new FileWriter(path + "\\"+filename); //����FileWrite����,���趨��fw�����������
//���ִ�д���ļ�
fw.write(fileinto);
fw.close(); //�ر��ļ�
response.sendRedirect("main.jsp?id="+path_new);%>
</BODY>
</HTML>