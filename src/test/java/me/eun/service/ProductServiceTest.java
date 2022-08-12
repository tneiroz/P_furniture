package me.eun.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.eun.config.RootConfig;
import me.eun.mapper.ProductMapper;
import me.eun.model.AdminAttachVO;
import me.eun.model.AttachImageVO;
import me.eun.model.Criteria;
import me.eun.model.ProductVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class ProductServiceTest {

	/*AuthoreService 의존성 주입*/
    @Autowired
    private ProductService service;
    @Autowired
    private ProductMapper mapper;
    
    @Test
    @Ignore
    /*상품 등록 테스트*/
    public void productAddTest() throws Exception {
 
        ProductVO product = new ProductVO();
        product.setProductName("테스트");
        product.setProductPrice("테스트");
        product.setProductInstock("테스트");
        
        service.productAdd(product);
        
    }
    
    /*상품 목록 테스트*/
    @Test
    @Ignore
    public void productGetListTest() throws Exception{
    	Criteria criteria = new Criteria(3,10); //3페이지 & 10개 행 표시
    	List<ProductVO> list = mapper.productGetList(criteria);
     }

    /*상품 상세 조회*/
    @Test
    public void productInfoTest() {
		String productName = "플랏사";
		ProductVO result = mapper.productInfo(productName);
		System.out.println("상품 조회 데이터 : " + result);
	}
   
		
}
 

