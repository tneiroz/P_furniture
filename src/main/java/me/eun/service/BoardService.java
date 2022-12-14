package me.eun.service;

import java.util.List;

import me.eun.model.Board;
import me.eun.model.Criteria;

public interface BoardService {
	List<Board> getList(Criteria criteria);
	Board get (Long bno);
	void register (Board board);
	void modify (Board board);
	void remove (Long bno);
	int totalCount();
	
	/* 댓글 작성시 게시글 번호 */
	public Board getBoardNumber (Long bno);
}
