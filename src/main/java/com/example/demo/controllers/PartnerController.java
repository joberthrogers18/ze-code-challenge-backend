package com.example.demo.controllers;

import com.example.demo.dto.BodyPartnerCreation;
import com.example.demo.dto.ResponseRequest;
import com.example.demo.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/partner")
public class PartnerController {

    @Autowired
    PartnerService partnerService;

    @PostMapping("")
    public ResponseEntity<ResponseRequest> createPartner(@RequestBody BodyPartnerCreation partnerBody) {
        try {
            this.partnerService.createPartner(partnerBody);

            ResponseRequest response = ResponseRequest
                    .builder()
                    .message("Partner created successfully")
                    .data(null)
                    .build();

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        }catch (Exception e) {
            ResponseRequest response = ResponseRequest
                    .builder()
                    .message("Error while created partner")
                    .data(e.getMessage())
                    .build();

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }
    }

}
