package com.project.question_service.Dao;

import com.project.question_service.model.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {

    @Query(value = "SELECT * FROM question WHERE question.category = :category ORDER BY RANDOM() LIMIT :numQ",
            nativeQuery = true)
    List<Question> findRandomQuestionByCategory(@Param("category") String category,
                                                @Param("numQ") int numQ);
}
