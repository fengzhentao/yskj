<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <%--<meta name="baidu-site-verification" content="VqulEKHGq0">--%>
  <title>产品详情</title>
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
  <link href="${pageContext.request.contextPath}/static/css/style.mini.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" async="" src="${pageContext.request.contextPath}/static/js/9eb94fd4eae2a1d6.js">
  </script><script charset="utf-8" src="${pageContext.request.contextPath}/static/js/v.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.9.1.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/usrjquery.mini.js"></script>
  <link href="${pageContext.request.contextPath}/static/images/logo/bitbug_favicon.ico" rel="shortcut icon">
  <script src="${pageContext.request.contextPath}/static/js/share.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/share_style0_16.css">
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/productjquery.mini.js"></script>
  <script type="application/javascript">
    function paramlist() {
      var twoId = $("#twoId").val();
//      alert(twoId);
      $.ajax({
        type: "GET",
        url: "${pageContext.request.contextPath}/gdc/"+twoId+"/getParams.html",
        dataType: "json",
        success: function(data){
//          console.log(data);
          var list = data.data;
          if(list.length>0) {
            for(var i=0;i<list.length;i++) {
              console.log("imgurl:"+list[i].url);
              $("#params").append("<li><img src='/"+list[i].url+"'/></li>");
            }
          }
        }
      });
    }
    function cleanParams() {
      $("#params li").remove();
    }
  </script>
</head>
<body>
<jsp:include page="../../front/common/head.jsp"/>
<div style="width: 100%;height: 150px">
  <img src="${pageContext.request.contextPath}/${dahangtu.logoUrl}" alt="" style="width: 100%;height: 100%"/>
</div>
<!-- START small_banner -->
<!--<section class="small_banner" style="background-color: #ebebeb;">
  <div class="center-wrap">
    <h2 class="page-banner-heading" style="color: blue;">
      产品详情  </h2>
    <p class="page-banner-description" style="color: blue;">${slogan.sloganName}<br>${slogan.sloganContext}</p>
    <div class="breadcrumbs" style="color: blue;"> <a href="${pageContext.request.contextPath}/index.html" style="color: blue;">首页</a> → 产品详情
    </div>
  </div>
