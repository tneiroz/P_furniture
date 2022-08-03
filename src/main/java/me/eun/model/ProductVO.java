package me.eun.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ProductVO {
	/*제품 코드*/
	private String productCode;
	/*제품 이름*/
	private String productName;
	/*제품 가격*/
	private String productPrice;
	/*제품 재고수*/
	private String productInstock;
}
