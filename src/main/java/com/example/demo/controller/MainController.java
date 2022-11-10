package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.regions.RegionMetadata;
import software.amazon.awssdk.regions.internal.util.EC2MetadataUtils;
import software.amazon.awssdk.regions.providers.DefaultAwsRegionProviderChain;

@Controller
@RequiredArgsConstructor
public class MainController {

    @RequestMapping("/")
    public ModelAndView indexPage() {

     //   var regionProvider = DefaultAwsRegionProviderChain.builder().build();
    //    var region = regionProvider.getRegion();

    //    String currentRegion = region.toString().substring(0, region.toString().length() -1);

   //     RegionMetadata regionMetadata = RegionMetadata.of(Region.of(currentRegion));
        ModelAndView modelAndView = new ModelAndView("index");
            String currentRegion = EC2MetadataUtils.getEC2InstanceRegion();

//            if(currentRegion != null) {
//                modelAndView.addObject("currentRG",currentRegion);
//            }

        modelAndView.addObject("currentRG", currentRegion);
    //    System.out.println(Region.of(regionMetadata.description()));

        return modelAndView;
    }
}
