<%@ page import="static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>产品管理页面</title>
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
                strIds.push(selectedRows[i].productId);
            }
            var ids=strIds.join(",");
            $.messager.confirm("系统提示","您确定要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
                if(r){
                    $.post("${pageContext.request.contextPath}/product/delete.html",{ids:ids},function(result){
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
            $("#dlg").dialog("open").dialog("setTitle","添加产品信息");
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/product/getProductTwoList.html",
                dataType: "json",
                success: function(data){
                    var list = data.productTwoTypes;
                    if(list.length>0) {
                            $("#twoTypeId").find("option").remove();
                            $("#twoTypeId").append("<option value=''>请选择</option>");
                        for(var i=0;i<list.length;i++) {
                            $("#twoTypeId").append("<option value='"+list[i].twoTypeId+"'>"+list[i].twoTypeName+"</option>");
                        }
                    }
                }
            });
            url="${pageContext.request.contextPath}/product/save.html";
        }

        function openBlogTypeModifyDialog(){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length!=1){
                $.messager.alert("系统提示","请选择一条要编辑的数据！");
                return;
            }
            var row=selectedRows[0];
            $("#dlg").dialog("open").dialog("setTitle","编辑产品信息");
            $("#fm").form("load",row);
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/product/getProductTwoList.html",
                dataType: "json",
                success: function(data){
                    var list = data.productTwoTypes;
                    if(list.length>0) {
                        for(var i=0;i<list.length;i++) {
                            $("#twoTypeId").append("<option value='"+list[i].twoTypeId+"'>"+list[i].twoTypeName+"</option>");
                        }
                    }
                }
            });
            url="${pageContext.request.contextPath}/product/save.html?productId="+row.productId;
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
            $("#productName").val("");
            $("#productModel").val("");
            $("#productSize").val("");
            $("#productContext").val("");

            var file = $("#imageFile") ;
            file.after(file.clone().val(""));
            file.remove();
            var file = $("#detailImageFiles") ;
            file.after(file.clone().val(""));
            file.remove();

            $("#recommend option:first").prop("selected", 'selected');
            $("#twoTypeId").find("option").not(":first").remove();
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
<table id="dg" title="产品管理页面" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${pageContext.request.contextPath}/product/list.html" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="productId" width="20" align="center">编号</th>
        <th field="productName" width="20" align="center">商品名</th>
        <th field="productSize" width="20" align="center">尺寸</th>
        <th field="productUrl" width="20" align="center">购买地址</th>
        <th field="productContext" width="20" align="center">简介</th>
        <th field="twoTypeName" width="20" align="center">所属二类名称</th>
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


<div id="dlg" class="easyui-dialog" style="width:500px;height:400px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">

    <form id="fm" method="post" enctype="multipart/form-data">
        <table cellspacing="8px">
            <tr>
                <td>商品名：</td>
                <td><input type="text" id="productName" name="productName" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>型号：</td>
                <td><input type="text" id="productModel" name="productModel" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>尺寸：</td>
                <td><input type="text" id="productSize" name="productSize" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>购买地址：</td>
                <td><input type="text" id="productUrl" name="productUrl" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>简介：</td>
                <td>
                    <%--<input type="text" id="productSize" name="productModel" class="easyui-validatebox" required="true"/>--%>
                    <textarea rows="5" cols="30" id="productContext" name="productContext" class="easyui-validatebox" required="true"></textarea>
                </td>
            </tr>
            <tr>
                <td>所属产品二类：</td>
                <td>
                    <select class="easyui-numberbox" name="twoTypeId" id="twoTypeId">
                        <option value="">请选择</option>
                    </select>
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
            <tr>
                <td>商品头图：</td>
                <td><input type="file" name="imageFile"/></td>
            </tr>
            <tr>
                <td>商品详情图：</td>
                <td class="upFiles">
                    <button style="cursor:pointer;" onclick="return AddAttachment('#dlg');" >添加附件</button><br/>
                    <input type="file" name="detailImageFiles"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:saveBlogType()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeBlogTypeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
</body>
</html>