</section>-->
<!--单页-->
<section id="content-container" class="clearfix">
  <div id="main-wrap" class="clearfix">

    <div class="sidebar">
      <!--END 产品系列列表-->
      <div class="subNavBox">
        <c:forEach var="leftClassVo" items="${leftClassVos}">
          <div class="subNav">
            <a href="${pageContext.request.contextPath}/gcc/${leftClassVo.oneTypeId}/oneGoodsClass.html">${leftClassVo.oneTypeName}</a>
          </div>
            <c:choose>
               <c:when test="${leftClassVo.opentype==1}">
                <ul class="navContent" style="display:block">
                                <c:forEach var="ptt" items="${leftClassVo.productTwoTypes}">
                                  <li><a href="${pageContext.request.contextPath}/gcc/${ptt.twoTypeId}/twoGoodsClass.html"><span>${ptt.twoTypeName}</span></a></li>
                                </c:forEach>
                        </ul>
               </c:when>
               <c:otherwise>
                   <ul class="navContent" style="display:none">
                                   <c:forEach var="ptt" items="${leftClassVo.productTwoTypes}">
                                     <li><a href="${pageContext.request.contextPath}/gcc/${ptt.twoTypeId}/twoGoodsClass.html"><span>${ptt.twoTypeName}</span></a></li>
                                   </c:forEach>
                           </ul>
               </c:otherwise>
            </c:choose>
        </c:forEach>
      </div>
      <div class="sidebar-widget wap_sidebar_widget">
          <p class="widget-heading">推荐产品</p>
          <ul class="subnav_recommend">
            <c:forEach var="product" items="${products}" >
            <li>
              <div class="one_sixth" style="float: left; width: 160px;">
                <a title="${product.productName}" href="${pageContext.request.contextPath}/gdc/${product.productId}/goodsDetail.html" target="_blank">
                  <img alt="${product.productName}" src="${pageContext.request.contextPath}/${product.url}" class="rrItemImage" title="${product.productName}">
                </a>
                <div class="rrItemName">
                  <p>${product.productName}</p>
                </div>
              </div>
            </li>
            </c:forEach>
          </ul>
      </div>
    </div>


    <!--END 产品系列列表-->
    <!--START 产品内容-->
    <div class="page_content_right sub-content page_product_padding">
      <div class="clearfix iso-space product_space">

        <div class="product_space_head">
          <div class="product_space_head_l">
            <!--单个产品头图-->
            <div class="lightbox-zoom">
              <a class="hover-item" data-gal="prettyPhoto[group0]" href="${pageContext.request.contextPath}/${productVo.url}" title="" style="opacity: 1;">
                <img src="${pageContext.request.contextPath}/${productVo.url}" alt="" title="">
              </a>
            </div>
          </div>
          <ul class="product_space_head_r">
            <li>
              <%--<strong>产品名称：</strong>--%>
              <p><input type="hidden" id="twoId" name="twoId" value="${productVo.twoTypeId}"></p>
              <h3>${productVo.productName}</h3>
              <p>${productVo.productContext}</p>
            </li>
            <li>
              <strong>产品型号：</strong>${productVo.productModel}
            </li>
            <li>
              <strong>产品尺寸：</strong>${productVo.productSize}
            </li>
          </ul>
          <div style="float: left;width: 170px;height: 70px;padding-left: 30px;padding-top: 30px;">
            <div style="width: 100%;clear:both">
              <div style="width: 15px;float: left"><img src="../../static/images/cssImage/gmt.jpg"style="margin-top: 5px;"/></div>
              <div style="width: 80px;float: left">
                <a style="margin-left:10px;color:dodgerblue;padding-bottom:5px;border-bottom: 1px solid dodgerblue;" href="${productVo.productUrl}" target="_blank">立即购买</a>
              </div>
            </div>
          </div>
        </div>

        <div class="lineDiv">
          <div class="titles">
            <ul class="ulTitle">
              <li class="liTitle selected" onclick="return cleanParams();">产品信息</li>
              <%--<li class="liTitle" onclick="return paramlist();">参数</li>--%>
              <%--<li class="liTitle" onclick="return cleanParams();">购买</li>--%>
              <%--<li class="liTitle">资料下载</li>--%>
              <%--<li class="liTitle">知识问答</li>--%>
            </ul>
          </div>

          <div class="divCons divDis"><p></p>
            <c:forEach var="att" items="${attachmentList}">
              <p><img src="${pageContext.request.contextPath}/${att.url}" border="0"></p>
            </c:forEach>
          </div>
          <%--<div class="divCons">--%>
            <%--<div class="padtop paramtable">--%>
              <%--<div align="center"></div>--%>
              <%--<ul id="params">--%>
                <%--&lt;%&ndash;<c:forEach var="param" items="${paramList}">&ndash;%&gt;--%>
                  <%--&lt;%&ndash;<li><img src="${pageContext.request.contextPath}/${param.url}" border="0"></li>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
              <%--</ul>--%>
              <%--<div style="clear:both"></div>--%>
            <%--</div>--%>
          <%--</div>--%>

          <%--<div class="divCons usr_product_order">--%>
            <%--&lt;%&ndash;<p class="odd">在线购买</p>&ndash;%&gt;--%>
            <%--<ul>--%>
              <%--<li>官方淘宝店：<a href="https://yyrd.taobao.com/index.htm?spm=2013.1.w5002-12519292057.2.TQ3wcm" rel="external nofollow" target="_blank">https://yyrd.taobao.com/index.htm?spm=2013.1.w5002-12519292057.2.TQ3wcm</a></li>--%>
            <%--</ul>--%>
          <%--</div>--%>

          <div class="divCons">
            <ul id="download">
              <li class="odd">说明书</li>
              <li><a href="http://www.usr.cn/Download/424.html" target="_blank" title="在新窗口中打开查看详情"><span>[说明书]USR-G780说明书</span></a><span>&nbsp;&nbsp;|&nbsp;<a href="http://www.usr.cn/Down/Instructions/USR-G780-V1.0.4.pdf" target="_blank">直接下载</a></span></li>
              <li><a href="http://www.usr.cn/Download/425.html" target="_blank" title="在新窗口中打开查看详情"><span>[软件设计手册]USR-G780</span></a><span>&nbsp;&nbsp;|&nbsp;<a href="http://www.usr.cn/Down/Instructions/USR-G780-software-V1.0.4.pdf" target="_blank">直接下载</a></span></li>
              <li><a href="http://www.usr.cn/Download/426.html" target="_blank" title="在新窗口中打开查看详情"><span>3G/4G无线服务器选型表</span></a><span>&nbsp;&nbsp;|&nbsp;<a href="http://www.usr.cn/Down/Development/3G-4Gsever-gehe.pdf" target="_blank">直接下载</a></span></li>
              <li><a href="http://www.usr.cn/Download/427.html" target="_blank" title="在新窗口中打开查看详情"><span>[规格书]USR-G780</span></a><span>&nbsp;&nbsp;|&nbsp;<a href="http://www.usr.cn/Down/Instructions/USR-G780-spec-V1.0.1.pdf" target="_blank">直接下载</a></span></li>
              <li class="odd">开发资料</li>
              <li><a href="http://www.usr.cn/Download/415.html" target="_blank" title="在新窗口中打开查看详情"><span>[设置软件]4G DTU&amp;4G模块的设置软件</span></a><span>&nbsp;&nbsp;|&nbsp;<a href="http://www.usr.cn/Down/Development/USR-78x%20V1.0.0.73.exe" target="_blank">直接下载</a></span></li>
              <li><a href="http://www.usr.cn/Download/428.html" target="_blank" title="在新窗口中打开查看详情"><span>[升级工具]USR-G780升级工具</span></a><span>&nbsp;&nbsp;|&nbsp;<a href="http://www.usr.cn/Down/Development/USR-G780-Update_Tools-1.0.zip" target="_blank">直接下载</a></span></li>                  <li class="odd">公司资料</li>
              <li><a href="http://www.usr.cn/Download/291.html" target="_blank" title="在新窗口中打开查看详情"><span>有人[2016.09] 大画册下载</span></a><span>&nbsp;&nbsp;|&nbsp;<a href="http://www.usr.cn/Down/USR_picture.pdf" target="_blank">直接下载</a></span></li>
            </ul>
          </div>

          <div  class="divCons">
            <ul id="faq" class="padtop">
              <li><a href="http://www.usr.cn/Faq/254.html" target="_blank"><span>4G DTU固件升级：FTP自升级（USR-G780）</span></a>&nbsp;</li>
              <li><a href="http://www.usr.cn/Faq/255.html" target="_blank"><span>4G DTU基本测试通信和使用案例（USR-G780）</span></a>&nbsp;</li>			            </ul>
          </div>	    <!--END 这里是产品内容-->
        </div>
        <!-- END of page_content-->
      </div>
    </div>
    <!--END 产品内容-->
  </div>
  <!-- END main-wrap -->
</section>
<!--底部-->
<jsp:include page="../../front/common/foot.jsp"/>
</body>
</html>
