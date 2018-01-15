<%@ page contentType="text/html; charset=GB2312"%>
<%@ page import="java.io.*" %>
<%@ page language="java" %>
<HTML>
<HEAD>
<TITLE>文件的建立与删除</TITLE>
</HEAD>
<BODY>
<CENTER>
<FONT SIZE = 5 COLOR = blue>文件的建立与删除</FONT>
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
//建立代表目前目录位置中File.txt档的File变量, 并由fileName变量变数引用
String path = request.getRealPath(path_new);
File fileName = new File(path, filename_new);
//检查File.txt是否存在
if(fileName.exists()&&(doid_new==1))
{
	//删除File.txt档
    //fileName.renameTo(new File(path, "love.txt"));
	fileName.delete();
	//输出目前所在的目录路径
	//out.println(path + "\\File.txt");
	%>
	<FONT SIZE = 4 COLOR = red>存在</FONT>, 已完成
	<FONT SIZE = 4 COLOR = red>删除</FONT>
	<%
}
else
{if(fileName.exists()&&(doid_new==2)){
	//在目前的目录下建立一个名为File.txt的文字档	
	fileName.renameTo(new File(path, newname));
	//fileName.createNewFile();
		//输出目前所在的目录路径
	//out.println(path + "\\File.txt");
	%>
	<FONT SIZE = 4 COLOR = red>不存在</FONT>, 已完成
	<FONT SIZE = 4 COLOR = red>建立</FONT>
	<%
}else{out.println("no");}}
response.sendRedirect("main.jsp?id="+path_new);%>
</BODY>
</HTML>