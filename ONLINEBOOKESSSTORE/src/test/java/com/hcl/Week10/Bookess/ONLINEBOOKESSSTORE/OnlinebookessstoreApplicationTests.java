package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;





@SpringBootTest
class OnlinebookessstoreApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void testString() {
		OnlinebookessstoreApplication bookessApplication = new OnlinebookessstoreApplication();
		Assertions.assertEquals("GL", bookessApplication.add("learning" ), "It was not Equivalent");
		
	}
	
	@Test
	void testList() {
		OnlinebookessstoreApplication bookessApplication = new OnlinebookessstoreApplication();
		ArrayList<String> names = new ArrayList<String>();
		names.add("hello");
		Assertions.assertEquals(names,bookessApplication.listString("hello"));
	}

}
