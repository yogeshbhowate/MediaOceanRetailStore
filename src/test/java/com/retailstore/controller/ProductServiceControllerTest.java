package com.retailstore.controller;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.retailstore.config.AppInitializer;
import com.retailstore.config.PersistentConfig;
import com.retailstore.config.SpringRootConfig;
import com.retailstore.config.SpringWebConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppInitializer.class, SpringRootConfig.class, SpringWebConfig.class, PersistentConfig.class})
@WebAppConfiguration
public class ProductServiceControllerTest {

	@Autowired
    private WebApplicationContext context;
	
	 @Before
     public void setUp() throws Exception {
		 RestAssuredMockMvc.mockMvc(MockMvcBuilders.webAppContextSetup(context).build());
		 
     }
	
	@Test
	public void testScanProduct() {
		given().when().get("/")
		.then()
		.statusCode(200)
		.body("test", equalTo ("asd"));

	}
}
