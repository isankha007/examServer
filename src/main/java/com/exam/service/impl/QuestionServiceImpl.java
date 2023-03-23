package com.exam.service.impl;

import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import com.exam.repository.QuestionRepository;
import com.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;




    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question getQuestion(Long questionId) {
        return questionRepository.findById(questionId).get();
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return  new HashSet<>(questionRepository.findAll());
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
    }
}
