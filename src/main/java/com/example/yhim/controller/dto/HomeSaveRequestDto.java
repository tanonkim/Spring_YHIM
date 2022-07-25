package com.example.yhim.controller.dto;

import com.example.yhim.domain.Facilities;
import com.example.yhim.domain.Home;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class HomeSaveRequestDto {
    private String name;
    private String host;
    private String address;
    private String description;
    private int guest;
    private int room;
    private int bed;
    private int bathroom;
    private int price;
    private List<Facilities> facilities = new ArrayList<>();

    @Builder
    public HomeSaveRequestDto(String name, String host, String address, String description, int guest, int room, int bed, int bathroom, int price, List<Facilities> facilities) {
        this.name = name;
        this.host = host;
        this.address = address;
        this.description = description;
        this.guest = guest;
        this.room = room;
        this.bed = bed;
        this.bathroom = bathroom;
        this.price = price;
        this.facilities = facilities;
    }

    public Home toEntity(){
        return Home.builder()
            .name(name)
            .host(host)
            .address(address)
            .description(description)
            .guest(guest)
            .room(room)
            .bed(bed)
            .bathroom(bathroom)
            .price(price)
            .facilities(facilities)
            .build();
    }
}
