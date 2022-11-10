package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import software.amazon.awssdk.regions.providers.DefaultAwsRegionProviderChain;

@Controller
@RequiredArgsConstructor
public class MainController {

    @RequestMapping("/")
    public ModelAndView indexPage() {

        var regionProvider = DefaultAwsRegionProviderChain.builder().build();
        var region = regionProvider.getRegion();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("currentRG", region);

        System.out.println(region);

        return modelAndView;
    }
}
