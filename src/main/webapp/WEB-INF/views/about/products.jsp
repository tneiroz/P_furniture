<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container px-4 px-lg-5 mt-5">
	<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
		<c:forEach items="${list}" var="list">
			<div class="col mb-5">
				<div class="card h-100">
					<!-- Product image-->
					 <form id="image_form">
					 	<c:if test="${not empty list.imageList}">
						<div class="image_wrap" data-productCode="${list.productCode}" data-path="${list.imageList[0].uploadPath}" data-uuid="${list.imageList[0].uuid}" data-filename="${list.imageList[0].fileName}">
							<img class="card-img" src="" alt="...">
						</div>	
						</c:if>
						<c:if test="${empty list.imageList}">
						<div>
							<img class="card-img" src="${contextPath}/resources/image/ProductNoImage.png" alt="이미지없음">
						</div>
						</c:if>
					 </form>		
					<!-- Product details-->
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">${list.productName}</h5>
							<!-- Product price-->
						가격 : <fmt:formatNumber value="${list.productPrice}" pattern="#,### 원" /> <br>
						재고 : ${list.productInstock} 개
						</div>
					</div>
					<!-- Product actions-->
					<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
						<div class="text-center">
							<a class="btn btn-outline-dark mt-auto" href="${contextPath}/about/productDetail?productCode=${list.productCode}">View</a>
							<a class="btn btn-outline-dark mt-auto" href="${contextPath}/cart/add?productCode=${list.productCode}">Add to Cart</a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<%@ include file="../layout/footer.jsp"%>

<script>
$(document).ready(function(){
	/* 이미지 삽입 */
	let image_form = $('#image_form');
	console.log(contextPath);
	$("#image_form .image_wrap").each(function(i, obj){
		const bobj = $(obj);
	
		let productCode = bobj.data("productcode");
		
		let uploadPath = bobj.data("path");
		let uuid = bobj.data("uuid");
		let fileName = bobj.data("filename");
		let fileCallPath = encodeURIComponent(uploadPath +"/" + uuid + "_"+ fileName);
		console.log(fileCallPath);
		$(this).find("img").attr('src', contextPath+'/display?fileName=' + fileCallPath);
	});
});

</script>
