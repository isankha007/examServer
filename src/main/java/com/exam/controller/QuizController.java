package com.exam.controller;

import com.exam.entity.exam.Quiz;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;


    @PostMapping("/")
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz){
        Quiz quiz1 = this.quizService.addQuiz(quiz);
        return new ResponseEntity<>(quiz1, HttpStatus.CREATED);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<?> getQuiz(@PathVariable("quizId") Long quizId){
        Quiz quiz = this.quizService.getQuiz(quizId);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getQuizes(){
        Set<Quiz> quizes = this.quizService.getQuizes();
        return new ResponseEntity<>(quizes, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz){
        Quiz quiz1 = this.quizService.updateQuiz(quiz);
        return new ResponseEntity<>(quiz1, HttpStatus.OK);
    }

    @DeleteMapping("/{quizId}")
    public ResponseEntity<?> deleteQuiz(@PathVariable("quizId") Long quizId){
        this.quizService.deleteQuiz(quizId);
        return ResponseEntity.ok("Deleted");
    }

}
