package com.example.yhim.service;

import com.example.yhim.controller.FileHandler;
import com.example.yhim.domain.*;
import com.example.yhim.controller.dto.HomeModifyRequestDto;
import com.example.yhim.controller.dto.HomeSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
@RestController
public class HomeService {

    private final HomeRepository homeRepository;
    private final FacilitiesRepository facilitiesRepository;
    private final FileHandler fileHandler;
    private final PhotoRepository photoRepository;

    public List<Home> findAll(){
        return homeRepository.findAll();
    }

    // 숙소 저장
    @Transactional
    public Long save(HomeSaveRequestDto requestDto, List<MultipartFile> files)
        throws Exception {
            // 파일 처리를 위한 Home 객체 생성
            Home home = requestDto.toEntity();

            List<Photo> photoList = fileHandler.parseFileInfo(files);

            if(!photoList.isEmpty()){
                for(Photo photo : photoList)
                    // 파일을 DB에 저장
                    home.addPhoto(photoRepository.save(photo));
            }
            return homeRepository.save(home).getId();
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
    @Transactional
    public void delete(long id) {
        homeRepository.deleteById(id);
    }

    // 숙소 수정
    @Transactional
    public String modify(long id, HomeModifyRequestDto form) {

        // 수정할 숙소를 id로 찾기
        Home home = homeRepository.findById(id).get();

        home.update(form.getName(), form.getHost(), form.getAddress(), form.getPhoto(),
                form.getDescription(), form.getGuest(), form.getRoom(), form.getBed(),
                form.getBathroom(), form.getFacilities());
        return "redirect:/home";
    }
}
