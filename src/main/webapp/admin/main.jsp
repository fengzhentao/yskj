<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
	<link href="${pageContext.request.contextPath}/static/images/logo/bitbug_favicon.ico" rel="shortcut icon">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

	var url;
	
	function openTab(text,url,iconCls){
		if($("#tabs").tabs("exists",text)){
			$("#tabs").tabs("select",text);
		}else{
			var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/admin/"+url+"'></iframe>";
			$("#tabs").tabs("add",{
				title:text,
				iconCls:iconCls,
				closable:true,
				content:content
			});
		}
	}


</script>
</head>
<body class="easyui-layout">
<div region="north" style="height: 78px;background-color: #E0ECFF">
	<table style="padding: 5px" width="100%">
		<tr>
			<td width="50%">
				<img alt="logo" src="${pageContext.request.contextPath}/static/images/logo/log.png">
			</td>
			<td valign="bottom" align="right" width="50%">
				<%--<font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>${currentUser.userName }</font>--%>
			</td>
		</tr>
	</table>
</div>
<div region="center">
	<div class="easyui-tabs" fit="true" border="false" id="tabs">
		<div title="首页" data-options="iconCls:'icon-home'">
			<div align="center" style="padding-top: 100px"><font color="red" size="10">欢迎使用</font></div>
		</div>
	</div>
</div>
<div region="west" style="width: 200px" title="导航菜单" split="true">
	<div class="easyui-accordion" data-options="fit:true,border:false">
		<div title="后台管理" data-options="iconCls:'icon-bklb'" style="padding:10px">
			<a href="javascript:openTab('用户信息管理','adminUser.jsp','icon-bklb')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">用户信息管理</a>
			<a href="javascript:openTab('产品一类信息管理','productOneType.jsp','icon-bklb')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">产品一类信息管理</a>
			<a href="javascript:openTab('产品二类信息管理','productTwoType.jsp','icon-bklb')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">产品二类信息管理</a>
			<a href="javascript:openTab('产品信息管理','product.jsp','icon-bklb')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">产品信息管理</a>
			<a href="javascript:openTab('banner信息管理','banner.jsp','icon-bklb')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">banner信息管理</a>
			<a href="javascript:openTab('新闻信息管理','news.jsp','icon-bklb')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">新闻信息管理</a>
			<a href="javascript:openTab('写文本页面','writeRichText.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px">写文本页面</a>
			<a href="javascript:openTab('宣传语管理页面','Slogan.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px">宣传语管理页面</a>
			<a href="javascript:openTab('导航图管理页面','Logo.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px">导航图管理页面</a>
		</div>
	</div>
</div>
<div region="south" style="height: 25px;padding: 5px" align="center">
	Copyright © 20170228
</div>
 
</body>
</html>