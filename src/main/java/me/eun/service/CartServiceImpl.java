package me.eun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.eun.mapper.CartMapper;
import me.eun.model.CartDTO;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public int addCart(CartDTO cart) {
		// 장바구니 데이터 체크
				CartDTO checkCart = cartMapper.checkCart(cart);
				
				if(checkCart != null) {
					return 2;
				}
				
				// 장바구니 등록 & 에러 시 0반환
				try {
					return cartMapper.addCart(cart);
				} catch (Exception e) {
					return 0;
				}
	}

	@Override
	public List<CartDTO> getCartList(String memberName) {
		List<CartDTO> cart = cartMapper.listCart(memberName);
		return cart;
	}

	@Override
	public int deleteCart(int cartId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCount(CartDTO cart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CartDTO cartInfo(CartDTO cart) {
		CartDTO checkCart = cartMapper.checkCart(cart);
		return checkCart;
	}

	@Override
	public CartDTO getCart(String memberName) {
		return cartMapper.getCart(memberName);
	}


}
