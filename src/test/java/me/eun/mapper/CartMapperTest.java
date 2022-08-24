package me.eun.mapper;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.eun.config.RootConfig;
import me.eun.model.CartDTO;
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class CartMapperTest {

	@Autowired
	private CartMapper mapper;

	/*카드 추가*/
	@Test
	@Ignore
	public void addCart() throws Exception {
		String memberName = "박정은";
		int productCode =2;
		int productCount =3;
		
		CartDTO cart = new CartDTO();
		cart.setMemberName(memberName);
		cart.setProductCode(productCode);
		cart.setProductCode(productCode);
		cart.setProductCount(productCount);
		
		int result = 0;
		result = mapper.addCart(cart);
		
		System.out.println("결과 : " + result);
		
	}	
	
	/* 카트 삭제 */
	@Test
	@Ignore
	public void deleteCartTest() {
		int cartId = 2;
		mapper.deleteCart(cartId);
	}
	/* 카트 수량 수정 */
	@Test
	@Ignore
	public void modifyCartTest() {
		int cartId = 3;
		int count = 5;
		
		CartDTO cart = new CartDTO();
		cart.setCartId(cartId);
		cart.setProductCount(count);
		mapper.modifyCount(cart);
		
	}
	/* 카트목록 */ 
	@Test
	@Ignore
	public void getCartTest() {
		String memberName = "박정은";
	//	List<CartDTO> list = mapper.getCart(memberName);
	//	for(CartDTO cart : list) {
		//	System.out.println(cart);
			//cart.getProductInstock();
		}

	
	/* 카트 확인 */
	@Test
	public void checkCartTest() {
		
		String memberName= "박정은";
		int productCode=2;
		
		CartDTO cart = new CartDTO();
		cart.setMemberName(memberName);
		cart.setProductCode(productCode);
		CartDTO resutlCart = mapper.checkCart(cart);
		System.out.println("결과 : " + resutlCart);
		
	}
}