<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="${pageContext.request.contextPath}/static/css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common.js"></script>
<%--<style>--%>
    <%--header {--%>
        <%--width:100%;--%>
        <%--position:relative;--%>
        <%--z-index:100;--%>
        <%--margin:0 auto;--%>
        <%--padding-top:15px;--%>
        <%--border-bottom:solid 5px #dcdcdc--%>
    <%--}--%>
    <%--header a {--%>
        <%--blr:expression(this.onFocus=this.blur());--%>
        <%--outline:0--%>
    <%--}--%>
    <%--header a:focus {--%>
        <%---moz-outline-style:none--%>
    <%--}--%>
    <%--header a:link, header a:visited, header a:hover, header a:active {--%>
        <%--color:#000;--%>
        <%--text-decoration:none;--%>
        <%--border:0--%>
    <%--}--%>
    <%--header ul, header ol {--%>
        <%--list-style-image:none--%>
    <%--}--%>
    <%--header .top {--%>
        <%--width:1200px;--%>
        <%--margin:0 auto--%>
    <%--}--%>
    <%--header .topnav {--%>
        <%--height:56px;--%>
        <%--line-height:56px--%>
    <%--}--%>
    <%--header .topnav .logo {--%>
        <%--float:left;--%>
        <%--margin:-7px 0 0 15px;--%>
        <%--padding:0 170px 60px 0;--%>
        <%--background:url(../../static/images/logo/log.png) no-repeat--%>
    <%--}--%>
    <%--header .btn-navbar {--%>
        <%--display:none;--%>
        <%--padding:10px 15px;--%>
        <%--background:#0054a4;--%>
        <%--float:right;--%>
        <%--cursor:pointer--%>
    <%--}--%>
    <%--header .btn-navbar:active {--%>
        <%--background:#f60--%>
    <%--}--%>
    <%--header .btn-navbar .icon-bar {--%>
        <%--display:block;--%>
        <%--width:18px;--%>
        <%--height:2px;--%>
        <%--background-color:#fff;--%>
        <%--box-shadow:0 1px 0 rgba(0, 0, 0, 0.25)--%>
    <%--}--%>
    <%--header .btn-navbar span+span {--%>
        <%--margin-top:3px--%>
    <%--}--%>
    <%--header .nav {--%>
        <%--float:right;--%>
        <%--display:block--%>
    <%--}--%>
    <%--header ul#nav {--%>
        <%--float:left--%>
    <%--}--%>
    <%--header ul#nav li {--%>
        <%--float:left;--%>
        <%--position:relative;--%>
        <%--font-size:15px;--%>
        <%--width:120px;--%>
        <%--height:44px;--%>
        <%--line-height:44px;--%>
        <%--text-align:center--%>
    <%--}--%>
    <%--header ul#nav li.nav_space {--%>
        <%--height:18px;--%>
        <%--width:1px;--%>
        <%--border-left:#888584 1px solid;--%>
        <%--margin-top:13px;--%>
        <%--display:block--%>
    <%--}--%>
    <%--header ul#nav li a {--%>
        <%--display:block;--%>
        <%--cursor:pointer;--%>
        <%--height:56px;--%>
    <%--}--%>
    <%--header ul#nav li a:hover {--%>
        <%--color:#0054a4--%>
    <%--}--%>
    <%--header ul#nav li .topselecta {--%>
        <%--color:#0054a4;--%>
        <%--border-bottom:5px solid #0054a4--%>
    <%--}--%>
    <%--header ul li, ol li {--%>
        <%--margin-bottom:0;--%>
    <%--}--%>
    <%--header ul#nav li .sub {--%>
        <%--float:left;--%>
        <%--position:absolute;--%>
        <%--top:61px;--%>
        <%--z-index:9999;--%>
        <%--display:none;--%>
        <%--border:#dcdcdc solid 1px;--%>
        <%--background-color:#fff;--%>
        <%--border-top:0;--%>
        <%--font-size:14px;--%>
        <%--text-align:left;--%>
        <%--padding:15px 0;--%>
    <%--}--%>
    <%--header ul#nav li .sub a {--%>
        <%--height:34px;--%>
        <%--line-height:34px;--%>
    <%--}--%>
    <%--header ul#nav li .sub1 {--%>
        <%--width:114px;--%>
        <%--float:left--%>
    <%--}--%>
    <%--header ul#nav li .sub1 a {--%>
        <%--display:block;--%>
        <%--cursor:pointer;--%>
        <%--text-indent:20px;--%>
    <%--}--%>
    <%--header ul#nav li .sub1 a:hover {--%>
        <%--/*background:#0054a4;*/--%>
        <%--background:	#2894FF;--%>
        <%--color:#fff;--%>
    <%--}--%>
    <%--header ul#nav li .sub2 {--%>
        <%--width:160px;--%>
        <%--float:left--%>
    <%--}--%>
    <%--header ul#nav li .sub3 {--%>
        <%--width:160px;--%>
        <%--float:left--%>
    <%--}--%>
    <%--header ul#nav li .sub .subcontenta {--%>
        <%--font-size:12px;--%>
        <%--height:30px;--%>
        <%--line-height:30px;--%>
        <%--font-weight:normal--%>
    <%--}--%>
    <%--header ul#nav li.news .sub {--%>
        <%--left:-25px;--%>
        <%--width:114px;--%>
        <%--height:200px--%>
    <%--}--%>
    <%--header ul#nav li.product .sub1 {--%>
        <%--width:170px--%>
    <%--}--%>
    <%--header ul#nav li.product .sub {--%>
        <%--left:-27px;--%>
        <%--width:170px;--%>
    <%--}--%>
    <%--header ul#nav li.support .sub1 {--%>
        <%--width:170px--%>
    <%--}--%>
    <%--header ul#nav li.support .sub {--%>
        <%--left:-27px;--%>
        <%--width:170px;--%>
    <%--}--%>
    <%--header ul#nav li.support .sub .subcontenta {--%>
        <%--height:25px--%>
    <%--}--%>
    <%--header ul#nav li.about .sub {--%>
        <%--left:-28px;--%>
        <%--width:114px;--%>
        <%--height:290px--%>
    <%--}--%>
    <%--header .nav_search {--%>
        <%--float:right;--%>
        <%--margin-top:8px--%>
    <%--}--%>
    <%--header .nav_search input#submit {--%>
        <%--height:28px;--%>
        <%--width:31px;--%>
        <%--background:url(../images/cssImage/index.png) no-repeat;--%>
        <%--background-position:-60px -136px;--%>
        <%--float:right;--%>
        <%--cursor:pointer;--%>
        <%--border:0--%>
    <%--}--%>
    <%--header .nav_search input#keyword {--%>
        <%--height:16px;--%>
        <%--border:1px solid #bbb;--%>
        <%--border-radius:2px;--%>
        <%--float:right--%>
    <%--}--%>
