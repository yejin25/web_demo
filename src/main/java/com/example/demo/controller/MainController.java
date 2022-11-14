package com.example.demo.controller;

import com.example.demo.DTO.MarkerDTO;
import com.example.demo.enumerate.Coordinate;
import com.example.demo.enumerate.RegionCode;
import com.example.demo.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.regions.RegionMetadata;
import software.amazon.awssdk.regions.internal.util.EC2MetadataUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final RegionService regionService;

    @RequestMapping("/")
    public String indexPage(Model model) {

        String region = EC2MetadataUtils.getEC2InstanceRegion();
        String regionName = ""; // ex) Asia Pacific (Tokyo)
        String regionCode = "";

        List<Double> coordinateList = new ArrayList<>();
        List<MarkerDTO> markerList = regionService.findValueForMarker();


        RegionMetadata regionMetadata = RegionMetadata.of(Region.of(region));

        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(regionMetadata.description());


        if (matcher.find()) {
            regionName = matcher.group(1);
            regionCode = RegionCode.valueOf(regionName).getRegion();
            model.addAttribute("regionName", regionName);
            model.addAttribute("regionCode", regionCode);
        }

        List<String> anotherRegion = regionService.findRGWithoutCurrentRG(regionName);


        coordinateList.add(Coordinate.valueOf(regionCode).getLatitude());   //위도
        coordinateList.add(Coordinate.valueOf(regionCode).getLongitude());  //경도

        model.addAttribute("currentRegion", regionMetadata.description());
        model.addAttribute("markerList", markerList);
        model.addAttribute("regionForLine", anotherRegion);


        return "index";
    }
}
