package com.codegym.model.contract;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
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
@SQLDelete(sql = "UPDATE contract SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "DATETIME")
    private String startDate;
    @Column(columnDefinition = "DATETIME")
    private String endDate;
    private double deposit;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Facility facility;
    @Column(columnDefinition = "boolean default false")
    private boolean deleted = false;
    @OneToMany(mappedBy = "contract")
    @JsonBackReference
    private Set<ContractDetail> contractDetails;
}