<%--</style>--%>
<%--<header>--%>
    <%--<div class="top">--%>
        <%--<div class="topnav">--%>
            <%--<a title="logo" href="${pageContext.request.contextPath}/index.html" class="logo">--%>
                <%--<h1 class="hidden"></h1>--%>
            <%--</a>--%>
            <%--<div class="btn-navbar"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </div>--%>
            <%--<div class="nav">--%>
                <%--<ul id="nav">--%>
                    <%--<li class="main">--%>
                        <%--<a title="" class="topmaina" href="${pageContext.request.contextPath}/index.html"><strong>首 页</strong></a>--%>
                    <%--</li>--%>
                    <%--&lt;%&ndash;<li class="nav_space"></li>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<li class="news">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<a title="最新动态" class="topmaina " href="http://www.usr.cn/News/index.html"><strong>最新动态</strong></a>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                    <%--<li class="nav_space"></li>--%>
                    <%--<li class="product">--%>
                        <%--<a title="产品中心" class="topmaina " href="${pageContext.request.contextPath}/gcc/goodsClass.html"><strong>产品中心</strong></a>--%>
                        <%--<div class="sub" style="background-color:rgba(0,0,0,0.7);">--%>
                            <%--<ul class="sub1" >--%>
                                <%--<c:forEach var="pot" items="${productOneTypes}">--%>
                                      <%--<a title="${pot.oneTypeName}" href="${pageContext.request.contextPath}/gcc/${pot.oneTypeId}/oneGoodsClass.html">${pot.oneTypeName}</a>--%>
                                <%--</c:forEach>--%>
                            <%--</ul>--%>
                        <%--</div>--%>
                    <%--</li>--%>
                    <%--<li class="nav_space"></li>--%>
                    <%--<li class="support">--%>
                        <%--<a title="合作伙伴" class="topmaina " href="${pageContext.request.contextPath}/join/cooperation.html"> <strong>合作伙伴</strong> </a>--%>
                    <%--</li>--%>
                    <%--<li class="nav_space"></li>--%>
                    <%--<li class="support">--%>
                        <%--<a title="行业动态" class="topmaina " href="${pageContext.request.contextPath}/news/4/index.html"> <strong>行业动向</strong> </a>--%>
                    <%--</li>--%>
                    <%--<li class="nav_space"></li>--%>
                    <%--<li class="about">--%>
                        <%--<a title="关于/联系我们" class="topmaina " href="${pageContext.request.contextPath}/ab/2/about.html"><strong>关于/联系我们</strong></a>--%>
                    <%--</li>--%>
                    <%--&lt;%&ndash;<li class="nav_space"></li>&ndash;%&gt;--%>
                  <%--&lt;%&ndash;  <li class="about">--%>
                        <%--<a title="中文" class="topmaina " href="${pageContext.request.contextPath}/ab/2/about.html">中文</a>--%>
                    <%--</li>--%>
                    <%--<i class="icon" style="width: 23px;height:23px;background-image: url(../../static/images/cssImage/icon.PNG);" >--%>
                    <%--&ndash;%&gt;--%>
                    <%--<li class="about" style="text-align: center;color: #0000cc;font-weight: 700;font-size:15px;text-align: center;cursor:pointer;">--%>
                         <%--中&nbsp;&nbsp;文<img src="../../static/images/cssImage/xia.png"/>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</header>--%>
