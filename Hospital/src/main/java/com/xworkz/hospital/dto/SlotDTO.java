package com.xworkz.hospital.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class SlotDTO {

    private int id;

    private String specialisation;

    private String fromTime;

    private String toTime;
}

