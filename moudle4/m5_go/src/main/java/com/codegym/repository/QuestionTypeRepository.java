package com.codegym.repository;

import com.codegym.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionTypeRepository extends JpaRepository<QuestionType, Integer> {
}