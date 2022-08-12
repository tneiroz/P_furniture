package me.eun.service;

import java.util.List;

import me.eun.model.Criteria;
import me.eun.model.ProductVO;

public interface ProductService {
	 /* 상품등록 */
    public void productAdd(ProductVO product) throws Exception;

    /*상품목록*/
	List<ProductVO> productGetList(Criteria criteria) throws Exception;
	
	/*상품상세조회*/
	public ProductVO productInfo(String productCode);
}
