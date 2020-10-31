package com.sample.webcrawler.exceptions;

public class WebCrawlerNotFoundException extends WebCrawlerException {
  public WebCrawlerNotFoundException() {
    super("WebCrawler Not Found");
    messageKey = "WebCrawler.exceptions.webCrawler.webCrawlerNotFoundException";
  }
}
