package com.sample.webcrawler.persistence.repository;

import com.sample.webcrawler.persistence.entity.WebCrawler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebCrawlerRepository extends JpaRepository<WebCrawler, Long> {}
