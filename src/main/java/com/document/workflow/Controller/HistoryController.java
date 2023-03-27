package com.document.workflow.Controller;

import com.document.workflow.Entity.History;
import com.document.workflow.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @PostMapping
    public History createHistory(@RequestBody History history){
        return historyService.createHistory(history);
    }

    @PutMapping("/{id}")
    public History updateHistory(@RequestBody History history, @PathVariable("id") Long id){
        return historyService.updateHistory(history, id);
    }

    @GetMapping
    public List<History> listAllHistory(){
        List<History> history = historyService.getHistory();
        return history;
    }

}
