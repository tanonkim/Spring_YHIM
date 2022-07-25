package com.example.yhim.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class PhotoDto {
    private String originFileName;
    private String filePath;
    private Long fileSize;

    @Builder
    public PhotoDto(String originFileName, String filePath, Long fileSize){
        this.originFileName = originFileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }
}
