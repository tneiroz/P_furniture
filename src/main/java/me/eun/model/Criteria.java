package me.eun.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor
public class Criteria {
	
	/*현재 페이지 번호*/
	int page;
	/*한 페이지당 보일 게시글 수 */
	int perPageNum;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
		
	}
	public int getpageStart() {
		return (this.page-1)*perPageNum;
	}
}