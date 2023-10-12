package com.example.demo.controllers;

import com.example.demo.dto.BodyPartnerCreation;
import com.example.demo.dto.ResponseRequest;
import com.example.demo.models.Partner;
import com.example.demo.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("")
    public ResponseEntity<ResponseRequest> getAllPartners() {
        try {
            List<Partner> partners = this.partnerService.getAllPartnerAvailable();

            return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                    ResponseRequest
                        .builder()
                        .message(null)
                        .data(partners)
                        .build()
                );
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                    ResponseRequest
                        .builder()
                        .message("Error while recover partners")
                        .data(e.getMessage())
                        .build()
                );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseRequest> getPartnerById (
            @PathVariable("id") Long id
    ) {
        try {

            Optional<Partner> partner = this.partnerService.findById(id);

            if (partner.isEmpty()) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(
                                ResponseRequest
                                        .builder()
                                        .message("Partner not exists")
                                        .data(null)
                                        .build()
                        );
            }

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(
                            ResponseRequest
                                    .builder()
                                    .message("Partner deleted successfully")
                                    .data(partner)
                                    .build()
                    );

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(
                            ResponseRequest
                                    .builder()
                                    .message(e.getMessage())
                                    .data(null)
                                    .build()
                    );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseRequest> deletePartner(
        @PathVariable("id") Long id
    ) {
        try {

            Optional<Partner> partner = this.partnerService.findById(id);

            if (partner.isEmpty()) {
                return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(
                        ResponseRequest
                            .builder()
                                .message("Partner not exists")
                                .data(null)
                                .build()
                    );
            }

            this.partnerService.deleteById(id);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(
                            ResponseRequest
                                    .builder()
                                    .message("Partner deleted successfully")
                                    .data(null)
                                    .build()
                    );

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(
                            ResponseRequest
                                    .builder()
                                    .message(e.getMessage())
                                    .data(null)
                                    .build()
                    );
        }
    }

}
