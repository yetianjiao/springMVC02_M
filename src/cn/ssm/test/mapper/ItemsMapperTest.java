package cn.ssm.test.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemsMapperTest {

	private ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("claapath:spring/applicationContext-dao.xml");
	}

	@Test
	public void testSelectByPrimaryKey() {
		fail("Not yet implemented");
	}

}
