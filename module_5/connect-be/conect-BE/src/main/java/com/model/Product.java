package com.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE cinema SET deleted = true WHERE id=?")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer proId;
    private String productName;
    private String origin;
    private String unit;
    private Double price;
    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private Set<Consignment> consignments;
}
