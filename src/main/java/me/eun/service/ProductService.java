package me.eun.service;

import me.eun.model.ProductVO;

public interface ProductService {
	 /* 상품 등록 */
    public void productAdd(ProductVO product) throws Exception;

}
