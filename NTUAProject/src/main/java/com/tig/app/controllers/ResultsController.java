package com.tig.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tig.app.entities.Article;
import com.tig.app.services.ArticleService;

@Controller
public class ResultsController {

	@Autowired
	private ArticleService articleService;
	
	
	@GetMapping(value="/results")
	public void getAllArticles(Model model) {
		List<Article> allArticles = articleService.getAllArticles();
		model.addAttribute("articles", allArticles);
	}
}
