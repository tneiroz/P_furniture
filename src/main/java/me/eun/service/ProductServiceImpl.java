package me.eun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.eun.mapper.ProductMapper;
import me.eun.model.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	ProductMapper productMapper;
	@Override
	public void productAdd(ProductVO product) throws Exception {
		productMapper.productAdd(product);
	}

	

}
