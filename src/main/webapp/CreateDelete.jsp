<%@ page contentType="text/html; charset=GB2312"%>
<%@ page import="java.io.*" %>
<%@ page language="java" %>
<HTML>
<HEAD>
<TITLE>�ļ��Ľ�����ɾ��</TITLE>
</HEAD>
<BODY>
<CENTER>
<FONT SIZE = 5 COLOR = blue>�ļ��Ľ�����ɾ��</FONT>
</CENTER>
<BR>
<HR>
<BR>
<%
String id = request.getParameter("id");
String newname = request.getParameter("newname");
String doid = request.getParameter("doid");
int doid_new=Integer.parseInt(doid);
String filename_new = request.getParameter("filename");

String path_new = request.getParameter("path");
//��������ĿǰĿ¼λ����File.txt����File����, ����fileName������������
String path = request.getRealPath(path_new);
File fileName = new File(path, filename_new);
//���File.txt�Ƿ����
if(fileName.exists()&&(doid_new==1))
{
	//ɾ��File.txt��
    //fileName.renameTo(new File(path, "love.txt"));
	fileName.delete();
	//���Ŀǰ���ڵ�Ŀ¼·��
	//out.println(path + "\\File.txt");
	%>
	<FONT SIZE = 4 COLOR = red>����</FONT>, �����
	<FONT SIZE = 4 COLOR = red>ɾ��</FONT>
	<%
}
else
{if(fileName.exists()&&(doid_new==2)){
	//��Ŀǰ��Ŀ¼�½���һ����ΪFile.txt�����ֵ�	
	fileName.renameTo(new File(path, newname));
	//fileName.createNewFile();
		//���Ŀǰ���ڵ�Ŀ¼·��
	//out.println(path + "\\File.txt");
	%>
	<FONT SIZE = 4 COLOR = red>������</FONT>, �����
	<FONT SIZE = 4 COLOR = red>����</FONT>
	<%
}else{out.println("no");}}
response.sendRedirect("main.jsp?id="+path_new);%>
</BODY>
</HTML>