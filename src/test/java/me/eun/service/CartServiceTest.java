package me.eun.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.eun.config.RootConfig;
import me.eun.model.CartDTO;
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class CartServiceTest {

	@Autowired
	private CartService service;
	//등록 테스트
		@Test
		public void addCartTest() {
			//given
				String memberName= "관리자";
				int productCode =1;
				int count = 1;
				
				CartDTO dto = new CartDTO(); 
				dto.setMemberName(memberName);
				dto.setProductCode(productCode);
				dto.setProductCount(count);
			//when
				int result = service.addCart(dto);
			
			//then
				System.out.println("** result : " + result);
			
			
		}
}
