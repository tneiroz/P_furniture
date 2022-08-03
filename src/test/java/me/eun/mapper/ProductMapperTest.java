package me.eun.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.eun.config.RootConfig;
import me.eun.model.ProductVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class ProductMapperTest {

	@Autowired
	private ProductMapper mapper;
	
	/* 상품등록 테스트 */
    @Test
    public void productAdd() throws Exception{
        
       ProductVO product = new ProductVO();
      //product.setProductCode("5");
       product.setProductName("에스페베르");
       product.setProductPrice("782000");
       product.setProductInstock("9");
       
        
  
        mapper.productAdd(product);
        
    }    
    

}
