package com.exam.controller;


import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;


    @PostMapping("/")
    public ResponseEntity<?> addQuestion(@RequestBody Question question){
        Question question1 = this.questionService.addQuestion(question);
        return new ResponseEntity<>(question1, HttpStatus.CREATED);
    }

    @GetMapping("/{quesId}")
    public ResponseEntity<?> getQuestion(@PathVariable("quesId") Long quesId){
        Question question1 = this.questionService.getQuestion(quesId);
        return new ResponseEntity<>(question1, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getQuestions(){
        Set<Question> question = this.questionService.getQuestions();
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateCategory(@RequestBody Question question){
        Question question1 = this.questionService.updateQuestion(question);
        return new ResponseEntity<>(question1, HttpStatus.OK);
    }

    @DeleteMapping("/{quesId}")
    public ResponseEntity<?> deleteCategory(@PathVariable("quesId") Long quesId){
        this.questionService.deleteQuestion(quesId);
        return ResponseEntity.ok("Deleted");
    }

    ///get all question of any quiz
    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable Long quizId){
        Quiz quiz=quizService.getQuiz(quizId);
        Set<Question> questionSet = quiz.getQuestionSet();
        List<Question> list= new ArrayList<>(questionSet);
        if(list.size()>quiz.getNumberOfQuestion()){
            list=list.subList(0, quiz.getNumberOfQuestion()+1);
        }
        Collections.shuffle(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
