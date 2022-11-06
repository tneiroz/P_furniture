<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<%@ include file ="../layout/header.jsp"%>
<link rel="stylesheet" href="${contextPath}/resources/css/join.css">

  <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">자연친화적인 가구의 시작 , Be Comfortable</h4>
        <form class="validation-form" id="joinButton" novalidate>
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="name">이름</label>
              <input type="text" class="form-control" name="memberName" id="memberName" placeholder="이름" value="" required>
              <div class="invalid-feedback">
                이름을 입력해주세요.
              </div>
            </div>
            
            <div class="col-md-6 mb-3">
              <label for="nickname">비밀번호</label>
              <input type="text" class="form-control" name="memberPw" id="memberPw" placeholder="비밀번호" value="" required>
              <div class="invalid-feedback">
                비밀번호를 입력해주세요.
              </div>
            </div>
          </div>

          <div class="mb-3">
            <label for="email">이메일</label>
            <input type="email" class="form-control" name="memberMail" id="memberMail" placeholder="abc@example.com" required>
            <div class="invalid-feedback">
              이메일을 입력해주세요.
            </div>
          </div>

          <div class="mb-3">
            <label for="address">주소</label>
            <input type="text" class="form-control" name="memberAddr" id="memberAddr" placeholder="서울특별시 강남구" required>
            <div class="invalid-feedback">
              주소를 입력해주세요.
            </div>
          </div>
          
          <hr class="mb-4">
          <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="aggrement" required>
            <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
          </div>
          <div class="mb-4"></div>
          
          <div>
          	<button class="btn btn-primary btn-lg btn-block">가입 완료</button>
          </div>
        </form> <!-- validation-form end -->
      </div>
    </div>
    <footer class="my-3 text-center text-small">
    </footer>
  </div>
  
  
 <%@ include file ="../layout/footer.jsp"%> 
  
  
  <script>
  //가입할때 공백 방지
    window.addEventListener('load', () => {
      const forms = document.getElementsByClassName('validation-form');
      Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }

          form.classList.add('was-validated');
        }, false);
      });
    }, false);
    

    $(document).ready(function(){
    	//회원가입 버튼(회원가입 기능 작동)
    	$("#joinButton button").click(function(e){
    		e.preventDefault();
    		$("#joinButton").attr("action", "${pageContext.request.contextPath}/member/join");
    		$("#joinButton").attr("method", "post");
    		$("#joinButton").submit();
    	});
    });

    </script>
</body>

</html>