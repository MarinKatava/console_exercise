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

import java.util.LinkedHashSet;

import static org.mockito.Mockito.*;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class QuestionBuilderTest {
    private QuestionBuilder spy;
    private Question question;
    private QuestionBuilder questionBuilder;

//    @Mock
    private AnswerBuilder answerBuilder;

    @Before
    public void setUp(){
        this.question = new Question();
        this.answerBuilder = new AnswerBuilder(new LinkedHashSet<>(), new Answer());
        this.questionBuilder = new QuestionBuilder(this.question);
        this.questionBuilder.setAnswerBuilder(this.answerBuilder);
        this.spy = Mockito.spy(this.questionBuilder);
//        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void buildQuestionWithQuestionMark(){
        String input = "Compu Group Medical?\"Austria\"";
//        when(this.answerBuilder.setQuestion(any())).thenReturn(this.answerBuilder);
//        when(this.answerBuilder.buildAnswers(anyString())).thenReturn(this.answerBuilder);
//        when(this.answerBuilder.getAnswers()).thenReturn(new LinkedHashSet<>());

        this.spy.buildQuestion(input);

        verify(this.question, times(1)).setQuestion(anyString());

    }
}
