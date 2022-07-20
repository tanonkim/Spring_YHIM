package com.example.yhim.service;

import com.example.yhim.domain.Facilities;
import com.example.yhim.domain.FacilitiesRepository;
import com.example.yhim.domain.Home;
import com.example.yhim.domain.HomeRepository;
import com.example.yhim.dto.HomeModifyRequestDto;
import com.example.yhim.dto.HomeSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HomeService {
    private final HomeRepository homeRepository;
    private final FacilitiesRepository facilitiesRepository;

    public List<Home> findAll(){
        return homeRepository.findAll();
    }

    // 숙소 저장
    public Long save(HomeSaveRequestDto form){
        return homeRepository.save(form.toEntity()).getId();
    }

    // 편의 시설 목록 불러오기
    public List<Facilities> findAllFacilities(){
        return  facilitiesRepository.findAll();
    }

    // id로 숙소 불러오기
    public Home findById(Long id) {
        return homeRepository.findById(id).get();
    }

    // 숙소 삭제
    public void delete(long id) {
        homeRepository.deleteById(id);
    }

    public void modify(long id, HomeModifyRequestDto form) {

        // 수정할 숙소를 id로 찾기
        Home home = homeRepository.findById(id).get();
        System.out.println("수정 전" + home.getName());

        home.update(form.getName(), form.getHost(), form.getAddress(), form.getPhoto(),
                form.getDescription(), form.getGuest(), form.getRoom(), form.getBed(),
                form.getBathroom(), form.getFacilities());
        System.out.println("수정 후" + home.getName());
    }


}
