package com.cgm.consoleexercise.service;

import com.cgm.consoleexercise.domain.model.Answer;
import com.cgm.consoleexercise.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void save(List<Answer> answers){
//        this.answerRepository.save()
    }

    public List<Answer> getAnswers(Integer questionId){
        return this.answerRepository.findAllByQuestionId(questionId);
    }
}
