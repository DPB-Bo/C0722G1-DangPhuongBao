package com.codegym.dto.facility;

import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@AllArgsConstructor
@Getter
@FieldDefaults(makeFinal = true)
public class FacilityDto {
    private Integer id;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private FacilityType facilityType;
    private RentType rentType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;
    private String facilityFree;
    private boolean deleted = false;
}