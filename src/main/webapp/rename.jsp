<%@page language="java"%>
<%@page contentType="text/html;charset=8859_1"%>
<%@page import="java.sql.*"%>
<html>
<head>
<title>无标题文档</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<script language="javascript">
function subb() {
if(document.form1.newname.value==""){
alert("请填写要修改的文件名称！！");
}
else
document.form1.action="CreateDelete.jsp"
form1.submit();
}
</script>

<body bgcolor="#FFFFFF" text="#000000">
<%
String id = request.getParameter("id");
String doid = request.getParameter("doid");
String filename = request.getParameter("filename");
String path = request.getParameter("path");
%>
<form name="form1" method="post" action="">
  <table width="85%" border="1" cellspacing="0" cellpadding="0" bordercolor="#FFFFFF" bgcolor="#e1e1e1">
    <tr> 
      <td rowspan="3">&nbsp;</td>
      <td>原　文　件　名：</td>
      <td> 
        <input type="hidden" name="id" value="<%=id%>">
        <input type="hidden" name="doid" value="<%=doid%>">
        <input type="hidden" name="path" value="<%=path%>">
        <input type="text" name="filename" value="<%=filename%>">
      </td>
      <td rowspan="3">&nbsp;</td>
    </tr>
    <tr> 
      <td height="28">重命名的文件名：</td>
      <td height="28"> 
        <input type="text" name="newname">
      </td>
    </tr>
    <tr> 
      <td> 
        <input type="button" name="Submit" value="提交" onclick="subb()">　
        <input type="button" name="Submit3" value="返回" onclick="window.history.back()">　<input type="reset" name="Submit2" value="重置">
      </td>
      <td>&nbsp;</td>
    </tr>
  </table>
</form>
</body>
</html>
