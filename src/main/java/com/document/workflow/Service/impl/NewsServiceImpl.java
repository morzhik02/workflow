package com.document.workflow.Service.impl;

import com.document.workflow.Entity.News;
import com.document.workflow.Repository.NewsRepository;
import com.document.workflow.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public News createNews(News news) {
        news.setCreatedAt(LocalDateTime.now());
        news.setUpdatedAt(LocalDateTime.now());
        return newsRepository.save(news);
    }

    @Override
    public News updateNews(News news, Long id) {
        News oldNews = newsRepository.getReferenceById(id);
        oldNews.setUpdatedAt(LocalDateTime.now());
        oldNews.setText(news.getText());
        oldNews.setTitle(news.getTitle());
        return newsRepository.save(oldNews);
    }

    @Override
    public News getNewsById(Long id) {
        return newsRepository.findById(id).get();
    }

    @Override
    public List<News> getNews() {
        return newsRepository.findAll();
    }

    @Override
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}
