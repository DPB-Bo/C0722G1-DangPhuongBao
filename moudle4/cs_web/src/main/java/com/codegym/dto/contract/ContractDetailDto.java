package com.codegym.dto.contract;

import com.codegym.dto.contract.ContractDto;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import lombok.Data;

import java.io.Serializable;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@AllArgsConstructor
@Getter
@FieldDefaults(makeFinal = true)
public class ContractDetailDto implements Serializable {
    private Integer id;
    private Contract contract;
    private AttachFacility attachFacility;
    private int quantity;
    private boolean deleted;
}