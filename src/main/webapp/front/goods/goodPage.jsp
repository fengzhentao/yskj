<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<meta name="baidu-site-verification" content="VqulEKHGq0">--%>
    <!-- 避免IE使用兼容模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 微软的老式浏览器 -->
    <meta name="MobileOptimized" content="320">
    <meta name="renderer" content="webkit">
    <%--若页面需默认用极速核，增加标签：<meta name="renderer" content="webkit">
    若页面需默认用ie兼容内核，增加标签：<meta name="renderer" content="ie-comp">
    若页面需默认用ie标准内核，增加标签：<meta name="renderer" content="ie-stand">--%>
    <title>易源瑞达</title>
    <link href="${pageContext.request.contextPath}/static/css/style.mini.css" rel="stylesheet" type="text/css">
    <%--<link href="${pageContext.request.contextPath}/static/css/common.css" rel="stylesheet" type="text/css">--%>

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/9eb94fd4eae2a1d6.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/57071.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/h.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/productjquery.mini.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/share.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/usrjquery.mini.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/v.js"></script>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common.js"></script>--%>

    <link href="${pageContext.request.contextPath}/static/images/logo/bitbug_favicon.ico" rel="shortcut icon">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
    <%--<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, minimum-scale=1.5,maximum-scale=1">--%>
    <style type="text/css">
        .yskj-news{
            float: left;
        }
    </style>
</head>
<body>
<jsp:include page="../../front/common/head.jsp"/>
<h1>tomcat1</h1>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.superslide.js"></script>
<div id="banner">
    <ul class="banner-list clearfix" data-pagemode="False" style="width: 1200px; margin-left: -355px;">
        <c:forEach var="banner" items="${bannerList}">
            <li class="active banner-img" data-com-src="${pageContext.request.contextPath}/${banner.bannerImage}" data-mob-src="${pageContext.request.contextPath}/${banner.bannerImage}"
                style="width: 1200px; padding-top: 0px; height: 400px; z-index: 0; display: block;
                        background: url(${pageContext.request.contextPath}/${banner.bannerImage});">
                <div class="container"><a title="" href="${banner.bannerUrl}" target="_blank"></a></div>
            </li>
        </c:forEach>
    </ul>
    <a href="javascript:void(0)" class="switchingBtn left" style="display: inline;"></a>
    <a href="javascript:void(0)" class="switchingBtn right" style="display: inline;"></a>
    <div class="point-btn-wrap" style="left: 634.5px; top: auto; bottom: 20px;">
        <c:forEach var="banner" items="${bannerList}">
            <a class="" href="javascript:void(0)"></a>
        </c:forEach>
    </div>
