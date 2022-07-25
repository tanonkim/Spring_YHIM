package com.example.yhim.controller;

import com.example.yhim.domain.Facilities;
import com.example.yhim.domain.Home;
import com.example.yhim.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class IndexController {

    private final HomeService homeService;

    // Main
    @GetMapping("/home")
    @ResponseStatus(HttpStatus.OK)
    public List<Home> index(Model model){

        model.addAttribute("homes", homeService.findAll());
        return homeService.findAll();
    }

    @GetMapping("/facilities")
    @ResponseStatus(HttpStatus.OK)
    public List<Facilities> homeAdd(Model model){
        model.addAttribute("facilities", homeService.findAllFacilities());
        return homeService.findAllFacilities();

    }

    // 숙소 수정 페이지로 이동
    @GetMapping("/home/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String homeDelete(@PathVariable long id, Model model) {

        // 수정할 숙소 불러오기
        model.addAttribute("home", homeService.findById(id));

        return "home/edit";
    }
}
