package com.sample.webcrawler.persistence.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "web_crawler")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WebCrawler extends BaseEntity<Long> {

  @NotNull private String url;
  @NotNull private String title;
  private String description;
}
