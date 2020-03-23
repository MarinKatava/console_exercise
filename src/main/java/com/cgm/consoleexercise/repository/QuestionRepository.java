package com.cgm.consoleexercise.repository;

import com.cgm.consoleexercise.domain.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findByQuestion(String question);
}
