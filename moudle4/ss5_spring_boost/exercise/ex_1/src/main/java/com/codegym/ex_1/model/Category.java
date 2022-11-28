package com.codegym.ex_1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.Set;

@Entity
@SQLDelete(sql = "UPDATE category SET deleted = false WHERE id = ?")
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
    private Set<Blog> blogs;
    @Column(columnDefinition = "boolean default false")
    private Boolean deleted = false;
}
