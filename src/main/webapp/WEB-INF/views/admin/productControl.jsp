<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
  <h2>상품 목록 조회</h2>
   <form id ="pageForm">
   	  <input type="hidden" name="productCode" value="">
	  <table class="table">
	    <thead class="thead-dark">
	      <tr>
	        <th>상품코드</th>
	        <th>상품이름</th>
	        <th>상품가격</th>
	        <th>재고수</th>
	      </tr>
	    </thead>
	   <tbody>
	   <c:forEach items="${list}" var="p">
	     <tr class="table-secondary">
	  		<td>
	  			<a class="move" href='<c:out value="${p.productCode}"/>'>
	  			<c:out value="${p.productCode}"></c:out>
	  			</a>
  			</td>
	  		<td>
			    <c:out value="${p.productName}"></c:out>
	  		</td>	
	  		<td>
  				<c:out value="${p.productPrice}"></c:out>
  			</td>
  			<td>
  				<c:out value="${p.productInstock}"></c:out>
  			</td>
	    	</c:forEach>
	    </tbody>
	  </table>
	</form>	
</div> <!-- container end -->
<%@ include file ="../layout/footer.jsp"%>

<script>

/* 상품 조회 페이지 */
$(".move").on("click", function(e){
	e.preventDefault();
	let pageForm = $('#pageForm');
	pageForm.find('input[name="productCode"]').val($(this).attr("href"));
	//pageForm.append("<input type='hidden' name='productCode' value='"+$(this).attr("href") + "'>");	
	pageForm.attr("action",  "${contextPath}/admin/productInfo");
	pageForm.submit();
});


</script>