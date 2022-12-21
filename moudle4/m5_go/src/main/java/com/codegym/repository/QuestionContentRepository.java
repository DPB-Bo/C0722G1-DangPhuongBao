package com.codegym.repository;

import com.codegym.model.QuestionContent;
import com.codegym.model.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionContentRepository extends JpaRepository<QuestionContent, Integer> {
    Page<QuestionContent> findByTitleContainingAndQuestionType(String title, QuestionType questionType, Pageable pageable);

    Page<QuestionContent> findByTitleContaining(String title, Pageable pageable);
}