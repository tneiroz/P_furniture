<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<h2>상품 페이지</h2>



<div class="container px-4 px-lg-5 mt-5">
	<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
		<c:forEach items="${list}" var="list">
			<div class="col mb-5">
				<div class="card h-100">
					<!-- Product image-->
					 <form id="image_form">
						<div class="image_wrap" data-productCode="${list.imageList[0].productCode}" data-path="${list.imageList[0].uploadPath}" data-uuid="${list.imageList[0].uuid}" data-filename="${list.imageList[0].fileName}">
							<img class="card-img" src="" alt="...">
						</div>	
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
$(document). ready(function(){
	/* 이미지 삽입 */
	let image_form = $('#image_form');
	$("#image_form .image_wrap").each(function(i, obj){
		const bobj = $(obj);
		if(bobj.data("productCode")){
		const uploadPath = bobj.data("path");
		const uuid = bobj.data("uuid");
		const fileName = bobj.data("filename");
		
		const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + fileName);
		
		$(this).find("img").attr('src', '/display?fileName=' + fileCallPath);
		
		} else {
			$(this).find("img").attr('src', contextPath+'/resources/image/ProductNoImage.png');
		}
		
	});
});

</script>
