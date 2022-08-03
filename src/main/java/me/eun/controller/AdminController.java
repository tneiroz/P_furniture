package me.eun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.eun.model.ProductVO;
import me.eun.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	/* 관리자 메인 페이지 이동 */
    @RequestMapping(value="main", method = RequestMethod.GET)
    public void adminMainGET() throws Exception{
    }
    
    /* 상품 등록 페이지 접속 */
    @RequestMapping(value = "productAdd", method = RequestMethod.GET)
    public String productAddGET() throws Exception{
    	return "admin/productAdd";    //상품이 등록된다면 관리페이지로 넘김
    }
    
    // get 메서드 사용시 리턴할 실제 주소 값(문자열로 반환)
  //    /WEB-INF/views/ admin/productAdd  .jsp"
    
    @RequestMapping(value = "productAdd", method = RequestMethod.POST)
    public String productAddPost(ProductVO product,RedirectAttributes rttr) throws Exception{
    	productService.productAdd(product); //상품 등록 쿼리 수행
    	rttr.addFlashAttribute("product_result",product.getProductName()); //등록 성공 메세지 (상품 이름)
    	return "redirect:/admin/productControl";    //상품이 등록된다면 관리페이지로 넘김
    }
    
    /* 상품 관리 페이지 접속 */
    @RequestMapping(value = "productControl", method = RequestMethod.GET)
    public String goodsEnrollGET() throws Exception{
    	return "admin/productControl";
    }
    
    /* 상품 관리 페이지 접속 */
    @RequestMapping(value = "productControl", method = RequestMethod.POST)
    public String goodsEnrollPOST() throws Exception{
    	return null;
    }
    
    
}
