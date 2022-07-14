package com.example.yhim.dto;

import com.example.yhim.domain.Home;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HomeSaveRequestDto {
    private String name;
    private String host;
    private String address;
    private String photo;
    private String description;
    private int guest;
    private int room;
    private int bed;
    private int bathroom;

    @Builder
    public HomeSaveRequestDto(String name, String host, String address, String photo, String description, int guest, int room, int bed, int bathroom) {
        this.name = name;
        this.host = host;
        this.address = address;
        this.photo = photo;
        this.description = description;
        this.guest = guest;
        this.room = room;
        this.bed = bed;
        this.bathroom = bathroom;
    }

    public Home toEntity(){
        return Home.builder()
            .name(name)
            .host(host)
            .address(address)
            .photo(photo)
            .description(description)
            .guest(guest)
            .room(room)
            .bed(bed)
            .bathroom(bathroom)
            .build();
    }
}
