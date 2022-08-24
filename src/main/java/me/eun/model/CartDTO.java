package me.eun.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class CartDTO {
	//DB에 등록 된 내용 (table 속성)
	private int cartId;
	private String memberName;
	private int productCode;
	private int productCount;
	
	//Product
	private String productName;
	private String productPrice;
	private String productInstock;
	
	
}
