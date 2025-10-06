package com.xworkz.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ImageDTO {

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
