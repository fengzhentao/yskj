<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>资讯</title>

    <link href="${pageContext.request.contextPath}/static/css/style.mini.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" async="" src="${pageContext.request.contextPath}/static/js/9eb94fd4eae2a1d6.js">
    </script><script charset="utf-8" src="${pageContext.request.contextPath}/static/js/v.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/usrjquery.mini.js"></script>
    <link href="${pageContext.request.contextPath}/static/images/logo/bitbug_favicon.ico" rel="shortcut icon">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
    <script src="${pageContext.request.contextPath}/static/js/share.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/share_style0_16.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/productjquery.mini.js"></script>
    <%--bootstrap--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/blog.css">--%>
    <%--<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>--%>
    <style type="text/css">
        .wp-pagenavi li {
            float: left;
            padding: 0px 5px;
        }
    </style>
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
            资讯  </h2>
        <p class="page-banner-description" style="color: blue;">${slogan.sloganName}<br>${slogan.sloganContext}</p>
        <div class="breadcrumbs" style="color: blue;"> <a href="${pageContext.request.contextPath}/index.html" style="color: blue;">首页</a> → 资讯
        </div>
    </div>
</section>-->
<!--单页-->
<section id="content-container" class="clearfix">
    <div id="main-wrap" class="clearfix">
        <!--START 新闻类型-->
        <aside class="subnav_cont sidebar">
            <div class="subnav">
                <ul id="Series_nav">
                    <li>
                        <a href="${pageContext.request.contextPath}/news/1/index.html">资讯快报
                            <%--<span>1</span>--%>
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/news/4/index.html">行业动向
                            <%--<span>4</span>--%>
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/news/5/index.html">新闻资讯
                            <%--<span>5</span>--%>
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/news/6/index.html">产品相关
                            <%--<span>6</span>--%>
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/news/7/index.html">行业资讯
                            <%--<span>7</span>--%>
                        </a>
                    </li>
                </ul>
            </div>
            <!-- END subnav -->
        </aside>
        <!--END 新闻类型-->
        <div class="page_content_right sub-content">
            <div id="iso-wrap">
                <c:forEach var="news" items="${newsList}">
                    <div class="page_news_content">
                        <a href="${pageContext.request.contextPath}/news/${news.newsId}/articles.html">${news.newsName}</a>
                        <span>&nbsp;|&nbsp;<fmt:formatDate  value="${news.createTime}" type="both" pattern="yyyy.MM.dd" /></span>
                    </div>
                </c:forEach>
                <%--<div class="page_news_content">--%>
                    <%--<a href="http://www.usr.cn/News/585.html">工业级四串口服务器增加EMC保护</a>--%>
                    <%--<span>&nbsp;|&nbsp;2017-03-01</span>--%>
                <%--</div>--%>
            </div>
            <div class="plist">
                <div class="wp-pagenavi">
                    ${pageCode}
                </div>
            </div>
            <!-- END tour-pagination-links -->
        </div>
        <!-- END page_content-->
    </div>
    <!-- END main-wrap -->
</section>
<!--底部-->
<jsp:include page="../../front/common/foot.jsp"/>
</body>
</html>
