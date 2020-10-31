package com.sample.webcrawler.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class WebCrawlerDto {
  private Long id;
  private String url;
  private String title;
  private String description;
}
