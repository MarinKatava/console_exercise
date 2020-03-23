package com.cgm.consoleexercise.unit.service;

import com.cgm.consoleexercise.domain.builder.QuestionBuilder;
import com.cgm.consoleexercise.domain.model.Question;
import com.cgm.consoleexercise.repository.QuestionRepository;
import com.cgm.consoleexercise.service.QuestionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class QuestionServiceTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    private QuestionService questionService;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private Question question;

    @Mock
    private QuestionBuilder questionBuilder;

    @Test
    public void addQuestion() {
        when(this.questionBuilder.setAnswerBuilder(any())).thenReturn(this.questionBuilder);
        when(this.questionBuilder.buildQuestion(any())).thenReturn(this.questionBuilder);
        when(this.questionBuilder.getQuestion()).thenReturn(this.question);

        this.questionService.addQuestion(" ");

        verify(this.questionRepository, times(1)).save(any());
    }

    @Test
    public void getQuestion(){
        String input = "input";
        this.questionService.getQuestion(input);

        verify(this.questionRepository, times(1)).findByQuestion(input);
    }
}
