package com.codegym.model.customer;

import com.codegym.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE customer SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private CustomerType customerType;
    @Column(columnDefinition = "nvarchar(45)")
    private String name;
    @Column(columnDefinition = "date")
    private String dateOfBirth;
    private boolean gender;
    @Column(columnDefinition = "nvarchar(45)")
    private String idCard;
    @Column(columnDefinition = "nvarchar(45)")
    private String phoneNumber;
    @Column(columnDefinition = "nvarchar(45)")
    private String email;
    @Column(columnDefinition = "nvarchar(45)")
    private String address;
    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private Set<Contract> contracts;
    @Column(columnDefinition = "boolean default false")
    private boolean deleted = false;
}
