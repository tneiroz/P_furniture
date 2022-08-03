package me.eun.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor
public class Criteria {
	int page;
	int perPageNum;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
		
	}
	public int getpageStart() {
		return (this.page-1)*perPageNum;
	}
}
