package me.eun.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import me.eun.config.RootConfig;
import me.eun.config.ServletConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class,ServletConfig.class})
@WebAppConfiguration
public class TotalCountTest   {

	@Autowired
	BoardMapper mapper;
	
	@Test
	public void test() {
		assertEquals(321, mapper.totalCount());
	}
	
}
