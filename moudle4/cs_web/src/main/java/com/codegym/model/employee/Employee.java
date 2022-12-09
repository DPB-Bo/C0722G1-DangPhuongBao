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
@SQLDelete(sql = "UPDATE employee SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "nvarchar(45)")
    private String name;
    @Column(columnDefinition = "date")
    private String dateOfBirth;
    @Column(columnDefinition = "nvarchar(45)")
    private String idCard;
    private double salary;
    @Column(columnDefinition = "nvarchar(45)")
    private String phoneNumber;
    @Column(columnDefinition = "nvarchar(45)")
    private String email;
    @Column(columnDefinition = "nvarchar(45)")
    private String address;
    @ManyToOne
    private Position position;
    @ManyToOne
    private EducationDegree educationDegree;
    @ManyToOne
    private Division division;
    @Column(columnDefinition = "boolean default false")
    private boolean deleted = false;
}