package com.codegym.dto.contract.sub;

import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class ContractDetailDto {
    private Long id;
    private AttachFacility attachFacility;
    private Contract contract;
    private int quantity;
}
