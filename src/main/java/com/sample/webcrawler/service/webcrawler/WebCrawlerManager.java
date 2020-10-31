package com.sample.webcrawler.service.webcrawler;

import com.sample.webcrawler.persistence.entity.WebCrawler;

import java.util.List;

public interface WebCrawlerManager {

  WebCrawler webCrawlerParser(String url);

  WebCrawler findWebCrawler(Long webCrawlerId);

  List<WebCrawler> findAllWebCrawler();

  void deleteWebCrawler(Long webCrawlerId);
}
