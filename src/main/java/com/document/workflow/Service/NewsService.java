package com.document.workflow.Service;

import com.document.workflow.Entity.News;

import java.util.List;

public interface NewsService {
    News createNews(News news);
    News updateNews(News news, Long id);
    News getNewsById(Long id);
    List<News> getNews();
    void deleteNews(Long id);
}
