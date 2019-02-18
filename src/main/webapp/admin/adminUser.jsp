<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户管理页面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">

        var url;

        function deleteBlogType(){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length==0){
                $.messager.alert("系统提示","请选择要删除的数据！");
                return;
            }
            var strIds=[];
            for(var i=0;i<selectedRows.length;i++){
                strIds.push(selectedRows[i].adminUserId);
            }
            var ids=strIds.join(",");
            $.messager.confirm("系统提示","您确定要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
                if(r){
                    $.post("${pageContext.request.contextPath}/adminUser/delete.do",{ids:ids},function(result){
                        if(result.success){
                            if(result.exist){
                                $.messager.alert("系统提示",result.exist);
                            }else{
                                $.messager.alert("系统提示","数据已成功删除！");
                            }
                            $("#dg").datagrid("reload");
                        }else{
                            $.messager.alert("系统提示","数据删除失败！");
                        }
                    },"json");
                }
            });
        }

        function openBlogTypeAddDialog(){
            $("#dlg").dialog("open").dialog("setTitle","添加用户信息");
            url="${pageContext.request.contextPath}/adminUser/save.html";
        }

        function openBlogTypeModifyDialog(){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length!=1){
                $.messager.alert("系统提示","请选择一条要编辑的数据！");
                return;
            }
            var row=selectedRows[0];
            $("#dlg").dialog("open").dialog("setTitle","编辑用户信息");
            $("#fm").form("load",row);
            url="${pageContext.request.contextPath}/adminUser/save.html?adminUserId="+row.adminUserId;
            clean();
        }

        function saveBlogType(){
            $("#fm").form("submit",{
                url:url,
                onSubmit:function(){
                    return $(this).form("validate");
                },
                success:function(result){
                    var result=eval('('+result+')');
                    if(result.success){
                        $.messager.alert("系统提示","保存成功！");
                        resetValue();
                        $("#dlg").dialog("close");
                        $("#dg").datagrid("reload");
                    }else{
                        $.messager.alert("系统提示","保存失败！");
                        return;
                    }
                }
            });
        }

        function resetValue(){
            $("#adminUserName").val("");
            $("#phone").val("");
            $("#passWord").val("");
        }

        function closeBlogTypeDialog(){
            $("#dlg").dialog("close");
            resetValue();
        }
        function clean() {
            $("#passWord").val("");
        }
    </script>
</head>
<body style="margin: 1px">
<table id="dg" title="用户管理管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${pageContext.request.contextPath}/adminUser/list.html" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="adminUserId" width="20" align="center">编号</th>
        <th field="adminUserName" width="20" align="center">用户名</th>
        <th field="phone" width="100" align="center">用户手机</th>
        <%--<th field="passWord" width="100" align="center">密码</th>--%>
        <%--<th field="address" width="100" align="center">用户地址</th>--%>
        <%--<th field="email" width="100" align="center">用户邮箱</th>--%>
        <%--<th field="headUrl" width="100" align="center">用户头像</th>--%>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openBlogTypeAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:openBlogTypeModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:deleteBlogType()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
</div>


<div id="dlg" class="easyui-dialog" style="width:500px;height:180px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">

    <form id="fm" method="post" enctype="multipart/form-data">
        <table cellspacing="8px">
            <tr>
                <td>用户名：</td>
                <td><input type="text" id="adminUserName" name="adminUserName" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>用户手机：</td>
                <td><input type="text" id="phone" name="phone" class="easyui-numberbox" required="true"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                <input type="text" id="passWord" name="passWord" required="true"/>
                </td>
            </tr>
            <%--<tr>--%>
                <%--<td>用户头像：</td>--%>
                <%--<td><input type="file" id="imageFile" name="imageFile"/></td>--%>
            <%--</tr>--%>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:saveBlogType()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeBlogTypeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
</body>
</html>
