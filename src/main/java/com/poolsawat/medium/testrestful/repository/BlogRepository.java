package com.poolsawat.medium.testrestful.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poolsawat.medium.testrestful.entity.Blog;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Long> {	
	List<Blog> findByTitle(String title) throws Exception;
	List<Blog> findByAuthor(String author) throws Exception;
}
