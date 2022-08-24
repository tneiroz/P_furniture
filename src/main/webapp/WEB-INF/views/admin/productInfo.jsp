<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../layout/header.jsp"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
  		<h2>상품상세조회페이지</h2>
 
 ${productInfo }
<div class="jumbotron"> 
<div class="form_section">
	<div class="form_section_title">
		<label>상품 이미지</label>
	</div>
	<div class="form_section_content">
		<div id="uploadReslut">
		</div>
	</div>
</div>
</div>
<%@ include file ="../layout/footer.jsp"%>


<script>
$(document).ready(function(){
/* 이미지 정보 호출 */
let productCode = '${productInfo.productCode}'
let uploadReslut = $("#uploadReslut");			

$.getJSON("${contextPath}/getAttachList", {productCode : productCode}, function(arr){	
	//만약에 사진이 없으면 resources에 저장된 noImage파일을 화면에 보여준다
	if(arr.length === 0){
		let str = "";
		str += "<div id='result_card'>";
		str += "<img src='${contextPath}/resources/image/ProductNoImage.png'>";
		str += "</div>";
		uploadReslut.html(str);	
		return;
	}
	
	let str = "";
	let obj = arr[0];	
	
	let fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
	str += "<div id='result_card'";
	str += "data-path='" + obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "'";
	str += ">";
	str += "<img src='${contextPath}/display?fileName=" + fileCallPath +"'>";
	str += "</div>";		
	uploadReslut.html(str);						
	});	
	
	

}); // $(document).ready






</script>