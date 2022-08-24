package me.eun.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.eun.config.RootConfig;
import me.eun.model.ReplyDTO;
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class ReplyMapperTest {

	@Autowired
	private ReplyMapper mapper;

	
	@Test
	public void insertReplyTest() {
		String memberName ="박정은";
		Long bno = (long) 3;
		String content = "댓글테스트";
		
		ReplyDTO dto = new ReplyDTO();
		dto.setBno(bno);
		dto.setMemberName(memberName);
		dto.setContent(content);
		
		mapper.insertReply(dto);
		
	}
}