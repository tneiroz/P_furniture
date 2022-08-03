<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-bottom">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="${contextPath}">be comfortable</a>
                 	<ul class="navbar-nav left">
                 	  <li class="nav-item "><a class="nav-link" href="#!">About</a></li>
               		  <li class="nav-item"><a class="nav-link" href="#!">Notice</a></li>
                      <li class="nav-item"><a class="nav-link" href="${contextPath}/board/list">Q & A</a></li>
              		</ul>  
              		 
                	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
              		<div class="collapse navbar-collapse " id="navbarResponsive">
                 	<c:if test = "${member == null}">  <!-- 로그인 안했을 경우 보이는 화면 -->
                    	 <ul class="navbar-nav ml-auto">
                 	   		<li class="nav-item ">
                      	 		<a class="nav-link" href="${contextPath}/member/login">Login</a>
                       		</li>
                       		<li class="nav-item ">
                      	 		<a class="nav-link" href="${contextPath}/member/join">Join</a>
                   			</li>
                   		 </ul> 
                  	</c:if>
                 <c:if test="${ member != null }">
                     <ul class="navbar-nav ml-auto">   <!-- 로그인 했을경우 보이는 화면 -->
                     <c:if test="${member.adminCk == 1 }"> <!-- 관리자 체크를 해 서 로그인 할 경우 -->
                      	<li class="nav-item">								 			<!-- 윈도우 이모지 단축키 윈도우 키 + . -->
                     		<a class="nav-link" href="${contextPath}/admin/main">🔐 "${member.memberName}"님 🔐 </a></li>
                 	   <li class="nav-item ">
                 	    <a class="nav-link" href="${contextPath}/member/logout">Logout</a>
                       </li>
                 	   </c:if>
                 	   <c:if test="${member.adminCk != 1 }">>
                     	<li class="nav-item">								 			<!-- 윈도우 이모지 단축키 윈도우 키 + . -->
                     		<a class="nav-link" href="${contextPath}/member/mypage">🌳 안녕하세요 "${member.memberName}"님 🌳</a></li>
                 	   <li class="nav-item ">
                 	    <a class="nav-link" href="${contextPath}/member/logout">Logout</a>
                       </li>
                 	   </c:if>
                     </ul>  
                   </c:if>
              	</div>    
            </div>
        </nav>
    </body>
</html>
              
               
        
                 