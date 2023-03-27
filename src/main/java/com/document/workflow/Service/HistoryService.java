package com.document.workflow.Service;

import com.document.workflow.Entity.Answer;
import com.document.workflow.Entity.History;

import java.util.List;

public interface HistoryService {
    History createHistory(History history);
    History updateHistory(History history, Long id);
    List<History> getHistory();
}
