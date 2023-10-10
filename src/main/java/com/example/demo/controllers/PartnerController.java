package com.example.demo.controllers;

import com.example.demo.dto.BodyPartnerCreation;
import com.example.demo.dto.ResponseRequest;
import com.example.demo.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/partner")
public class PartnerController {

    @Autowired
    PartnerService partnerService;

    @PostMapping("")
    public ResponseRequest createPartner(@RequestBody BodyPartnerCreation partnerBody) {
        try {
            this.partnerService.createPartner(partnerBody);

            return ResponseRequest
                    .builder()
                    .message("Partner created successfully")
                    .data(null)
                    .build();
        }catch (Exception e) {
            return ResponseRequest
                    .builder()
                    .message("Error while created partner")
                    .data(e.getMessage())
                    .build();
        }
    }

}
