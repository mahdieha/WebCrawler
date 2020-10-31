package com.sample.webcrawler.controller;

import com.sample.webcrawler.service.webcrawler.WebCrawlerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {
  @Autowired protected ModelMapper modelMapper;

  @Autowired protected WebCrawlerService webCrawlerService;
}
