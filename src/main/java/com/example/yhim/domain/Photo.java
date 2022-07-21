package com.example.yhim.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "file")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "home_id")
    private Home home; // 사진 : 숙소  = 다 : 일

    @Column(nullable = false)
    private String orgFileName;

    @Column(nullable = false)
    private String filePath;

    private Long fileSize;

    @Builder
    public Photo(String orgFileName, String filePath, Long fileSize){
        this.orgFileName = orgFileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }

//    public void setHome(Home home){
//        this.home = home;
//
//        // 현재 파일이 Home에 존재하지 않는다면
//        if (!home.getPhoto().contains(this)){
//            home.getPhoto().add(this);
//        }
//    }
}
