package com.cgm.consoleexercise;

import com.cgm.consoleexercise.domain.builder.QuestionBuilder;
import com.cgm.consoleexercise.domain.model.Question;
import com.cgm.consoleexercise.service.AnswerService;
import com.cgm.consoleexercise.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputService {
    private QuestionService questionService;
    private AnswerService answerService;
    private Integer inputValue;

    @Autowired
    public InputService(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    public void analyzeChoice(Integer enteredValue) {
        this.inputValue = enteredValue;
        if (enteredValue.equals(1)) {
            System.out.println("Enter question and answers in format: <question>? “<answer1>” “<answer2>” “<answerX>");
        } else if (enteredValue.equals(2)) {
            System.out.println("Enter question to get answers");
        }
    }

    public void analyzeInput(String input) {
        if (this.inputValue.equals(1)) {
            this.questionService
                    .setQuestionBuilder(new QuestionBuilder(new Question()))
                    .addQuestion(input);
        } else if (this.inputValue.equals(2)) {
            Question question = this.questionService.getQuestion(input);
            if (question != null) {
                question.getAnswers().forEach(answer -> System.out.println(answer.getAnswer()));
            } else {
                System.out.println("The answer to life, universe and everything is 42");
            }
        }
    }
}
