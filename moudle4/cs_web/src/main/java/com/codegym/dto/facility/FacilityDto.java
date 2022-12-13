package com.codegym.dto.facility;

import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@Builder
@AllArgsConstructor
@Getter
@FieldDefaults(makeFinal = true)
public class FacilityDto {
    private Integer id;
    @NotNull(message = "{error_name_blank}")
    @Pattern(regexp="^[\\p{L}1-9][ \\p{L}1-9]*[\\p{L}1-9]$",message = "{error_name_regex}")
    @NotBlank(message = "{error_name_blank}")
    @NotEmpty(message = "{error_name_blank}")
    @Size(min = 5,message = "{error_name_size}",max = 45)
    private String name;
    @Min(value = 100,message = "{error_area}")
    @Max(value = 250,message="{error_area}")
    @NotNull(message = "{error_area}")
    private int area;
    @DecimalMin(value = "100000.0",message = "{error_cost}")
    @DecimalMax(value = "100000000.0",message = "{error_cost}")
    private double cost;
    @Min(value = 1,message = "{error_maxPeople}")
    @Max(value = 25,message="{error_maxPeople}")
    @NotNull(message = "{error_maxPeople}")
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