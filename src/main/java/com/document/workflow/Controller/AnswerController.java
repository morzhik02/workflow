package com.document.workflow.Controller;

import com.document.workflow.Entity.Answer;
import com.document.workflow.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public Answer createAnswer(@RequestBody Answer answer){
        return answerService.createAnswer(answer);
    }

    @PutMapping("/{id}")
    public Answer updateAnswer(@RequestBody Answer answer, @PathVariable("id") Long id){
        return answerService.updateAnswer(answer, id);
    }

    @GetMapping(value = "/{id}")
    public Answer getAnswer(@PathVariable("id") Long id){
        return answerService.getAnswer(id);
    }

    @GetMapping
    public List<Answer> listAllAnswers(){
        List<Answer> answers = answerService.getAnswers();
        return answers;
    }

    @DeleteMapping("/{id}")
    public void deleteAnswer(@PathVariable("id") Long id){
        answerService.deleteAnswer(id);
    }

}
