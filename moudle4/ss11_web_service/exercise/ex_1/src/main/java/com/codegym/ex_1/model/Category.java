package com.codegym.ex_1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.Set;

@Entity
@SQLDelete(sql = "UPDATE category SET deleted = false WHERE id = ?")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private Set<Blog> blogs;
    @Column(columnDefinition = "boolean default false")
    private boolean deleted = false;
}
