package com.exam.service;

import com.exam.entity.exam.Quiz;

import java.util.Set;

public interface QuizService {
     Quiz addQuiz(Quiz quiz);
     Quiz getQuiz(Long quizId);
     Quiz updateQuiz(Quiz quiz);

     Set<Quiz> getQuizes();

     void deleteQuiz(Long quizId);
}
