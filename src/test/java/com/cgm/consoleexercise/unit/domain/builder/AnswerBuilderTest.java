package com.cgm.consoleexercise.unit.domain.builder;

import com.cgm.consoleexercise.domain.builder.AnswerBuilder;
import com.cgm.consoleexercise.domain.model.Answer;
import com.cgm.consoleexercise.domain.model.Question;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AnswerBuilderTest {

    private AnswerBuilder spy;
    private Set<Answer> answers;
    private Question question;

    @Before
    public void setUp() {
        this.answers = new LinkedHashSet<>();
        this.question = new Question();

        this.spy = Mockito.spy(new AnswerBuilder(this.answers, null));
    }


    @Test
    public void buildAnswersWithLettersOnly(){
        this.spy.buildAnswers("\"Me\" \"You\"");
        assertEquals(this.answers.size(), 2);
    }

    @Test
    public void buildAnswersWithNumbers(){
        this.spy.buildAnswers("\"123 Me\" \"543 You\" \"They\"");
        assertEquals(this.answers.size(), 3);
    }

//    TODO: cover all other cases

}
