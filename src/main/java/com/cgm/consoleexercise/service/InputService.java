package com.cgm.consoleexercise.service;

import com.cgm.consoleexercise.domain.builder.QuestionBuilder;
import com.cgm.consoleexercise.domain.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputService {
    private QuestionService questionService;

    @Autowired
    public InputService(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Integer analyzeChoice(Integer enteredValue) {
        if (enteredValue.equals(1)) {
            System.out.println("Enter question and answers in format: <question>? “<answer1>” “<answer2>” “<answerX>");
        } else if (enteredValue.equals(2)) {
            System.out.println("Enter question to get answers");
        }
        return enteredValue;
    }

    public void analyzeInput(Integer inputChoice, String input) {
        if (inputChoice.equals(1)) {
            this.questionService
                    .setQuestionBuilder(new QuestionBuilder(new Question()))
                    .addQuestion(input);
        } else if (inputChoice.equals(2)) {
            Question question = this.questionService.getQuestion(input);
            if (question != null) {
                question.getAnswers().forEach(answer -> System.out.println("* " + answer.getAnswer()));
            } else {
                System.out.println("The answer to life, universe and everything is 42");
            }
        }
    }
}
