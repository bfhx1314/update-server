<%@ page contentType="text/html; charset=gb2312"%>
<%@ page language="java" %>
<%@ page import="java.io.*" %>
<HTML>
<HEAD>
<TITLE>Ŀ¼�Ľ�����ɾ��</TITLE>
</HEAD>
<BODY>
<CENTER>
<FONT SIZE = 5 COLOR = blue>Ŀ¼�Ľ�����ɾ��</FONT>
</CENTER>
<BR>
<HR>
<BR>
<%
  String id = request.getParameter("id");
  byte[] tmpbyte1 = id.getBytes("ISO8859_1");
  id = new String(tmpbyte1,"GB2312");

  String strid = request.getParameter("title");
  byte[] tmpbyte = strid.getBytes("ISO8859_1");
  strid = new String(tmpbyte,"GB2312");

String path = request.getRealPath("/");
//������Ŀ¼·��
path =path + "\\"+id+"\\"+strid;
//��������TestĿ¼��File����, ����dirName������������
File dirName = new File(path);
//���TestĿ¼�Ƿ����
System.out.println(path);
if(dirName.exists())
{
	//ɾ��TestĿ¼
	//dirName.delete();
	%>
	<%//=strid%>
	<%
}
else
{
	//����TestĿ¼	
	dirName.mkdir();
	%>
	<%=strid%>Ŀ¼<FONT SIZE = 4 COLOR = red>������</FONT>, �����
	<FONT SIZE = 4 COLOR = red>����</FONT>
	<%
	response.sendRedirect("main.jsp?id="+id);
}
%>
</BODY>
</HTML>