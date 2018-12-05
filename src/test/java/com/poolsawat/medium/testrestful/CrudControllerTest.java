package com.poolsawat.medium.testrestful;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CrudControllerTest {
	
	@Autowired
    private MockMvc mockMvc;	
	
	@Test
	public void testShouldSaveBlog() throws Exception {
		String content = "{\"id\" : 4,\"title\" : \"TestRestful\"}";
		this.mockMvc.perform(
				post("/save")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.title", equalTo("TestRestful")))
        .andExpect(jsonPath("$.content", nullValue()))
        .andExpect(jsonPath("$.author", nullValue()));
	}
	
	@Test
	public void testShouldGetReturnBlogs() throws Exception {
		this.mockMvc.perform(get("/get"))
		.andDo(print())
		.andExpect(status().isOk())        
        .andExpect(jsonPath("$", hasSize(2)));
	}
	
	@Test
	public void testShouldGetReturnBlogById() throws Exception {
		Integer id = 3;
		this.mockMvc.perform(get("/get/id/"+id))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id", equalTo(id)))
        .andExpect(jsonPath("$.title", equalTo("สร้าง Project JSF Primeface ด้วย Maven พร้อมกับสอนทำระบบ Template Layout")));
	}
	
	@Test
	public void testShouldDeleteBlogById() throws Exception {
		Integer id = 1;
		this.mockMvc.perform(delete("/id/"+id))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", equalTo(id)));
	}
	
	@Test
	public void testShouldUpdateBlog() throws Exception {		
		String content = "{\"id\" : 2,\"title\" : \"ShouldUpdateBlog\",\"author\" : \"poolsawat\"}";
		this.mockMvc.perform(
				put("/update")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id", equalTo(2)))
		.andExpect(jsonPath("$.title", equalTo("ShouldUpdateBlog")))
		.andExpect(jsonPath("$.content", nullValue()))
		.andExpect(jsonPath("$.author", equalTo("poolsawat")));
	}
}
