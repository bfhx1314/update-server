<%@ page contentType="text/html; charset=GB2312" %>
<%@ page language="java" %>
<%@ page import="java.io.*" %>
<HTML>
<HEAD>
<TITLE>读取文件内容</TITLE>
</HEAD>
<BODY>
<form name="form1" method="post" action="Write.jsp">

<textarea name="fileinto" style="width:550px;height:400px;">
<%
String filename = request.getParameter("filename");
String path_new = request.getParameter("path");
String path = request.getRealPath(path_new+"/"); //取得目前目录在伺服端的实际位置
FileReader fr = new FileReader(path+ "\\"+filename); //建立FileReader变量,并设定由fr变量变数引用
int c = fr.read(); //从文件中读取一个字节
while(c != -1) //判断是否已读到文件的结尾
{
	out.print((char)c); //输出读取到的数据	
	c = fr.read();	//从文件中读取数据
	if(c == 13)	//判断是否为断行字节
	{
		out.print("\n"); //输出分行标签
		fr.skip(1); //略过一个字节
		c = fr.read();	//读取一个字节
	}
}
//关闭文件
fr.close();
%></textarea>
<INPUT TYPE="hidden" NAME="filename" value="<%=filename%>">
<INPUT TYPE="hidden" NAME="path" value="<%=path_new%>">
  <input type="submit" name="Submit" value="提交">
</form>
</BODY>
</HTML>