package com.codegym.model;

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
@SQLDelete(sql = "UPDATE show_time SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class ShowTime {
    @Id
    private String id;
    @ManyToOne
    private Movie movie;
    private String date;
    private Integer tickets;
    private boolean deleted = false;
}
