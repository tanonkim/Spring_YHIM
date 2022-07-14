package com.example.yhim.controller;

import com.example.yhim.dto.HomeSaveRequestDto;
import com.example.yhim.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HomeController {

    private final HomeService homeService;

    @PostMapping("/home")
    public Long save(HomeSaveRequestDto form) {
        return homeService.save(form);
    }

}
