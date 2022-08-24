package me.eun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.eun.model.Criteria;
import me.eun.model.ProductVO;
import me.eun.service.ProductService;
@Controller
@RequestMapping("/about")
public class ProductsController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/products")
	public String products(Criteria criteria, Model model) throws Exception {
		List<ProductVO> list = service.productGetList(criteria);
		
		model.addAttribute("list", list);
		
		return"about/products";
	}
	
	@GetMapping("/productDetail")
	public String productDetail(int productCode, Model model) throws Exception {
		ProductVO info = service.productInfo(productCode);
		model.addAttribute("info", info);
		return"about/productDetail";
	}
	
}


