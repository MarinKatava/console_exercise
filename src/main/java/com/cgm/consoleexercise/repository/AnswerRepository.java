package com.cgm.consoleexercise.repository;

import com.cgm.consoleexercise.domain.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    List<Answer> findAllByQuestionId(Integer id);
}
