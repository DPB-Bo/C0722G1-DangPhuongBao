package com.codegym.ex_1.model;

import lombok.*;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String author;
    private String date;
    @ManyToOne
    private Category category;
    private boolean deleted;
}
