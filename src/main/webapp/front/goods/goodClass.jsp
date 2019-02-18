<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="baidu-site-verification" content="VqulEKHGq0">
  <title>产品中心</title>
  <meta name="copyright" content="">
  <link href="${pageContext.request.contextPath}/static/css/style.mini.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" async="" src="${pageContext.request.contextPath}/static/js/9eb94fd4eae2a1d6.js"></script>
  <script charset="utf-8" src="${pageContext.request.contextPath}/static/js/v.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.9.1.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/usrjquery.mini.js"></script>
  <link href="${pageContext.request.contextPath}/static/images/logo/bitbug_favicon.ico" rel="shortcut icon">
  <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
</head>
<body>
<jsp:include page="../../front/common/head.jsp"/>
<div style="width: 100%;height: 150px">
  <img src="${pageContext.request.contextPath}/${dahangtu.logoUrl}" alt="" style="width: 100%;height: 100%"/>
</div>
<!-- START small_banner -->
<!--<section class="small_banner" style="background-color: #ebebeb;">
  <div class="center-wrap">
    <h2 class="page-banner-heading" style="color: blue;">产品中心</h2>
    <p class="page-banner-description" style="color: blue;">${slogan.sloganName}<br>${slogan.sloganContext}</p>
    <div class="breadcrumbs" style="color: blue;"> <a href="${pageContext.request.contextPath}/index.html" style="color: blue;">首页</a> → 产品中心 </div>
  </div>
</section>-->
<!--单页-->
<section id="content-container" class="clearfix">
  <div id="main-wrap" class="clearfix">
    <jsp:include page="../../front/common/classLeft.jsp"/>
    <!--START 产品内容-->
    <div class="page_content_right sub-content">
      <div id="iso-wrap" class="clearfix iso-space product_space">
        <c:forEach var="product" items="${productVoses}">
          <div data-id="id-1" class="product_fourth">
            <a href="${pageContext.request.contextPath}/gdc/${product.productId}/goodsDetail.html" target="_blank" style="">
              <img src="${pageContext.request.contextPath}/${product.url}" title="${product.productName}" alt="${product.productName}">
              <p>${product.productModel}<br/>${product.productName}</p>
            </a>
          </div>
        </c:forEach>
      </div>
    </div>
    <!--END 这里是产品内容-->
    <!-- END of page_content-->
  </div>
  <!-- END main-wrap -->
</section>
<!--底部-->
<jsp:include page="../../front/common/foot.jsp"/>
<%--<div style="display:none">--%>
  <%--<script type="text/javascript">--%>
    <%--var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");--%>
    <%--document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F32f54cc1983f78d6fae8141f7894a7d0' type='text/javascript'%3E%3C/script%3E"));--%>
  <%--</script><script src="./js/h.js" type="text/javascript"></script>--%>
  <%--<script type="text/javascript" src="./js/57071.js"></script>--%>
<%--</div>--%>
<%--<iframe name="257988" height="0" width="0" src="./js/mv.html" style="display: none;"></iframe>--%>
</body>
</html>
