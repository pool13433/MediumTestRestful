package com.poolsawat.medium.testrestful.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poolsawat.medium.testrestful.entity.Blog;
import com.poolsawat.medium.testrestful.repository.BlogRepository;

@Controller
public class CrudController {
	
	@Autowired
	private BlogRepository blogRepository;
	
	
	@RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello World";
    }
	
	@GetMapping("/get")
	public @ResponseBody Iterable<Blog> getBlogs(){
		return this.blogRepository.findAll();
	}
	
	@GetMapping("/get/id/{id}")
	public @ResponseBody Optional<Blog> getBlog(@PathVariable(name="id") Long id){
		return this.blogRepository.findById(id);
	}
	
	@PostMapping("/save")
	public @ResponseBody Blog saveBlog(@RequestBody Blog blog){
		return this.blogRepository.save(blog);
	}
	
	@PutMapping("/update")
	public @ResponseBody Blog updateBlog(@RequestBody Blog blog){		
		return this.blogRepository.save(blog);
	}
	
	@DeleteMapping("/id/{id}")
	public @ResponseBody Long deleteBlog(@PathVariable(name="id") Long id) {
		this.blogRepository.deleteById(id);
		return id;
	}
	
}
