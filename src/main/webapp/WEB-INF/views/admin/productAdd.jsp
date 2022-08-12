<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../layout/header.jsp"%>
<link rel="stylesheet" href="${contextPath}/resources/css/productAdd.css">
<c:set var = "contextPath" value="${pageContext.request.contextPath}"/>
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
	
	<div class="inputArea">
   		<label for="productImage">상품사진</label>                			
		<div class="file_form">
			<input type="file" id ="productImage" name='productImage' style="height: 30px;">		
		</div>
		<div id="uploadResult">
			<div id="result_card">
			</div>
		</div>	
	</div> <!-- inputArea end -->
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
	//<input> 태그에 쉽게 접근하기 위해 변수를 선언 및 초기화
	let productName = $("input[name='productName']").val();  
	let productPrice = $("input[name='productPrice']").val();  
	let productInstock = $("input[name='productInstock']").val();  
	
	/*공란 경고 span 태그*/
	let wProductName =$('#warn_productName');
	let wProductPrice =$('#warn_productPrice');
	let wProductInstock =$('#warn_productInstock');
	
	/*상품 이름 공란 체크*/
	if(productName){
		$("#warn_productName").css('display','none');
		nameCheck = true;
	} else {
		$("#warn_productName").css('display','block');
		nameCheck = false;
	}
	/*상품 가격 공란 체크*/
	if(productPrice){
		$("#warn_productPrice").css('display','none');
		priceCheck = true;
    } else {
    	$("#warn_productPrice").css('display','block');
    	productPrice = false;
    }
	/*상품 재고 공란 체크*/
	if(productInstock){
		$("#warn_productInstock").css('display','none');
		instockCheck = true;
    } else {
    	$("#warn_productInstock").css('display','block');
    	productInstock = false;
    }
	 /* 최종 검사 */
    if(nameCheck && priceCheck && instockCheck){
    	$("#productForm").submit();   
    } else {
        return false;
    }
});

/* 취소 버튼 */
$("#canBtn").click(function(e){
	e.preventDefault();
	productForm.attr('action', '${contextPath}/admin/main')
	productForm.attr('method', 'get')
	productForm.submit();
});

/* 이미지 업로드 */
$("input[type='file']").on("change", function(e){
	let formData = new FormData();
	let fileInput = $('input[name="productImage"]');
	let fileList = fileInput[0].files;
	let fileObj = fileList[0];
	/*
	if(!fileCheck(fileObj.name, fileObj.size)){
		return false;
	}
		*/
	formData.append("uploadFile", fileObj);
	
	$.ajax({
		url: contextPath+'/admin/uploadAjaxAction',
    	processData : false,
    	contentType : false,
    	data : formData,
    	type : 'POST',
    	dataType : 'json',
    	success : function(result){
    		showUploadImage(result);
    	},
    	error : function(result){
    		alert("이미지 파일이 아닙니다.");
    		
    	}
    	
	});
});	

/*파일 업로드 제한*/
let regex = new RegExp("(.*?)\.(jpg|png)$");
let maxSize = 1048576; //1MB	

function fileCheck(fileName, fileSize){
	if(fileSize >= maxSize){
		alert("파일 사이즈 초과");
		return false;
	}
		  
	if(!regex.test(fileName)){
		alert("해당 종류의 파일은 업로드할 수 없습니다.");
		return false;
	}
	
	return true;		
	
}
/* 이미지 출력 */
function showUploadImage(uploadResultArr){
	
	/* 전달받은 데이터 검증 */
	if(!uploadResultArr || uploadResultArr.length == 0){return}
	let uploadResult = $("#uploadResult");
	let obj = uploadResultArr[0];
	let str = "";
	let fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
	str += "<div id='uploadDiv'>";
	str += "<image src='${contextPath}/display?fileName=" + fileCallPath +"'>";
	str += "<div class='imgDeleteBtn' data-file='" + fileCallPath + "'>x</div>";
	str += "</div>";		
	str += "<input type='hidden' name='imageList[0].fileName' value='"+ obj.fileName +"'>";
	str += "<input type='hidden' name='imageList[0].uuid' value='"+ obj.uuid +"'>";
	str += "<input type='hidden' name='imageList[0].uploadPath' value='"+ obj.uploadPath +"'>";		
	uploadResult.append(str);     
    
}
/* 이미지 삭제 버튼 동작 */
$("#uploadResult").on("click", ".imgDeleteBtn", function(e){
	deleteFile();
	
});
/* 파일 삭제 메서드 */
function deleteFile(){
	let targetFile = $(".imgDeleteBtn").data("file");
	let targetDiv = $("#uploadDiv");
	$.ajax({
		url: contextPath+'/admin/deleteFile',
		data : {fileName : targetFile},
		dataType : 'text',
		type : 'POST',
		success : function(result){
			alert(result);
			targetDiv.remove();
			
		},
		error : function(result){
			console.log(result);
			alert("파일을 삭제하지 못하였습니다.")
		}
	});
}

</script>