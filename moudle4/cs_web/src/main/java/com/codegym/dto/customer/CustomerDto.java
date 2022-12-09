package com.codegym.dto.customer;

import java.io.Serializable;

import com.codegym.model.customer.CustomerType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

@FieldDefaults(makeFinal = true)
@Builder
@AllArgsConstructor
@Getter
public class CustomerDto implements Serializable, Validator {
    private Integer id;
    private CustomerType customerType;
    @NotNull(message = "{error_name_blank}")
    @Pattern(regexp="^\\p{L}[ \\p{L}]*\\p{L}$",message = "{error_name_regex}")
    @NotBlank(message = "{error_name_blank}")
    @NotEmpty(message = "{error_name_blank}")
    @Size(min = 5,message = "{error_name_size}",max = 45)
    private String name;
    private String dateOfBirth;
    private boolean gender=true;
    @NotNull(message = "{error_id_card}")
    @Pattern(regexp="[0-9]{9,11}",message = "{error_id_card}")
    @NotBlank(message = "{error_id_card}")
    @NotEmpty(message = "{error_id_card}")
    private String idCard;
    @NotNull(message = "{error_phone_number}")
    @Pattern(regexp="[0-9]{9,11}",message = "{error_phone_number}")
    @NotBlank(message = "{error_phone_number}")
    @NotEmpty(message = "{error_phone_number}")
    private String phoneNumber;
    @Email(message = "{error_email}")
    private String email;
    @NotNull(message = "{error_address}")
    @NotBlank(message = "{error_address}")
    @NotEmpty(message = "{error_address}")
    private String address;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    @Override
    public void validate(Object target, Errors errors) {
    }
}