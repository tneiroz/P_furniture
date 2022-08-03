<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file ="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="wrapper">
	<h2>관리자 페이지</h2>
	<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
    	<li class="nav-item">
        	<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
           		<span>✅상품에 관한 내용은 여기를 클릭 하세요.✅</span>
            </a>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar" style="">
            	<div class="bg-white py-2 collapse-inner rounded">
                	<a class="collapse-item" href="${contextPath}/admin/productAdd">상품등록</a>
                    <a class="collapse-item" href="${contextPath}/admin/productControl">상품관리</a>
               </div>
           </div>
       </li>
   </ul>
</div> <!-- wrapper end -->




<%@ include file ="../layout/footer.jsp"%>