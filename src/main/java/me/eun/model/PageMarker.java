package me.eun.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PageMarker {
	private Criteria criteria;
	private int startPage;
	private int endPage;
	private int tempEndPage;
	private int totalCount;
	private int displayPageNum=10;
	
	private boolean prev;
	private boolean next;
	
	public PageMarker(Criteria criteria , int totalCount) {
		this.criteria = criteria;
		this.totalCount = totalCount;
		endPage = (int)Math.ceil(criteria.getPage() / (double)displayPageNum) * displayPageNum;
		startPage = endPage - displayPageNum +1 ;
		tempEndPage = (int)Math.ceil(totalCount/ (double) criteria.getPerPageNum());
		//321게시글을 한 화면에 10개씩 게시글을 표현한다는것은 criteria perpagenum에 저장  321/10=32.1 = 올림 33페이지 
		if(endPage > tempEndPage) endPage = tempEndPage;
		prev = startPage != 1;
		next = endPage < tempEndPage;
		
	}
}

