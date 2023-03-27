package com.document.workflow.Service;

import com.document.workflow.Entity.Answer;

import java.util.List;


public interface AnswerService {
    Answer createAnswer(Answer answer);
    Answer updateAnswer(Answer answer, Long id);
    Answer getAnswer(Long id);
    List<Answer> getAnswers();
    void deleteAnswer(Long id);
}
