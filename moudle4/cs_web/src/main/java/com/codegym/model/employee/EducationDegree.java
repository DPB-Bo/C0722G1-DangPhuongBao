package com.codegym.model.employee;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE education_degree SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "nvarchar(45)")
    private String name;
    @Column(columnDefinition = "boolean default false")
    private boolean deleted = false;
}
