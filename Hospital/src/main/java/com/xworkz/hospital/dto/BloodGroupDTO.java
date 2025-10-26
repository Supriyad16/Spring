package com.xworkz.hospital.dto;


import lombok.*;

import javax.mail.Message;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class BloodGroupDTO {


    @NotNull(message="Blood group should not be null")
        private String bloodGroup;
    }



