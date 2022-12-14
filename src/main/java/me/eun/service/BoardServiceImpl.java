package me.eun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import me.eun.mapper.BoardMapper;
import me.eun.model.Board;
import me.eun.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	
	@Autowired
	private BoardMapper boardMapper;
	


	@Override
	public Board get(Long bno) {
		return boardMapper.get(bno);
	}

	@Override
	public void register(Board board) {
		boardMapper.insert(board);
	}

	@Override
	public void modify(Board board) {
		boardMapper.update(board);
	}

	@Override
	public void remove(Long bno) {
		boardMapper.delete(bno);
	}

	@Override
	public List<Board> getList(Criteria criteria) {
		return boardMapper.getList(criteria);
	}

	@Override
	public int totalCount() {
		return boardMapper.totalCount();
	}

	@Override
	public Board getBoardNumber(Long bno) {
		return boardMapper.getBoardNumber(bno);
	}

}
