package com.example.yhim.controller;

import com.example.yhim.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class IndexController {

    private HomeService homeService;

    // Main
    @GetMapping("/")
    public String index(){
        return "Main Page";
    }

    @GetMapping("/home")
    public String homeAdd(Model model){
        model.addAttribute("facilities", homeService.findAllFacilities());
        return "home/add";

    }
}
