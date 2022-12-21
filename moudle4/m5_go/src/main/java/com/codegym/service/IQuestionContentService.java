package com.codegym.service;

import com.codegym.model.QuestionContent;
import com.codegym.model.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionContentService {
    Page<QuestionContent> findByTitleContainingAndQuestionType(String title, QuestionType questionType, Pageable pageable);

    Page<QuestionContent> findByTitleContaining(String title, Pageable pageable);

    void save(QuestionContent questionContent);

    void deleteById(int id);

    QuestionContent findById(int id);
}
