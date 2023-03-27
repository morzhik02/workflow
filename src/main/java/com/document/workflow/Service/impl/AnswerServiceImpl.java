package com.document.workflow.Service.impl;

import com.document.workflow.Entity.Answer;
import com.document.workflow.Repository.AnswerRepository;
import com.document.workflow.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer createAnswer(Answer answer) {
        answer.setStatus("Создано");
        answer.setCreatedAt(LocalDateTime.now());
        answer.setUpdatedAt(LocalDateTime.now());
        return answerRepository.save(answer);
    }

    @Override
    public Answer updateAnswer(Answer answer, Long id) {
        Answer oldAnswer = answerRepository.getReferenceById(id);
        oldAnswer.setStatus(answer.getStatus());
        oldAnswer.setType(answer.getType());
        oldAnswer.setText(answer.getText());
        oldAnswer.setUpdatedAt(LocalDateTime.now());
        return answerRepository.save(oldAnswer);
    }

    @Override
    public Answer getAnswer(Long id) {
        return answerRepository.findById(id).get();
    }

    @Override
    public List<Answer> getAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }
}