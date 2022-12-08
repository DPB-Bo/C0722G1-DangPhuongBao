package com.codegym.model.customer;

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
@SQLDelete(sql = "UPDATE customer_type SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "nvarchar(45)")
    private String name;

    // 2 cách set default là :

    //C1:
    //@Column(columnDefinition = "boolean default false")

    //C2:
    private boolean deleted = false;
}
