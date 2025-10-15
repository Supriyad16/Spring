package com.xworkz.hospital.dto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class PatientImageDTO {

    private String originalImageName;
    private String savedName;
    private String fileType;
    private long fileSize;
    private String filePath;
    private Timestamp dateTime;
    private String createdBy;
    private Timestamp createdAt;
    private String updatedBy;
    private Timestamp updatedAt;
}
