package com.example.yhim.service;

import com.example.yhim.domain.Facilities;
import com.example.yhim.domain.FacilitiesRepository;
import com.example.yhim.domain.HomeRepository;
import com.example.yhim.dto.HomeSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HomeService {
    private final HomeRepository homeRepository;
    private final FacilitiesRepository facilitiesRepository;

    // 숙소 저장
    public Long save(HomeSaveRequestDto form){
        return homeRepository.save(form.toEntity()).getId();
    }

    // 편의 시설 목록 불러오기
    public List<Facilities> findAllFacilities(){
        return  facilitiesRepository.findAll();
    }
}
