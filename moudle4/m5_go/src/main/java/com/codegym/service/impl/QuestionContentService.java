package com.codegym.service.impl;

import com.codegym.model.QuestionContent;
import com.codegym.model.QuestionType;
import com.codegym.repository.QuestionContentRepository;
import com.codegym.repository.QuestionTypeRepository;
import com.codegym.service.IQuestionContentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionContentService implements IQuestionContentService {
    private final QuestionContentRepository questionContentRepository;
    private final QuestionTypeRepository questionTypeRepository;

    public QuestionContentService(QuestionContentRepository questionContentRepository,
                                  QuestionTypeRepository questionTypeRepository) {
        this.questionContentRepository = questionContentRepository;
        this.questionTypeRepository = questionTypeRepository;
    }

    @Override
    public Page<QuestionContent> findByTitleContainingAndQuestionType(String title, QuestionType questionType, Pageable pageable) {
        return questionContentRepository.findByTitleContainingAndQuestionType(title, questionType, pageable);
    }

    @Override
    public Page<QuestionContent> findByTitleContaining(String title, Pageable pageable) {
        return questionContentRepository.findByTitleContaining(title, pageable);
    }

    @Override
    public void save(QuestionContent questionContent) {
        questionContentRepository.save(questionContent);
    }

    @Override
    public void deleteById(int id) {
        questionContentRepository.deleteById(id);
    }

    @Override
    public QuestionContent findById(int id) {
        if (questionContentRepository.findById(id).isPresent()) {
            return questionContentRepository.findById(id).get();
        }
        return QuestionContent.builder().build();
    }
}
