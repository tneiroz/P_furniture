package me.eun.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.eun.config.RootConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class AttachMapperTest {

	@Autowired
	private AttachMapper attachMapper;
	
	
	/*이미지 정보 반환*/
	@Test
	public void getAttachListTest() {
		int productCode = 4;
		System.out.println("이미지 정보 : " + attachMapper.getAttachList(productCode));
		
		
	}

}
