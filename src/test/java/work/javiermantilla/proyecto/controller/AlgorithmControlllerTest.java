package work.javiermantilla.proyecto.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@TestInstance(Lifecycle.PER_CLASS)
@WebMvcTest
@ComponentScan(basePackages = {
        "work.javiermantilla.proyecto"        
})
public class AlgorithmControlllerTest {
	@Autowired
	private MockMvc mockMvc;	
	private String inputJson;
	
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		this.inputJson="{\"data\":[{\"x\":7,\"y\":5,\"n\":12345},{\"x\":5,\"y\":0,\"n\":4},{\"x\":10,\"y\":5,\"n\":15},{\"x\":17,\"y\":8,\"n\":54321},{\"x\":499999993,\"y\":9,\"n\":1000000000}]}";
	}

	@Test
	void test_requiredRemainderPost() throws Exception {
		mockMvc.perform(post("/api/v1/required-remainder")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputJson)
				).andExpect(status().isOk()).andDo(print());
		
	}
	
	@Test
	void test_requiredRemainderGet() throws Exception {
		String data="?data=7,5,12345&data=5,0,4&data=10,5,15&data=17,8,54321&data=499999993,9,1000000000";
		mockMvc.perform(get("/api/v1/required-remainder?"+data)
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputJson)
				).andExpect(status().isOk()).andDo(print());
		
	}

}
