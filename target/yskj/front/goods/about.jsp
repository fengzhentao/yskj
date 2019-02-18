<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>关于/联系我们</title>
  <link href="${pageContext.request.contextPath}/static/css/style.mini.css" rel="stylesheet" type="text/css">

  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.9.1.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/9eb94fd4eae2a1d6.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/57071.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/h.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/productjquery.mini.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/share.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/usrjquery.mini.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/v.js"></script>


  <link href="${pageContext.request.contextPath}/static/images/logo/bitbug_favicon.ico" rel="shortcut icon">
  <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
</head>
<body>
<jsp:include page="../common/head.jsp"/>
<div style="width: 100%;height: 150px">
  <img src="${pageContext.request.contextPath}/${dahangtu.logoUrl}" alt="" style="width: 100%;height: 100%"/>
</div>
<!--<section class="small_banner" style="background-color: #ebebeb;">
  <div class="center-wrap">
    <h2 class="page-banner-heading" style="color: blue;">
      关于/联系我们
    </h2>
    <p class="page-banner-description" style="color: blue;">${slogan.sloganName}<br>${slogan.sloganContext}</p>
    <div class="breadcrumbs" style="color: blue;"> <a href="${pageContext.request.contextPath}/index.html" style="color: blue;">首页</a> → 关于/联系我们</div>
  </div>
</section>-->
<!--单页-->
<section id="content-container" class="clearfix">
  <div id="main-wrap" class="clearfix">
    <!--START 新闻类型-->
    <aside class="sidebar subnav_cont">
      <div class="subnav">
        <ul id="Series_nav">
          <li><a href="${pageContext.request.contextPath}/ab/2/about.html">关于我们
            <%--<span></span>--%>
          </a></li>
          <li><a href="${pageContext.request.contextPath}/ab/3/about.html">联系我们
            <%--<span></span>--%>
          </a></li>
        </ul>
      </div>
      <!-- END subnav -->
    </aside>
    <!--END 新闻类型-->
    <div class="page_content_right sub-content">
      <div id="iso-wrap" class="usr_page">
        <%--<h2>关于我们</h2>--%>
        <%--<hr/>--%>
        <div id="content">
          <h1>${news.newsName}</h1>
        </div>
          <div id="dotline"></div>
        <div>
          <h1>${news.newsContext}</h1>
        </div>
      </div>
      <!-- END tour-pagination-links -->
    </div>
    <!-- END page_content-->
  </div>
  <!-- END main-wrap -->
</section>
<!--底部-->
<jsp:include page="../common/foot.jsp"/>
</body></html>