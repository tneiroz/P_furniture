package me.eun.mapper;

import java.util.List;

import me.eun.model.AdminAttachVO;
import me.eun.model.AttachImageVO;
import me.eun.model.Criteria;
import me.eun.model.ProductVO;

public interface ProductMapper {
	/*상품등록*/
	public void productAdd (ProductVO product);
	
	/*상품목록*/
	public List<ProductVO> productGetList (Criteria criteria);
	
	/*상품조회*/
	public ProductVO productInfo (int productCode);
	
	/* 이미지 등록 */
	public void imageAdd(AttachImageVO vo);



}
