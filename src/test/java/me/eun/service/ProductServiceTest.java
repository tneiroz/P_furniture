package me.eun.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.eun.config.RootConfig;
import me.eun.model.ProductVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class ProductServiceTest {

	/*AuthoreService 의존성 주입*/
    @Autowired
    private ProductService service;
    
    @Test
    public void productAddTest() throws Exception {
 
        ProductVO product = new ProductVO();
        product.setProductName("테스트");
        product.setProductPrice("테스트");
        product.setProductInstock("테스트");
        
        service.productAdd(product);
        
    }

}
