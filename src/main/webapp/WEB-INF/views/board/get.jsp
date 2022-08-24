<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="pricipal.memberName" var="memberName"/>
</sec:authorize>	
<input type="hidden" name = "title" value= "${board.title}">
<div class="container">

		 <input type="hidden" name="bno" value="${board.bno}" id="bno">
		 <input type="hidden" name="title" value="${board.title}">
		 <input type="hidden" name="writer" value="${board.writer}">
		 <input type="hidden" name="content" value="${board.content}">
	
	
<form id = "getForm">	
	<div class="card">
		<div class="card-header">
			<div class="row">
				<div class="col-sm-4">게시글 번호: ${board.bno}</div>
				<div class="col-sm-6">게시글 제목: ${board.title}</div>
				<div class="col-sm-2 d-flex justify-content-end">작성자: ${board.writer}</div>
			</div> <!-- row end -->
		</div> <!-- card-header end -->
		
		<div class="card-body">
			${board.content}
		</div> <!-- card-body end -->
		<div class="card-footer d-flex justify-content-between">
			<div>
			<sec:authorize access="#board.writer == #memberName or  #member.adminCk == '1'"><!-- 권한  or로  -->
				<button type="button" class="btn btn-outline-warning modify">수정</button>
				<button type="button" class="btn btn-outline-danger remove">삭제</button>
			</sec:authorize>	
				<button type="button" class="btn btn-outline-success list">목록</button>
			</div>
			<div>
			
			등록일 : <fmt:parseDate var = "regDate" value="${board.regDate}" pattern="yyyy-mm-dd'T'HH:mm" type="both"/>
					<fmt:formatDate value="${regDate}" pattern="yyyy년MM월dd일"/> 
			수정일 : <fmt:parseDate var = "updateDate" value="${board.updateDate}" pattern="yyyy-mm-dd'T'HH:mm"/>
					<fmt:formatDate value="${updateDate}" pattern="yyyy년MM월dd일"/> 
			</div> <!-- 등록일 & 수정일 오른쪽으로 보내기 위해선 div로 감싸야 된다. -->
		</div>
	</div> <!-- card end -->
</form>


	<div class="reply_container">
		<form id="reply">
			<c:if test="${member != null}"> <!-- 댓글은 로그인 했을 경우만 작성 가능 하기 때문에 c:if 넣어주기  -->
				<div class="reply_button_wrap">
					<button type="button" class="btn btn-primary reply">댓글작성</button>
				</div>	
			</c:if>
		</form>
	</div> <!-- reply_container end -->
	
	
	
</div> <!-- container end -->
<script>

	$(function(){
		let getForm = $('#getForm');
		$('#getForm .list').on('click', function(e){   //목록
			e.preventDefault();
			getForm.attr('action','list');
			getForm.attr('method','get');
			getForm.submit();
			
		})
		
		$('#getForm .modify').on('click', function(e){   //수정
			e.preventDefault();
			getForm.append($("#bno"));
			getForm.attr('action','modify');
			getForm.attr('method','get');
			getForm.submit();
			
		})
		
		$('#getForm .remove').on('click', function(e){   //삭제
			e.preventDefault();
			getForm.append($("#bno"));
			getForm.attr('action','remove');
			getForm.attr('method','post');
			getForm.submit();
			
		})
		
	
 	/*댓글 작성*/			
		$(function(){
			let reply = $('#reply');
			$('#reply .reply').on("click", function(e){ 
			e.preventDefault();		
			const bno = '${board.bno}';
			const memberName = '${member.memberName}';
	   
			let popUrl = contextPath +"/board/insertReply/" + bno + "?memberName=" + memberName;
			console.log(popUrl);
			let popOption = "width = 490px, height=490px, top=490px, left=490px, scrollbars=yes";
			
			window.open(popUrl,"댓글 쓰기",popOption);
		
		});
	})

})


</script>



<%@ include file="../layout/footer.jsp"%>

