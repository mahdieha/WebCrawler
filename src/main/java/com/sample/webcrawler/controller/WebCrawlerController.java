package com.sample.webcrawler.controller;

import com.sample.webcrawler.domain.WebCrawlerDto;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/web-crawler")
public class WebCrawlerController extends BaseController {

  @PostMapping
  public ResponseEntity webCrawlerParser(
      @ApiParam(value = "url", name = "url") @RequestParam String url) {
    return new ResponseEntity<>(
        modelMapper.map(webCrawlerService.webCrawlerParser(url), WebCrawlerDto.class),
        HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<WebCrawlerDto> findWebCrawler(
      @ApiParam(value = "webCrawlerId", name = "webCrawlerId") @RequestParam Long webCrawlerId) {
    return new ResponseEntity<>(
        modelMapper.map(webCrawlerService.findWebCrawler(webCrawlerId), WebCrawlerDto.class),
        HttpStatus.OK);
  }

  @GetMapping("/web-crawlers")
  public ResponseEntity findAllWebCrawlers() {
    List<WebCrawlerDto> webCrawlerList =
        Arrays.asList(
            modelMapper.map(webCrawlerService.findAllWebCrawler(), WebCrawlerDto[].class));
    return new ResponseEntity<>(
        modelMapper.map(webCrawlerList, WebCrawlerDto[].class), HttpStatus.OK);
  }

  @DeleteMapping
  public ResponseEntity deleteWebCrawler(
      @ApiParam(value = "webCrawlerId", name = "webCrawlerId") @RequestParam Long webCrawlerId) {
    webCrawlerService.deleteWebCrawler(webCrawlerId);
    return new ResponseEntity(HttpStatus.OK);
  }
}
