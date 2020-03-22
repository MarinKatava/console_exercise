package com.cgm.consoleexercise.unit.service;

import com.cgm.consoleexercise.domain.model.Question;
import com.cgm.consoleexercise.service.InputService;
import com.cgm.consoleexercise.service.QuestionService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class InputServiceTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(this.outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(this.originalOut);
    }

    @InjectMocks
    private InputService inputService;

    @Mock
    private QuestionService questionService;

    @Mock
    private Question question;

    @Test
    public void analyzeAddingChoice() {
        this.inputService.analyzeChoice(1);
        assertEquals("Enter question and answers in format: <question>? “<answer1>” “<answer2>” “<answerX>\n", this.outContent.toString());
    }

    @Test
    public void analyzeGettingChoice() {
        this.inputService.analyzeChoice(2);
        assertEquals("Enter question to get answers\n", this.outContent.toString());
    }

    @Test
    public void analyzeInputOne() {
        when(this.questionService.setQuestionBuilder(any())).thenReturn(this.questionService);
        doNothing().when(this.questionService).addQuestion(anyString());

        this.inputService.analyzeInput(1, "");

        verify(this.questionService, times(1)).setQuestionBuilder(any());
        verify(this.questionService, times(1)).addQuestion(anyString());
    }

    @Test
    public void analyzeInputTwoWhenQuestionNotNull() {
        when(this.questionService.getQuestion(any())).thenReturn(this.question);
        when(this.question.getAnswers()).thenReturn(new LinkedHashSet<>());

        this.inputService.analyzeInput(2, "");

        verify(this.questionService, times(1)).getQuestion(anyString());
        verify(this.question, times(1)).getAnswers();
    }

    @Test
    public void analyzeInputTwoWhenQuestionIsNull() {
        when(this.questionService.getQuestion(any())).thenReturn(null);

        this.inputService.analyzeInput(2, "");

        verify(this.questionService, times(1)).getQuestion(anyString());
        verify(this.question, times(0)).getAnswers();
        assertEquals("The answer to life, universe and everything is 42\n", this.outContent.toString());
    }
}
