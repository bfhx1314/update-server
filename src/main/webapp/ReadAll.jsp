<%@ page contentType="text/html; charset=GB2312" %>
<%@ page language="java" %>
<%@ page import="java.io.*" %>
<HTML>
<HEAD>
<TITLE>��ȡ�ļ�����</TITLE>
</HEAD>
<BODY>
<form name="form1" method="post" action="Write.jsp">

<textarea name="fileinto" style="width:550px;height:400px;">
<%
String filename = request.getParameter("filename");
String path_new = request.getParameter("path");
String path = request.getRealPath(path_new+"/"); //ȡ��ĿǰĿ¼���ŷ��˵�ʵ��λ��
FileReader fr = new FileReader(path+ "\\"+filename); //����FileReader����,���趨��fr������������
int c = fr.read(); //���ļ��ж�ȡһ���ֽ�
while(c != -1) //�ж��Ƿ��Ѷ����ļ��Ľ�β
{
	out.print((char)c); //�����ȡ��������	
	c = fr.read();	//���ļ��ж�ȡ����
	if(c == 13)	//�ж��Ƿ�Ϊ�����ֽ�
	{
		out.print("\n"); //������б�ǩ
		fr.skip(1); //�Թ�һ���ֽ�
		c = fr.read();	//��ȡһ���ֽ�
	}
}
//�ر��ļ�
fr.close();
%></textarea>
<INPUT TYPE="hidden" NAME="filename" value="<%=filename%>">
<INPUT TYPE="hidden" NAME="path" value="<%=path_new%>">
  <input type="submit" name="Submit" value="�ύ">
</form>
</BODY>
</HTML>