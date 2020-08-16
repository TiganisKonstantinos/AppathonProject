package com.tig.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tig.app.entities.Article;
import com.tig.app.repositories.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	public List<Article> getAllArticles(){
		List<Article> articles = new ArrayList<>();
		articleRepository.findAll().forEach(articles::add);
		return articles;
	}
	
	public Optional<Article> getArticle(long id) {
		return articleRepository.findById(id);
	}
	
	public void addArticle(Article article) {
		articleRepository.save(article);
	}
	
	public List<Article> getArticlesBySearchIndex(int searchIndex){
		List<Article> articles = new ArrayList<>();
		articleRepository.findBySearchIndex(searchIndex).forEach(articles::add);
		return articles;
	}
	
	public int getLastSearchIndex(){
		List<Integer> lastSearchIndex = new ArrayList<>();
		articleRepository.findLastSearchIndex().forEach(lastSearchIndex::add);
		return lastSearchIndex.get(0);
	}
	
	
	
}
