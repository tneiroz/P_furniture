package me.eun.paging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import me.eun.config.RootConfig;
import me.eun.config.ServletConfig;
import me.eun.mapper.BoardMapper;
import me.eun.model.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class,ServletConfig.class})
@WebAppConfiguration
public class DataInsertTest {

	@Autowired
	BoardMapper mapper;
	@Test
	public void dataInsert() {
		
		for(int i=1; i<=321; i++) {
			
			Board board = new Board();
			board.setTitle("제목 페이징 연습" +i );
			board.setContent("내용 페이징 연습" +i );
			board.setWriter("작성자 페이징 연습" +i );
			mapper.insert(board);
		}
	}
}
