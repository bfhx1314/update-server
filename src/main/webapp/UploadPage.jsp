<%@page language="java"%>
<%@page contentType="text/html;charset=8859_1"%>
<html>
<head>
<title>
UploadPage
</title>
</head>
<script language="javascript">
function subb() {
document.form1.textfield.value=document.form1.file.value
document.form1.action="Upload.jsp"
form1.submit();
}
</script>
<body>
<%
String id = request.getParameter("id");
session.setAttribute("id",id);
%>
<form method="post" name="form1" action="" enctype="multipart/form-data">
<br><br>
<input type="file" name="file">
  <input type="button" name="ÉÏ´«" value="Submit" onclick="subb()">
  <input type="hidden" name="textfield">
</form>
</body>
</html>
