package me.eun.mapper;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.eun.config.RootConfig;
import me.eun.model.AttachImageVO;
import me.eun.model.ProductVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class ProductMapperTest {

	@Autowired
	private ProductMapper mapper;
	
	/* 상품등록 테스트 */
    @Test
    public void productAddTest() throws Exception{
        
       ProductVO product = new ProductVO();
       product.setProductCode(30);
       product.setProductName("메퍼테스트");
       product.setProductPrice("782000");
       product.setProductInstock("9");
       
        
       System.out.println("Before ProductVO :" + product);
		
        mapper.productAdd(product);
        System.out.println("After ProductVO :" + product);
        
    }    
    /* 이미지 등록 */
	@Test
	public void imageAddTest() {
		
		AttachImageVO vo = new AttachImageVO();
		
		vo.setProductCode(1);
		vo.setFileName("test1112");
		vo.setUploadPath("test2332");
		vo.setUuid("test42312");
		
		mapper.imageAdd(vo);
		
	}
}
