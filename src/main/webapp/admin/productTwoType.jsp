<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>产品二类管理页面</title>
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
                strIds.push(selectedRows[i].twoTypeId);
            }
            var ids=strIds.join(",");
            $.messager.confirm("系统提示","您确定要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
                if(r){
                    $.post("${pageContext.request.contextPath}/productTwoType/delete.html",{ids:ids},function(result){
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
            $("#dlg").dialog("open").dialog("setTitle","添加产品二类信息");
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/productTwoType/getProductOneList.html",
                dataType: "json",
                success: function(data){
                    var list = data.productOneTypes;
                    if(list.length>0) {
                        for(var i=0;i<list.length;i++) {
                            $("#oneTypeId").append("<option value='"+list[i].oneTypeId+"'>"+list[i].oneTypeName+"</option>");
                        }
                    }
                }
            });
            url="${pageContext.request.contextPath}/productTwoType/save.html";
        }

        function openBlogTypeModifyDialog(){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length!=1){
                $.messager.alert("系统提示","请选择一条要编辑的数据！");
                return;
            }
            var row=selectedRows[0];
            $("#dlg").dialog("open").dialog("setTitle","编辑产品二类信息");
            $("#fm").form("load",row);
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/productTwoType/getProductOneList.html",
                dataType: "json",
                success: function(data){
                    var list = data.productOneTypes;
                    if(list.length>0) {
                        for(var i=0;i<list.length;i++) {
                            $("#oneTypeId").append("<option value='"+list[i].oneTypeId+"'>"+list[i].oneTypeName+"</option>");
                        }
                    }
                }
            });
            url="${pageContext.request.contextPath}/productTwoType/save.html?twoTypeId="+row.twoTypeId;
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
            $("#imageFile").val("");
            $("#recommend option:first").prop("selected", 'selected');
            $("#twoTypeName").val("");
            $("#oneTypeId").find("option").not(":first").remove();
        }

        function closeBlogTypeDialog(){
            $("#dlg").dialog("close");
            resetValue();
        }

        function AddAttachment(obj) {
            var src = '${pageContext.request.contextPath}/static/images/delete.png';
            var html = '<div><input type="file" name="detailImageFiles"/>'
                    +'<img src="'+src+'" style="cursor: pointer;width: 12px;height: 12px;vertical-align: middle;" onclick="delImg(this)"/>' +
                    '</div>';
            $(obj + ' td.upFiles').append(html);
            return false;
        }
        function delImg(obj){
            $(obj).parent().remove();
        }
    </script>
</head>
<body style="margin: 1px">
<table id="dg" title="产品二类管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${pageContext.request.contextPath}/productTwoType/list.html" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="twoTypeId" width="20" align="center">编号</th>
        <th field="twoTypeName" width="20" align="center">产品二类名称</th>
        <th field="oneTypeName" width="20" align="center">所属一类名称</th>
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


<div id="dlg" class="easyui-dialog" style="width:500px;height:240px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">

    <form id="fm" method="post" enctype="multipart/form-data">
        <table cellspacing="8px">
            <tr>
                <td>产品二类名称：</td>
                <td><input type="text" id="twoTypeName" name="twoTypeName" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>所属产品一类：</td>
                <td>
                    <select class="easyui-numberbox" name="oneTypeId" id="oneTypeId">
                        <option value="">请选择</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>产品二类图片：</td>
                <td><input type="file" id="imageFile" name="imageFile"/></td>
            </tr>
            <tr>
                <td>参数图片：</td>
                <td class="upFiles">
                    <button style="cursor:pointer;" onclick="return AddAttachment('#dlg');" >添加附件</button><br/>
                    <input type="file" name="detailImageFiles"/>
                </td>
            </tr>
            <tr>
                <td>是否推荐：</td>
                <td>
                    <select name="recommend" id="recommend">
                        <option value="1">请选择</option>
                        <option value="0">不推荐</option>
                        <option value="1">推荐</option>
                    </select>
                </td>
            </tr>
            <%--<tr>--%>
                <%--<td>语言：</td>--%>
                <%--<td>--%>
                    <%--<select name="languageType" id="languageType">--%>
                        <%--<option value="0">请选择</option>--%>
                        <%--<option value="0">汉语</option>--%>
                        <%--<option value="1">英语</option>--%>
                    <%--</select>--%>
                <%--</td>--%>
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
