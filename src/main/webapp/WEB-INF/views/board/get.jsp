<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
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
				<div class="Col-sm-1">${board.bno}</div>
				<div class="Col-sm-11">${board.title}</div>
			</div> <!-- row end -->
		</div> <!-- card-header end -->
		
		<div class="card-body">
			${board.content}
		</div> <!-- card-body end -->
		<div class="card-footer d-flex justify-content-between">
			<div>
				<button type="button" class="btn btn-outline-warning modify">수정</button>
				<button type="button" class="btn btn-outline-danger remove">삭제</button>
				<button type="button" class="btn btn-outline-success list">목록</button>
			</div>
			<div>
			등록일 : <fmt:parseDate var = "regDate" value="${board.regDate}" pattern="yyyy-mm-dd'T'HH:mm:ss" type="both"/>
					<fmt:formatDate value="${regDate}" pattern="yyyy년MM월dd일"/> 
			수정일 : <fmt:parseDate var = "updateDate" value="${board.updateDate}" pattern="yyyy-mm-dd'T'HH:mm:ss"/>
					<fmt:formatDate value="${updateDate}" pattern="yyyy년MM월dd일"/> 
			</div> <!-- 등록일 & 수정일 오른쪽으로 보내기 위해선 div로 감싸야 된다. -->
		</div>
	</div> <!-- card end -->
	</form>
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
	})


</script>


<%@ include file="../layout/footer.jsp"%>

