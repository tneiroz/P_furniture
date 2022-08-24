<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${contextPath}/resources/css/login.css">

<!-- Section: Design Block -->
<section class="text-center">
<!-- Background image -->
<div class="p-5 bg-image" style="
   background-image: url('https://mdbootstrap.com/img/new/textures/full/171.jpg');
   height: 300px;">
</div>
<!-- Background image  -->
<div class="card mx-4 mx-md-5 shadow-5-strong"
	 style="margin-top: -100px;
            background: hsla(0, 0%, 100%, 0.8);
            backdrop-filter: blur(30px);">
            
 <!-- sign up now 위에 공백차지 -->           
    <div class="card-body py-5 px-md-5">   
      <div class="row d-flex justify-content-center">
        <div class="col-lg-8">
          <h2 class="fw-bold mb-5">Sign up now</h2>
            <!-- Mail input -->
	            <form id="login_form" action="${contextPath}/member/login" method="post">
		            <div class="form-outline mb-4">
		              <input type="text" id="memberMail" class="form-control" name="memberMail" />
		              <label class="form-label" for="memberMail">Email address</label>
		            </div>
		            <!-- Password input -->
		            <div class="form-outline mb-4">
		              <input type="password" id="memberPw" class="form-control" name="memberPw" />
		              <label class="form-label" for="memberPw">Password</label>
		            </div>
		 			<c:if test = "${result == 0 }">
               			<div class = "login_warn">사용자 이메일 또는 비밀번호를 잘못 입력하셨습니다.</div>
            		</c:if>
		            <!-- Submit button -->
		            <div>
			            <button class="btn btn-primary btn-block mb-4">
			              Sign up
			            </button>
		            </div>
	            </form>
            </div>
        </div>
      </div>
    </div>
</section>
<%@ include file ="../layout/footer.jsp"%>
<script>
 
/*      로그인 버튼 클릭 메서드 
    $("#login_form button").click(function(e){
    	
    	e.preventDefault();

    로그인 메서드 서버 요청 
	$("#login_form").append($('#memberMail'));
	$("#login_form").append($('#memberPw'));
    $("#login_form").attr("action","${pageContext.request.contextPath}/member/login");
    $("#login_form").attr("method", "post");
    $("#login_form").submit();   
        
    }); 
    
    스크립트언어로 선언 하지않고 ,
    <form id="login_form" action="${contextPath}/member/login" method="post">
    이렇게 form 자체에 action 과 method방식을 'post'로 주면 된다.
    
    */
    
</script>
