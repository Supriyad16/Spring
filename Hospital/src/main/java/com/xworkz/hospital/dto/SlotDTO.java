package com.xworkz.hospital.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class SlotDTO {

    public int id;

    private String specialisation;

    private String fromTime;

    private String toTime;

}