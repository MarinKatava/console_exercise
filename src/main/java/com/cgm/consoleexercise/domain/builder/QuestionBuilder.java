package com.cgm.consoleexercise.domain.builder;

import com.cgm.consoleexercise.domain.model.Question;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.InputMismatchException;

@Getter
@Setter
@Accessors(chain = true)
public class QuestionBuilder {
    private Question question;
    private AnswerBuilder answerBuilder;

    public QuestionBuilder(Question question) {
        this.question = question;
    }

    public QuestionBuilder buildQuestion(String input) {
        String question = input.split("\\?")[0];
        if (input.contains("?") && input.contains("\"") && question.length() <= 255) {
            this.question.setQuestion(question);
            this.question.setAnswers(
                    this.answerBuilder.setQuestion(this.question)
                            .buildAnswers(input.split("\\?")[1])
                            .getAnswers());
        } else {
            throw new InputMismatchException();
        }

        return this;
    }
}
