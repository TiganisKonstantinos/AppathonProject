package com.tig.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tig.app.entities.Article;


public interface ArticleRepository extends CrudRepository<Article, Long>{

	@Query("SELECT MAX(a.searchIndex) FROM Article a")
	List<Integer> findLastSearchIndex();
	
	@Query("SELECT a FROM Article a WHERE searchIndex = ?1")
	List<Article> findBySearchIndex(int searchIndex);
	
	
}
