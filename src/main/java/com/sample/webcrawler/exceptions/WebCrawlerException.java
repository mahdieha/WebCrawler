package com.sample.webcrawler.exceptions;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Optional;
import java.util.ResourceBundle;

public abstract class WebCrawlerException extends RuntimeException {

  protected String messageKey;
  private ResourceBundle exceptions =
      ResourceBundle.getBundle("i18n/messages", LocaleContextHolder.getLocale());

  protected WebCrawlerException(String message) {
    super(message);
  }

  @Override
  public String getMessage() {
    return getLocalizedMessage();
  }

  @Override
  public String getLocalizedMessage() {
    if (!Optional.ofNullable(messageKey).isPresent()) {
      return "Operation Failure!";
    }
    return exceptions.getString(messageKey);
  }
}
