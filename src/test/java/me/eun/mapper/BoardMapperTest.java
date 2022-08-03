package me.eun.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.eun.model.Board;

public class BoardMapperTest {

	@Autowired
	BoardMapper boardmapper;	
	
	@Test 
	@Ignore
	public void getListTest() {
//	List<Board> list = boardmapper.getList();
//	assertEquals(4, list.size());
	}
	
	@Test
	public void getTest() {
		boardmapper.get(1L);
		
	}
	@Test
	@Ignore
	public void insertTest() {
		Board board = new Board();
		board.setTitle("제목 넣는중");
		board.setContent("내용 넣는중");
		board.setWriter("작성자 넣는중");
		boardmapper.insert(board);
		Board getBoard = boardmapper.get(5L);
		assertEquals(board.getTitle(),getBoard.getTitle());
		assertEquals(board.getContent(),getBoard.getContent());
		assertEquals(board.getWriter(),getBoard.getWriter());
		assertEquals(board.getBno(),getBoard.getBno());
			
	}
	
	@Test
	@Ignore
	public void updateTest() {
		Board board = boardmapper.get(1L);
		board.setTitle("1번 게시글 제목 수정");
		board.setContent("1번 게시글 내용 수정");
		boardmapper.update(board);
		assertEquals("1번 게시글 제목 수정",board.getTitle());
		assertEquals("1번 게시글 내용 수정",board.getContent());
		assertEquals("작성자1",board.getWriter());
		
		
	}
	
	@Test
	@Ignore
	public void deleteTest() {
		boardmapper.delete(1L);
		boardmapper.delete(2L);
		Board board1 = boardmapper.get(1L);
		Board board2 = boardmapper.get(2L);
		Board board3 = boardmapper.get(3L);
		assertNull(board1);
		assertNull(board2);
		assertNotNull(board3);
		
	}
}
