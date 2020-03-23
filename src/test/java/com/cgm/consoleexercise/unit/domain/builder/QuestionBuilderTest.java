package com.cgm.consoleexercise.unit.domain.builder;

import com.cgm.consoleexercise.domain.builder.AnswerBuilder;
import com.cgm.consoleexercise.domain.builder.QuestionBuilder;
import com.cgm.consoleexercise.domain.model.Answer;
import com.cgm.consoleexercise.domain.model.Question;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.InputMismatchException;
import java.util.LinkedHashSet;

import static org.junit.Assert.assertEquals;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class QuestionBuilderTest {
    private QuestionBuilder spy;
    private Question question;
    private QuestionBuilder questionBuilder;
    private AnswerBuilder answerBuilder;

    @Before
    public void setUp(){
        this.question = new Question();
        this.answerBuilder = new AnswerBuilder(new LinkedHashSet<>(), new Answer());
        this.questionBuilder = new QuestionBuilder(this.question);
        this.questionBuilder.setAnswerBuilder(this.answerBuilder);
        this.spy = Mockito.spy(this.questionBuilder);
    }

    @Test
    public void buildQuestionWithQuestionMark(){
        String input = "Compu Group Medical?\"Austria\"";
        this.spy.buildQuestion(input);
        assertEquals(this.question.getQuestion(), input.split("\\?")[0]);
    }

    @Test(expected = InputMismatchException.class)
    public void buildQuestionWithoutQuestionMark(){
        String input = "Compu Group Medical \"Austria\"";
        this.spy.buildQuestion(input);
    }

    @Test(expected = InputMismatchException.class)
    public void buildQuestionWithoutDoubleQuotes(){
        String input = "Compu Group Medical? Austria";
        this.spy.buildQuestion(input);
    }

    @Test(expected = InputMismatchException.class)
    public void buildQuestionWithTooLongInput(){
        String input = "\"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaa\"";
        this.spy.buildQuestion(input);
    }
}
