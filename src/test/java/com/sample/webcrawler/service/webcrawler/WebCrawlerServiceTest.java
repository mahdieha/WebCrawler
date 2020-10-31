package com.sample.webcrawler.service.webcrawler;

import com.sample.webcrawler.persistence.entity.WebCrawler;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class WebCrawlerServiceTest {

  private static final String url = "https://dzone.com/articles/java-code-review-checklist";
  @Autowired WebCrawlerService webCrawlerService;

  @Test
  void webCrawlerTitleNotNullTest() {

    WebCrawler webCrawler = webCrawlerService.webCrawlerParser(url);
    Assert.assertNotNull(webCrawler.getTitle());
  }

  @Test
  void webCrawlerRecordDeleteTest() {
    WebCrawler webCrawler = webCrawlerService.webCrawlerParser(url);
    webCrawlerService.deleteWebCrawler(webCrawler.getId());
    Assert.assertNull(webCrawler.getTitle(), null);
  }

  @Test
  void webCrawlerFindByIdTest() {
    WebCrawler webCrawler = webCrawlerService.webCrawlerParser(url);
    webCrawlerService.findWebCrawler(webCrawler.getId());
    Assert.assertEquals(webCrawler.getId(), webCrawler.getId());
  }
}
