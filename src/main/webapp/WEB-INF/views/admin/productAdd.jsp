<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../layout/header.jsp"%>
<link rel="stylesheet" href="${contextPath}/resources/css/productAdd.css">

<div class="container">
	<form id="productForm" >
	<div class="inputArea">
		 <label for="productName">상품명</label>
 		<input type="text" id="productName" name="productName" />
 		 <span id="warn_productName">상품 이름을 입력 해주세요.</span>
	</div>

	<div class="inputArea">
		 <label for="productPrice">상품가격</label>
		 <input type="text" id="productPrice" name="productPrice" />
		  <span id="warn_productPrice">상품 가격을 입력 해주세요.</span>
	</div>

	<div class="inputArea">
 		<label for="productInstock">상품재고수량</label>
 		<input type="text" id="productInstock" name="productInstock" />
 		<span id="warn_productInstock">상품 재고를 입력 해주세요.</span>
	</div>

	<div class="btn_section">
		<button id="addBtn" class="btn add_btn">등 록</button>
		<button id="canBtn" class="btn">취 소</button>
	</div> 
	</form>
</div> <!-- container end -->

<%@ include file ="../layout/footer.jsp"%>

<script>

let productForm = $("#productForm");

/*등록버튼*/
$("#addBtn").click(function(e){ 
 	e.preventDefault();
	productForm.attr('action', '${contextPath}/admin/productAdd')
	productForm.attr('method', 'post')

	/*검사 통과 유무 변수 */
	let nameCheck = false;  //상품 이름
	let priceCheck = false; //상품 가격
	let instockCheck = false;//상품 재고

	/*입력값 변수*/
	let productName = $('input[name=productName]').val();  
	let productPrice = $('input[name=productPrice]').val();  
	let productInstock = $('input[name=productInstock]').val();  
	
	/*공란 경고 span 태그*/
	let wProductName =$('#warn_productName');
	let wProductPrice =$('#warn_productPrice');
	let wProductInstock =$('#warn_productInstock');
	
	/*상품 이름 공란 체크*/
	if(productName ===''){
		wProductName.css('display', 'block');
        nameCheck = false;
    } else{
    	wProductName.css('display', 'none');
        nameCheck = true;
    }
	/*상품 가격 공란 체크*/
	if(priceCheck ===''){
		wProductPrice.css('display', 'block');
		priceCheck = false;
    } else{
    	wProductPrice.css('display', 'none');
    	priceCheck = true;
    }
	/*상품 재고 공란 체크*/
	if(instockCheck ===''){
		wProductInstock.css('display', 'block');
		instockCheck = false;
    } else{
    	wProductInstock.css('display', 'none');
    	instockCheck = true;
    }
	 /* 최종 검사 */
    if(nameCheck && priceCheck && instockCheck){
    	$("#productForm").submit();   
   
    	
    } else{
        return;
    }
	
	
});

/* 취소 버튼 */
$("#canBtn").click(function(e){
	e.preventDefault();
	productForm.attr('action', '${contextPath}/admin/main')
	productForm.attr('method', 'get')
	productForm.submit();
});

 

 
</script>