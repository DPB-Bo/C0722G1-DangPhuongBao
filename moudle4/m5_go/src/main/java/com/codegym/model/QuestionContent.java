package com.codegym.model;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE question_content SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class QuestionContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "{error_empty}")
    @Size(message = "{error_title_size}", min = 5, max = 100)
    private String title;
    @NotEmpty(message = "error_empty")
    @Size(message = "error_content_size", min = 10, max = 500)
    private String content;

    private String answer;
    @ManyToOne
    private QuestionType questionType;

    @Column(columnDefinition = "DATETIME")
    private String date_create;

    private boolean status = false;
    @Column(columnDefinition = "boolean default false")
    private boolean deleted = false;
}
