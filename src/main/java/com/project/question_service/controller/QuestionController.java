package com.project.question_service.controller;

import com.project.question_service.model.Question;
import com.project.question_service.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private QuestionService questionService;

    QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    //Generate random Questions for Quiz-service
//    @GetMapping("/generate")
//    public ResponseEntity<List<Question>> generateRandomQuestionByCategory(@RequestParam String Category,Integer numQuestion){
//        return ResponseEntity.ok(questionService.generateRandomQuestionByCategory());
//    }


    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return ResponseEntity.ok(questionService.getAllQuestion());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable Long id){
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }
    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){
        try{
            questionService.addQuestion(question);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "successfully added";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Long id){
        questionService.deleteQuestion(id);
        return "Successfully deleted";
    }

}
