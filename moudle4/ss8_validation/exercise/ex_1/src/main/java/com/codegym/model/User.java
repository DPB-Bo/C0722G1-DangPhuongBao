package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "{error_name_blank}")
    @Pattern(regexp="[a-zA-z]+",message = "{error_name_regex}")
    @NotBlank(message = "{error_name_blank}")
    @NotEmpty(message = "{error_name_blank}")
    @Size(min = 2,message = "{error_name_size}",max = 45)
    private String firstName;

    @NotNull(message = "{error_name_blank}")
    @Pattern(regexp="[a-zA-z]+",message = "{error_name_regex}")
    @NotBlank(message = "{error_name_blank}")
    @NotEmpty(message = "{error_name_blank}")
    @Size(min = 2,message = "{error_name_size}",max = 45)
    private String lastName;

    @NotNull(message = "{error_name_blank}")
    @Pattern(regexp="[a-zA-z]+",message = "{error_name_regex}")
    @NotBlank(message = "{error_name_blank}")
    @NotEmpty(message = "{error_name_blank}")
    @Min(value = 9,message = "{error_phone_number}")
    @Max(message = "{error_phone_number}",value = 11)
    private String phoneNumber;

    @Min(value = 18,message = "{error_age}")
    @Max(value = 90,message = "{error_age}")
    private Integer age;

    @Email(message = "{error_email}")
    private String email;
}