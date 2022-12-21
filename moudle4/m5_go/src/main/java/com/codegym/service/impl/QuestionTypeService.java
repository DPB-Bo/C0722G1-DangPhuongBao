package com.codegym.service.impl;

import com.codegym.model.QuestionType;
import com.codegym.repository.QuestionTypeRepository;
import com.codegym.service.IQuestionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    private final QuestionTypeRepository questionTypeRepository;

    public QuestionTypeService(QuestionTypeRepository questionTypeRepository) {
        this.questionTypeRepository = questionTypeRepository;
    }

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public QuestionType findById(int id) {
        if (questionTypeRepository.findById(id).isPresent()) {
            return questionTypeRepository.findById(id).get();
        }
        return QuestionType.builder().build();
    }
}
