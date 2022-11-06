<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>    
	
	<div class="container">
	  <a href="register">게시글 작성</a>
		<table class="table">
			<tr> 
				<th> 번호 </th>
				<th> 제목 </th>
				<th> 작성자 </th>
				<th> 등록일 </th>
				<th> 수정일 </th>
			</tr>
			<c:forEach var = "b" items = "${list}">
				<tr>
					<td>${b.bno}</td>
						<td>
						<a href="get?bno=${b.bno}">${b.title}</a>
						</td>
					<td>${b.writer}</td>
					<td>
					 	<fmt:parseDate var = "regDate" value="${b.regDate}" pattern="yyyy-MM-dd'T'HH:mm" type="both"/>
					 	<fmt:formatDate value="${regDate}" pattern="yyyy년MM월dd일 HH시 mm분"/> 
					</td>
					<td>
						<fmt:parseDate var = "updateDate" value="${b.updateDate}" pattern="yyyy-MM-dd'T'HH:mm" type="both"/>
					 	<fmt:formatDate value="${updateDate}" pattern="yyyy년MM월dd일 HH시 mm분"/> 
					</td>
				</tr>	
			</c:forEach>	
		</table>
		<div class="paging">
		<c:if test="${pageMaker.prev }">
			<a href="?page=${pageMaker.startPage -1 }">[이전페이지]</a>
		</c:if>
		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
			<a href="?page=${pageNum}">[${pageNum}]</a>
		</c:forEach>
		<c:if test="${pageMaker.next }">
			<a href="?page=${pageMaker.endPage +1 }">[다음페이지]</a>
		</c:if>	
		</div> <!--paging end -->
	</div> <!-- container end -->
<%@ include file="../layout/footer.jsp"%>