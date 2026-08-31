package com.project.question_service.service;

import com.project.question_service.Dao.QuestionDao;
import com.project.question_service.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionDao questionDao;
    QuestionService(QuestionDao questionDao){
        this.questionDao=questionDao;
    }

    public List<Question> getAllQuestion(){
        return questionDao.findAll();
    } 
    public Optional<Question> getQuestionById( Long id){
        return questionDao.findById(id);
    }

    public void addQuestion(Question question) {
        Question question1= new Question();
        question1.setQuestiontitle(question.getQuestiontitle());
        question1.setId(question.getId());
        question1.setOption1(question.getOption1());
        question1.setOption2(question.getOption2());
        question1.setOption3(question.getOption3());
        question1.setOption4(question.getOption4());
        question1.setCategory(question.getCategory());
        question1.setDifficultylevel(question.getDifficultylevel());
        question1.setRightanswer(question.getRightanswer());
        try{
            questionDao.save(question1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteQuestion(Long id) {
        try {
            questionDao.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
