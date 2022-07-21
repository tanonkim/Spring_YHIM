package com.example.yhim.controller;

import com.example.yhim.domain.VO.HomeFileVO;
import com.example.yhim.dto.HomeModifyRequestDto;
import com.example.yhim.dto.HomeSaveRequestDto;
import com.example.yhim.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@RestController
public class HomeController {

    private final HomeService homeService;

    //@ResponseBody
    @PostMapping("/home")
    public String save(HomeFileVO homeFileVO) throws Exception{
        HomeSaveRequestDto requestDto = HomeSaveRequestDto.builder()
                .name(homeFileVO.getName())
                .host(homeFileVO.getHost())
                .address(homeFileVO.getAddress())
                .description(homeFileVO.getDescription())
                .guest(homeFileVO.getGuest())
                .room(homeFileVO.getRoom())
                .bed(homeFileVO.getBed())
                .bathroom(homeFileVO.getBathroom())
                .facilities(homeFileVO.getFacilities())
                .build();

        homeService.save(requestDto, homeFileVO.getFiles());
        return "redirect:/";
    }

    // 숙소 삭제
    @DeleteMapping("/home/delete/{id}")
    public String delete(@PathVariable long id) {
        homeService.delete(id);
        return "redirect:/home";
    }

    // 숙소 수정
    @Transactional
    @ResponseBody
    @PutMapping("/home/modify/{id}")
    public String modifySave(@PathVariable long id, HomeModifyRequestDto form) {
        return homeService.modify(id,form);
    }
}
