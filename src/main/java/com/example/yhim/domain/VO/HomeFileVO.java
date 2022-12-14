package com.example.yhim.domain.VO;

import com.example.yhim.domain.Facilities;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
public class HomeFileVO {

    private String name;
    private String host;
    private String address;
    private String description;
    private int guest;
    private int room ;
    private int bed;
    private int bathroom;
    private int price;
    private List<Facilities> facilities = new ArrayList<>(); // νΈμμμ€
    private List<MultipartFile> files;
}
