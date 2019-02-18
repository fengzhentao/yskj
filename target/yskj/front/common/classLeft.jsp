<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                                <c:choose>
                                    <c:when test="${ptt.openTwoType == 1}">
                                        <li class="navContentSelectli">
                                            <a href="${pageContext.request.contextPath}/gcc/${ptt.twoTypeId}/twoGoodsClass.html">
                                                <span class="navContentSelectspan">${ptt.twoTypeName}</span>
                                            </a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li>
                                            <a href="${pageContext.request.contextPath}/gcc/${ptt.twoTypeId}/twoGoodsClass.html">
                                                <span>${ptt.twoTypeName}</span>
                                            </a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
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
</div>