</div>
<div id="content-container">
    <div class="center-wrap news-hr">
      <span>
      <a title="资讯快报" href="${pageContext.request.contextPath}/news/1/index.html">资讯快报</a>
      </span>
      <div id="newslist">
        <c:forEach var="news" items="${newsList}">
            <a title="${news.newsName}" href="${pageContext.request.contextPath}/news/${news.newsId}/articles.html">${news.newsName}</a>
        </c:forEach>
      </div>
    </div>

    <div id="main-wrap" class="main-wrap-slider clearfix">
        <div>
            <c:forEach var="productOneType" items="${productOneTypes}">
                <div class="one_third" style="width:23%;">
                    <div class="one_third_margin">
                        <div class="overflow-hidden">
                            <a title="${productOneType.oneTypeName}" href="${pageContext.request.contextPath}/gcc/${productOneType.oneTypeId}/oneGoodsClass.html">
                                <img class="rrItemImage" alt="${productOneType.oneTypeName}" src="${pageContext.request.contextPath}/${productOneType.imageUrl}" title="${productTwoType.twoTypeName}">
                            </a>
                        </div>
                        <div class="one_third_content">${productOneType.oneTypeName}</div>
                    </div>
                </div>
            </c:forEach>
            <div style="clear:both;"></div>
        </div>
        <div class="J_starCarousel">
            <div class="rrStrat">
                <span><a href="#">产品展示 / News information</a></span>
                <div class="more">
                    <a class="control control-prev prevStop" href="javascript:void(0);"></a>
                    <a class="control control-next" href="javascript:void(0);"></a>
                </div>
            </div>
            <div class="control_content">
                <div class="tempWrap" style="overflow:hidden; position:relative; width:1200px">
                    <ul class="rainbow-list" style="width: 1200px; left: 0px; position: relative; overflow: hidden; padding: 0px; margin: 0px;">
                        <c:forEach var="product" items="${products}" >
                            <div class="one_sixth" style="float: left; width: 160px;">
                                <a title="${product.productName}" href="${pageContext.request.contextPath}/gdc/${product.productId}/goodsDetail.html" target="_blank">
                                    <img alt="${product.productName}" src="${pageContext.request.contextPath}/${product.url}" class="rrItemImage" title="${product.productName}">
                                </a>
                                <%--<div class="rrItemTitle">--%>
                                    <%--<a title="" href="/Product/135.html" target="_blank">--%>
                                        <%--<h2>${product.productName}</h2>--%>
                                    <%--</a>--%>
                                <%--</div>--%>
                                <div class="rrItemName">
                                    <p>${product.productName}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="main_content_bg">
        <div class="main_content_wd">
            <div class="one_third content1">
                <div class="main_content_title">
                    <%--<a class="main_content_more" href="http://www.usr.cn/News/index.html" target="_blank">更多&gt;&gt;</a>--%>
                    新闻资讯
                </div>
                <ul>
                    <c:forEach var="new_5" items="${newsList_5}">
                        <li><a title="${new_5.newsName}" href="${pageContext.request.contextPath}/news/${new_5.newsId}/articles.html">${new_5.newsName}</a></li>
                    </c:forEach>
                </ul>
</div>
<div class="one_third">
    <div class="main_content_title">
        <%--<a class="main_content_more" href="http://www.usr.cn/Faq/index.html" target="_blank">更多&gt;&gt;</a>--%>
                    产品相关
                </div>
                <ul>
                    <%--<li>--%>
                        <%--<span>[03-06]</span>--%>
                        <%--<a title="USR-LTE-7S4升级固件： FTP自升级" href="#" target="_blank">USR-LTE-7S4升级固件： FTP自升级</a>--%>
                    <%--</li>--%>
                        <c:forEach var="new_6" items="${newsList_6}">
                            <li><a title="${new_6.newsName}" href="${pageContext.request.contextPath}/news/${new_6.newsId}/articles.html">${new_6.newsName}</a></li>
                        </c:forEach>
                </ul>
            </div>
            <div class="one_third content3">
                <div class="main_content_title">
                    <%--<a class="main_content_more" href="http://www.usr.cn/Case/index.html" target="_blank">更多&gt;&gt;</a>--%>
                    行业资讯
                </div>
                <ul>
                    <c:forEach var="new_7" items="${newsList_7}">
                        <li><a title="${new_7.newsName}" href="${pageContext.request.contextPath}/news/${new_7.newsId}/articles.html">${new_7.newsName}</a></li>
                     </c:forEach>
            </ul>
        </div>
    </div>
</div>
</div>
<jsp:include page="../../front/common/foot.jsp"/>
<script type="text/javascript">
/*! index - slider */$(function(){if(document.getElementById("mainslider")!=undefined){$("#mainslider").flexslider({animation:"slide",direction:"horizontal",easing:"swing"})}});
/* newlist */var c,_=Function;with(o=document.getElementById("newslist")){ innerHTML+=innerHTML; onmouseover=_("c=1"); onmouseout=_("c=0");}(F=_("if(#%18||!c)#++,#%=o.scrollHeight>>1;setTimeout(F,#%18?10:5000);".replace(/#/g,"o.scrollTop")))();
</script>
<%--<div style="display:none">--%>
    <%--<script type="text/javascript">--%>
        <%--var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");--%>
        <%--document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F32f54cc1983f78d6fae8141f7894a7d0' type='text/javascript'%3E%3C/script%3E"));--%>
    <%--</script>--%>
<%--</div>--%>
<%--<iframe name="257988" height="0" width="0" src="./js/mv.html" style="display: none;"></iframe>--%>
</body>
</html>