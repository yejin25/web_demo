package com.example.demo.controller;

import com.example.demo.DTO.MarkerDTO;
import com.example.demo.enumerate.RegionCode;
import com.example.demo.service.RegionService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.regions.RegionMetadata;
import software.amazon.awssdk.regions.internal.util.EC2MetadataUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequiredArgsConstructor
public class MainController {

    @NonNull
    private final RegionService regionService;

    @RequestMapping("/")
    public String indexPage(Model model) {

        String region = EC2MetadataUtils.getEC2InstanceRegion();
        String regionName = ""; // ex) Asia Pacific (Tokyo)
        String regionCode = "";

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
        List<String> allRegion = regionService.findAllRegionName();

        model.addAttribute("currentRegion", regionMetadata.description());
        model.addAttribute("markerList", markerList);
        model.addAttribute("regionForLine", anotherRegion);
        model.addAttribute("allRegion", allRegion);

        return "index";
    }
}
