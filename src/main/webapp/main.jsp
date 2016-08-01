<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java"%>
<%@ page import="java.io.*"%>
<%@ page import="java.net.*"%>
<%@ page import="java.util.Arrays" %>>
<%@ page import="com.limn.update.server.controller.*"%>
<%@ page import="com.limn.update.server.common.*"%>

<%
	String strid = request.getParameter("id");
	//解码
	if (null == strid) {
		strid = "";
	}
	strid = URLDecoder.decode(strid, "utf-8");

	String upLevel = strid;
	if (strid.lastIndexOf("/") != -1) {
		upLevel = strid.substring(0, strid.lastIndexOf("/"));
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>文件管理</title>
<link rel="stylesheet" type="text/css" href="./css/pagecontent.css">
<script type="text/javascript" src="./css/jquery.js"></script>
<script type="text/javascript" src="./css/jquery.modal.js"></script>
<script type="text/javascript" src="./css/filehandler.js"></script>
</head>
<body>


	<div id="headerWraper">
		<img src="./css/upload.png" id="headerImg" width="57" height="57">
		<h2>文件管理</h2>
	</div>



	<div class="filepath">
		<input type="hidden"  id="navigation" value="<%=strid%>"/>
		<p>
			<%=strid%>
		</p>
	</div>


	<table class="frameTable" cellpadding="0" cellspacing="0">

		<tr>
			<td class="top_content">
				<!-- top table contents -->
				<div class="link_button"></div>
				<table cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td class="top_content_table"><a
								href="main.jsp?id=<%=URLEncoder.encode(upLevel, "UTF-8")%>"
								id="mylink" title="Go up a folder level"><img
									src="./css/webfolderup.png" width="15" height="15">Up one
									Level</a></td>
							<td class="top_content_table"><a href="" class="mylink"
								title="Reload"
								onclick="window.location.href=window.location.href"><img
									src="./css/webrefresh.png" width="15" height="15">Reload</a>
							</td>
							<td class="top_content_table"><a
								class="mylink" title="Create Folder"
								onclick="modalPopup(&#39;&#39;, 1, navigation.value);"><img
									src="./css/webcreatefolder.png" width="20" height="14">
									Create Folder</a></td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
		</thead>
		<tbody>
			<tr>
				<!-- left table contents -->
				<td class="left_content">
					<div id="filesContent">
						<table cellpadding="0" cellspacing="0" class="filesTable">
							<thead>
								<tr>
									<td class="hi"></td>
									<td class="hn">名称</td>
									<td class="hm">修改时间</td>
									<td class="hs">大小</td>
									<td class="hk">类型</td>
									<td class="he"></td>
									<td class="he"></td>
									<td class="hl"></td>
								</tr>
							</thead>
							<tbody>

								<%
									//取得目前目录的磁盘目录
									String path = request.getRealPath("/");
									
									//建立代表目前目录位置的d变量
									System.out.println(path + Utils.getAPKPath("") + strid);
									
									File d = new File(path + Utils.getAPKPath("") + strid);
									//取得代表目录中所有文件
	
									
									File[] list = d.listFiles();
									
									Arrays.sort(list, new CompratorByLastModified());  
									for (int i = 0; i < list.length; i++) {

										if (!list[i].isDirectory()) {
								%>

								<tr>
									<td class="i"><a href=""><img src="./css/unknown.png"
											width="20" height="20"></a></td>
									<td class="n"><a
										href="<%=Utils.getAPKPath("") + strid + "/" + list[i].getName()%>"><%=list[i].getName()%></a>
									</td>
									<td class="m"><%=FileMD5.dataFormat(list[i].lastModified())%></td>
									<td class="s"><%=FileMD5.getFileSizes(list[i])%></td>
									<td class="k">file</td>
									<td class="e"><span style="height: 15px; width: 15px;">&nbsp;</span>
									</td>
									<td class="e"><input type="image"
										src="./css/webrename.png"
										onclick="modalPopup(&quot;<%=list[i].getName()%>&quot;, 0, &quot;<%=strid + "/" + list[i].getName()%>&quot;);"
										title="Rename file" width="15" height="15"></td>
									<td class="e"><input type="image"
										src="./css/webdelete.png"
										onclick="modalPopup(&quot;<%=list[i].getName()%>&quot;, 2, &quot;<%=strid + "/" + list[i].getName()%>&quot;);"
										title="Delete file" width="15" height="15"></td>
								</tr>

								<%
									} else {
								%>

								<tr>
									<td class="i"><a
										href="main.jsp?id=<%=URLEncoder.encode(strid + "/" + list[i].getName(), "UTF-8")%>"><img
											src="./css/folder.png" width="20" height="20"></a></td>
									<td class="n"><a
										href="main.jsp?id=<%=URLEncoder.encode(strid + "/" + list[i].getName(), "UTF-8")%>"><%=list[i].getName()%></a>
									</td>
									<td class="m"><%=FileMD5.dataFormat(list[i].lastModified())%></td>
									<td class="s"></td>
									<td class="k">Folder</td>
									<td class="e"><span style="height: 15px; width: 15px;">&nbsp;</span>
									</td>
									<td class="e"><input type="image"
										src="./css/webrename.png"
										onclick="modalPopup(&quot;<%=list[i].getName()%>&quot;, 0, &quot;<%=strid + list[i].getName()%>&quot;);"
										title="Rename file" width="15" height="15"></td>
									<td class="e"><input type="image"
										src="./css/webdelete.png"
										onclick="modalPopup(&quot;<%=list[i].getName()%>&quot;, 2, &quot;<%=strid + list[i].getName()%>&quot;);"
										title="Delete file" width="15" height="15"></td>
								</tr>
								<%
									}
									}
								%>

							</tbody>
						</table>
					</div>

				</td>
				<!-- right table contents -->
				<td class="right_content">
					<form action="" id="upload_form">
					<div id="file-uploader">
						<div class="qq-uploader">
							<div class="qq-upload-drop-area" style="display: inline-block;">
								<span>Drop files here to upload</span>
							</div>
							<div class="qq-upload-button"
								style="position: relative; overflow: hidden; direction: ltr;">
								<img src="./css/webupload.png"
									width="16" height="16"> Upload File
									<input
									multiple="multiple" type="file" name="file" id="uploadFile_Id" 
									style="position: absolute; right: 0px; top: 0px; font-family: Arial; font-size: 118px; margin: 0px; padding: 0px; cursor: pointer; opacity: 0;">
							</div>
							<ul class="qq-upload-list">
							</ul>
						</div>
					</div>
					</form>
				</td>
			</tr>
		</tbody>

	</table>

	<!-- upload file script -->
	<script>             
function createUploader(){         
	var uploader = new qq.FileUploader({         
	element: document.getElementById('file-uploader')         
	});    
}    
window.onload = createUploader;    
</script>

	<!-- modal content -->
	<div id="modal-content">
		<div id="modal-title"></div>
		<div id="modal-text"></div>
		<form name="input" action="" method="post">
			<div id="modal-field"></div>
			<input type="hidden" name="ID" id="ID"><input type="submit"
				name="submitButton" id="submitButton">
		</form>
	</div>

</body>
</html>