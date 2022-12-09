package com.codegym.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

@FieldDefaults(makeFinal = true)
@Builder
@AllArgsConstructor
@Getter
public class UserDto implements Validator{
    @NotNull(message = "{error_name_blank}")
    @Pattern(regexp="^[\\p{L}'][ \\p{L}'-]*\\p{L}$",message = "{error_name_regex}")
    @NotBlank(message = "{error_name_blank}")
    @NotEmpty(message = "{error_name_blank}")
    @Size(min = 5,message = "{error_name_size}",max = 45)
    private String firstName;

    @NotNull(message = "{error_name_blank}")
    @Pattern(regexp="[a-zA-z]+",message = "{error_name_regex}")
    @NotBlank(message = "{error_name_blank}")
    @NotEmpty(message = "{error_name_blank}")
    @Size(min = 2,message = "{error_name_size}",max = 45)
    private String lastName;

    @NotNull(message = "{error_name_blank}")
    @Pattern(regexp="[0-9]{9,11}",message = "{error_name_regex}")
    @NotBlank(message = "{error_name_blank}")
    @NotEmpty(message = "{error_name_blank}")
    private String phoneNumber;

    @Min(value = 18,message = "{error_age}")
    @Max(value = 90,message = "{error_age}")
    private Integer age;

    @Email(message = "{error_email}")
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
