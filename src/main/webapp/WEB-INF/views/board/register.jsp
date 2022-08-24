<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="container">
   <form action="${contextPath}/board/register" method="post">
      <div class="form-group">
         <label>제목 : </label>
         <input type="text" class="form-control" name="title"/>
      </div>
      <div class="form-group">
         <label>내용 : </label>
         <textarea rows="10" class="form-control" name="content"></textarea>
      </div>
      <div class="form-group">
         <label>작성자 : </label>
         <input type="text" class="form-control" name="writer"/>
      </div>
      <button class="btn btn-primary submit">등록</button>
   </form>   
</div>
<%@ include file="../layout/footer.jsp" %>

<script>

/* 글 등록버튼 */
$(".submit").on("click", function(e){
	alert("게시글을 작성합니다.")
});	


</script>