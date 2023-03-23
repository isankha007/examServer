package com.exam.service.impl;

import com.exam.entity.exam.Quiz;
import com.exam.repository.QuizRepository;
import com.exam.service.QuizService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return quizRepository.findById(quizId).orElseThrow();
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizes() {
        return new HashSet<>(quizRepository.findAll());
    }

    @Override
    @Transactional
    public void deleteQuiz(Long quizId) {
            //quizRepository.deleteById(quizId);
            quizRepository.deleteByQid(quizId);
    }
}
