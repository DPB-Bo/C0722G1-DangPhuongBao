package com.codegym.model.contract;

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
@SQLDelete(sql = "UPDATE attach_facility SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "nvarchar(45)")
    private String name;
    private double cost;
    @Column(columnDefinition = "nvarchar(10)")
    private String unit;
    @Column(columnDefinition = "nvarchar(45)")
    private String status;
    @Column(columnDefinition = "boolean default false")
    private boolean deleted = false;
}
