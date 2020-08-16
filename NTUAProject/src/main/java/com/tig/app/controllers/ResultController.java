package com.tig.app.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.tig.app.entities.Article;
import com.tig.app.entities.Metadata;
import com.tig.app.services.ArticleService;
import com.tig.app.services.MetadataService;

@Controller
public class ResultController {
	
	int totalArticles = 0;
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private MetadataService metadataService;
	
	
	@PostMapping(value="/result")
	public String search(@RequestParam(value="diseases[]") String[] splitDiseases,
						 @RequestParam(value="dateFrom") String from,
						 @RequestParam(value="dateTo") String to) throws UnirestException, IOException, ParseException {
		totalArticles = 0;
		Date fromDate = new SimpleDateFormat("yyyy-mm-dd").parse(from);
		Date toDate = new SimpleDateFormat("yyyy-mm-dd").parse(to);
		int lastSearchIndex = articleService.getLastSearchIndex();
		for(int i = 1; i < splitDiseases.length; i++){
			List<Metadata> metadataFound = metadataService.getMetadataByDateRangeAndWordKeys(splitDiseases[0], splitDiseases[i], fromDate, toDate);
			if(metadataFound != null) {
				totalArticles += metadataFound.size();
				for (int k=0; k<metadataFound.size();k++) {
						Article article = new Article();
						article.setArticleId(metadataFound.get(k).getCordId());
					    article.setTitle(metadataFound.get(k).getTitle());
					    article.setTimestamp(metadataFound.get(k).getPublishTime());
					    article.setAuthorName(metadataFound.get(k).getAuthors());
					    article.setSiteLink(metadataFound.get(k).getUrl());
						article.setSearchIndex(lastSearchIndex+1);
						articleService.addArticle(article);
				}
				
			}
			
		}
		return "redirect:result";

	}
	
	@RequestMapping(value="/result")
	public String getSearchedArticles(Model model) {
		int lastSearchIndex = articleService.getLastSearchIndex();
		List<Article> searchedArticles = articleService.getArticlesBySearchIndex(lastSearchIndex);
		model.addAttribute("articles", searchedArticles);
		model.addAttribute("totalArticles","Total Articles Found: "+totalArticles);
		return "result";
	}
}
	