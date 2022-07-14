package com.example.yhim.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Facilities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

}
