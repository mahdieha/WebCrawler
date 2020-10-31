package com.sample.webcrawler.exceptions;

public class RequestIsNotValidException extends WebCrawlerException {

  public RequestIsNotValidException() {
    super("The Request Is Not Valid");
    messageKey = "WebCrawler.exceptions.BadRequest";
  }
}
