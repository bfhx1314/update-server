<%@ page contentType="text/html; charset=gb2312"%>
<%@ page language="java" %>
<%@ page import="java.io.*" %>
<HTML>
<HEAD>
<TITLE>目录的建立与删除</TITLE>
</HEAD>
<BODY>
<CENTER>
<FONT SIZE = 5 COLOR = blue>目录的建立与删除</FONT>
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
//建立欲目录路径
path =path + "\\"+id+"\\"+strid;
//建立代表Test目录的File变量, 并由dirName变量变数引用
File dirName = new File(path);
//检查Test目录是否存在
System.out.println(path);
if(dirName.exists())
{
	//删除Test目录
	//dirName.delete();
	%>
	<%//=strid%>
	<%
}
else
{
	//建立Test目录	
	dirName.mkdir();
	%>
	<%=strid%>目录<FONT SIZE = 4 COLOR = red>不存在</FONT>, 已完成
	<FONT SIZE = 4 COLOR = red>建立</FONT>
	<%
	response.sendRedirect("main.jsp?id="+id);
}
%>
</BODY>
</HTML>