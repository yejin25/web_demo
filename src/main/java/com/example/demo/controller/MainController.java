package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import software.amazon.awssdk.regions.providers.DefaultAwsRegionProviderChain;

@Controller
@RequiredArgsConstructor
public class MainController {

    @RequestMapping("/")
    public String main() throws InterruptedException {

        var regionProvider = DefaultAwsRegionProviderChain.builder().build();
        var region = regionProvider.getRegion();

        System.out.println(region);

        return "index";
    }
}
