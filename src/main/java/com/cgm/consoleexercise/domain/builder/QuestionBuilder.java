package com.cgm.consoleexercise.domain.builder;

import com.cgm.consoleexercise.domain.model.Question;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
        if (input.contains("?") && input.contains("\"")) {
            this.question.setQuestion(input.split("\\?")[0]);
            this.question.setAnswers(this.answerBuilder.setQuestion(this.question)
                    .buildAnswers(input.split("\\?")[1])
                    .getAnswers());
        }
        return this;
    }
}
