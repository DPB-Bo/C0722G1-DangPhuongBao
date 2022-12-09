package com.codegym.model.facility;

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
@SQLDelete(sql = "UPDATE facility SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "nvarchar(45)")
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    @ManyToOne
    private FacilityType facilityType;
    @ManyToOne
    private RentType rentType;
    @Column(columnDefinition = "nvarchar(45)")
    private String standardRoom;
    @Column(columnDefinition = "nvarchar(45)")
    private String description_other_convenience;
    private Double poolArea;
    private Integer numberOfFloors;
    @Column(columnDefinition = "TEXT")
    private String facility_free;
    @Column(columnDefinition = "boolean default false")
    private boolean deleted = false;
}
