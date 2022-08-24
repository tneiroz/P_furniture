package me.eun.mapper;

import java.util.List;

import me.eun.model.CartDTO;

public interface CartMapper {
	/* 카트 추가 */
	public int addCart(CartDTO cart) throws Exception;
	
	/* 카트 삭제 */
	public void deleteCart(int cartId);
	
	/* 카트 수량 수정 */
	public int modifyCount(CartDTO cart);
	
	/* 카트 목록 */
	public List<CartDTO> listCart(String memberName);	
	
	
	public CartDTO getCart(String memberName);	
	
	/* 카트 확인 */
	public CartDTO checkCart(CartDTO cart);
}
