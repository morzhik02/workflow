package com.document.workflow.Service.impl;

import com.document.workflow.Entity.Answer;
import com.document.workflow.Entity.History;
import com.document.workflow.Repository.AnswerRepository;
import com.document.workflow.Repository.HistoryRepository;
import com.document.workflow.Service.AnswerService;
import com.document.workflow.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public History createHistory(History history) {
        history.setAction("Создано");
        history.setCreatedAt(LocalDateTime.now());
        history.setUpdatedAt(LocalDateTime.now());
        return historyRepository.save(history);
    }

    @Override
    public History updateHistory(History history, Long id) {
        History oldHistory = historyRepository.getReferenceById(id);
        oldHistory.setDoc(history.getDoc());
        oldHistory.setUser(history.getUser());
        oldHistory.setAction(history.getAction());
        oldHistory.setUpdatedAt(LocalDateTime.now());
        return historyRepository.save(oldHistory);
    }

    @Override
    public List<History> getHistory() {
        return historyRepository.findAll();
    }

}