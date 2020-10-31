package com.sample.webcrawler.service;

import com.sample.webcrawler.persistence.repository.WebCrawlerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService {

  @Autowired protected WebCrawlerRepository webCrawlerRepository;
}
