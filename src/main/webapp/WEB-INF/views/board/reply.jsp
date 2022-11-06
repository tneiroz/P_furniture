<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %> 
<form id = "contentForm">
<div class="container">  
	<div class="content_div"> <!-- 글 제목 % 댓글 form -->
		<p class="bg-warning text-white"> 글 번호 : ${bno}</p>
     	<input type="text" class="content" placeholder="댓글을 입력하세요." >
	</div>
  	<div class="member_form">
  		<p> 작성자 : ${memberName} </p>
  	</div>
 	<div class="btn_wrap">
			<a class="cancel_btn">취소</a> <br>
			<a class="submit_btn">등록</a>
		</div>
</div> <!-- container end -->
</form>


<script>

	/* 취소 버튼 */
	$(".cancel_btn").on("click", function(e){
		alert("댓글작성을 취소합니다.")
		window.close();
	});	
	
	/* 등록 버튼 */
	$(".submit_btn").on("click", function(e){
		alert("댓글을 등록하였습니다.")
		const bno = '${board.bno}';
		const memberName = '${member.memberName}';
		const content = $(".content").val();

		const data = {
				bno : bno,
				memberName : memberName,
				content : content
		}		
		$.ajax({
			data : data,
			type : 'POST',
			url : contextPath +'/reply/new',
			success : function(result){
				window.close();
				
			}
			
		});		
		
	});
	
	</script>