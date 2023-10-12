package com.example.demo.service;

import com.example.demo.dto.BodyPartnerCreation;
import com.example.demo.models.Partner;
import com.example.demo.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerService {

    @Autowired
    PartnerRepository partnerRepository;

    public void createPartner(BodyPartnerCreation partnerBody) {

        Partner partner = Partner.builder()
                .tradingName(partnerBody.getTradingName())
                .document(partnerBody.getDocument())
                .ownerName(partnerBody.getOwnerName())
                .coverageArea(partnerBody.getCoverageArea().toString())
                .address(partnerBody.getAddress().toString()).build();

        this.partnerRepository.save(partner);
    }

    public List<Partner> getAllPartnerAvailable() {
        return this.partnerRepository.findAll();
    }
}
