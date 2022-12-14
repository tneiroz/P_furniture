package me.eun.mapper;

import java.util.List;

import me.eun.model.Board;
import me.eun.model.Criteria;

public interface BoardMapper {
	List<Board> getList(Criteria criteria);
	Board get (Long bno);
	void insert (Board board);
	void update (Board board);
	void delete (Long bno);
	int totalCount();
	
	/* 댓글 작성시 게시글 번호 */
	public Board getBoardNumber (Long bno);
}
