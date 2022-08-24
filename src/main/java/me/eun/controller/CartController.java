package me.eun.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.eun.model.CartDTO;
import me.eun.model.MemberVO;
import me.eun.model.ProductVO;
import me.eun.service.CartService;
import me.eun.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/add")
	@ResponseBody
	public String addCartPOST(CartDTO cart, HttpServletRequest request) {
		// 로그인 체크
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		if(mvo == null) {
			return "5";
		}
		
		// 카트 등록
		int result = cartService.addCart(cart);
		return result + "";
	}
	
	@GetMapping("/add")
	public String cartPage( HttpServletRequest request, int productCode, Model model) {
		ProductVO productInfo = productService.productInfo(productCode);
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		
		CartDTO cart = cartService.getCart(mvo.getMemberName());
		System.out.println(cart);
		
		model.addAttribute("cart", cart);
		model.addAttribute("info", productInfo);
		return "cart/add";
	}

	 
	
	@PostMapping("/cart/{memberName}")
	public String cartPageGet(@PathVariable("memberName") String memberName, Model model) {
		model.addAttribute("cartInfo", cartService.getCartList(memberName));
		return "cart/add";
		}
}