<div class="header" style="width: 100%;">
    <div class="w1100">
    <div class="logo"><a href="${pageContext.request.contextPath}/index.html"><img src="../../static/images/logo/log.png"></a></div>
    <div class="menu f16">
        <ul>
            <li class="first"><a href="${pageContext.request.contextPath}/index.html" class="cur">首页</a></li>

            <%--<li class="nav1"><a href="http://www.plantower.com/about/?19.html">关于我们</a>--%>

            <%--</li>--%>

            <li class="nav2"><a href="${pageContext.request.contextPath}/gcc/goodsClass.html">产品中心</a>

                <ul style="display: none;">
                <c:forEach var="leftClassVo" items="${leftClassVos}">
                    <li class="snav"><a href="${pageContext.request.contextPath}/gcc/${leftClassVo.oneTypeId}/oneGoodsClass.html" class="">${leftClassVo.oneTypeName}</a>
                        <ul style="display: none;">
                            <c:forEach var="ptt" items="${leftClassVo.productTwoTypes}">
                                <li><a href="${pageContext.request.contextPath}/gcc/${ptt.twoTypeId}/twoGoodsClass.html">${ptt.twoTypeName}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </c:forEach>
                </ul>

            </li>

            <li class="nav3"><a href="${pageContext.request.contextPath}/join/cooperation.html">合作伙伴</a>

            </li>

            <li class="nav4"><a href="${pageContext.request.contextPath}/news/4/index.html">行业动向</a>

            </li>

            <li class="nav5"><a href="${pageContext.request.contextPath}/ab/2/about.html">关于/联系我们</a>

            </li>

        </ul>
    </div>
    <div class="btn"><a href="#" style="text-align: center;color: #0000cc;font-weight: 700;font-size:15px;text-align: center;cursor:pointer;">中&nbsp;&nbsp;文<img src="../../static/images/cssImage/xia.png"/></a></div>
    </div>
</div>

