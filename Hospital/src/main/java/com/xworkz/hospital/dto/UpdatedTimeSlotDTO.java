package com.xworkz.hospital.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UpdatedTimeSlotDTO {

    private int id;

    @NotNull(message = "Time slot should not be null")
    private String timeSlot;

    @NotNull(message = "Doctor ID should not be null")
    private Integer doctorId;


}
