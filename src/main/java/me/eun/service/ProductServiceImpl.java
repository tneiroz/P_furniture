package me.eun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.eun.mapper.AttachMapper;
import me.eun.mapper.ProductMapper;
import me.eun.model.AttachImageVO;
import me.eun.model.Criteria;
import me.eun.model.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	private AttachMapper attachMapper;
	
	/*상품 등록*/
	@Override
	public void productAdd(ProductVO product) throws Exception {
		
		productMapper.productAdd(product);
		/*만약 상품 등록할때 사진이 없다면 그대로 return 값을 반환*/
		if(product.getImageList() == null || product.getImageList().size() <= 0) {
			return;
		}
		product.getImageList().forEach(attach ->{
			attach.setProductCode(product.getProductCode());
			productMapper.imageAdd(attach);
			
			
		});
		
	}
	/*상품 목록*/
	@Override
	public List<ProductVO> productGetList (Criteria criteria) throws Exception {
		List<ProductVO> list = productMapper.productGetList(criteria);
		list.forEach(product -> {
			int productCode = product.getProductCode();
			List<AttachImageVO> imageList = attachMapper.getAttachList(productCode);
			product.setImageList(imageList);
		});
		return list;
	}
	
	/*상품 상세 조회*/
	@Override
	public ProductVO productInfo(int productCode) {
		return productMapper.productInfo(productCode);
	}


}