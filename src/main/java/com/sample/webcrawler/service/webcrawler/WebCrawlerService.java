package com.sample.webcrawler.service.webcrawler;

import com.sample.webcrawler.exceptions.RequestIsNotValidException;
import com.sample.webcrawler.exceptions.WebCrawlerNotFoundException;
import com.sample.webcrawler.persistence.entity.WebCrawler;
import com.sample.webcrawler.service.BaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class WebCrawlerService extends BaseService implements WebCrawlerManager {

  private static final Logger LOGGER = LogManager.getLogger(WebCrawlerService.class.getName());

  @Value("${web.crawler.product.meta.description}")
  private String metaDescription;

  @Value("${web.crawler.product.meta.description.attribute.key}")
  private String metaDescriptionAttributeKey;

  @Override
  @Transactional
  public WebCrawler webCrawlerParser(String url) {

    LOGGER.info("Crawling URL: {}", url);

    Document document;
    try {
      document = Jsoup.connect(url).get();
    } catch (IOException e) {
      throw new RequestIsNotValidException();
    }

    WebCrawler webCrawler =
        WebCrawler.builder()
            .url(document.baseUri())
            .title(document.title())
            .description(document.select(metaDescription).first().attr(metaDescriptionAttributeKey))
            .build();

    webCrawlerRepository.save(webCrawler);

    return webCrawler;
  }

  @Override
  public WebCrawler findWebCrawler(Long webCrawlerId) {
    return fetchWebCrawler(webCrawlerId);
  }

  @Override
  @Cacheable(value = "webCrawlers", sync = true, cacheManager = "cacheManager")
  public List<WebCrawler> findAllWebCrawler() {

    List<WebCrawler> webCrawlers = webCrawlerRepository.findAll();

    if (!webCrawlers.isEmpty()) {
      return webCrawlers;
    } else {
      throw new WebCrawlerNotFoundException();
    }
  }

  @Override
  @Transactional
  public void deleteWebCrawler(Long webCrawlerId) {
    Optional<WebCrawler> webCrawler = webCrawlerRepository.findById(webCrawlerId);
    if (!webCrawler.isPresent()) {
      throw new WebCrawlerNotFoundException();
    }
    webCrawlerRepository.deleteById(webCrawlerId);
  }

  private WebCrawler fetchWebCrawler(Long webCrawlerId) {
    Optional<WebCrawler> webCrawler = webCrawlerRepository.findById(webCrawlerId);
    if (!webCrawler.isPresent()) {
      throw new WebCrawlerNotFoundException();
    }

    return webCrawler.get();
  }
}
