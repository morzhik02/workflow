package com.document.workflow.Controller;

import com.document.workflow.Entity.News;
import com.document.workflow.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    public News createNews(@RequestBody News news){
        return newsService.createNews(news);
    }

    @PutMapping("/{id}")
    public News updateNews(@RequestBody News news, @PathVariable("id") Long id){
        return newsService.updateNews(news, id);
    }

    @GetMapping(value = "/{id}")
    public News getNews(@PathVariable("id") Long id){
        return newsService.getNewsById(id);
    }

    @GetMapping
    public List<News> listAllNews(){
        List<News> news = newsService.getNews();
        return news;
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable("id") Long id){
        newsService.deleteNews(id);
    }
}
