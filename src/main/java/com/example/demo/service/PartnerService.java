package com.example.demo.service;

import com.example.demo.dto.BodyPartnerCreation;
import com.example.demo.models.Partner;
import com.example.demo.repository.PartnerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerService {

    @Autowired
    PartnerRepository partnerRepository;

    public void createPartner(BodyPartnerCreation partnerBody) throws JsonProcessingException {

        ObjectMapper mapperObject = new ObjectMapper();

        Partner partner = Partner.builder()
                .tradingName(partnerBody.getTradingName())
                .document(partnerBody.getDocument())
                .ownerName(partnerBody.getOwnerName())
                .coverageArea(
                        mapperObject.writeValueAsString(
                            partnerBody.getCoverageArea()
                    )
                )
                .address(
                        mapperObject.writeValueAsString(
                            partnerBody.getAddress()
                    )
                )
                .build();

        this.partnerRepository.save(partner);
    }

    public List<Partner> getAllPartnerAvailable() {
        return this.partnerRepository.findAll();
    }

    public void deleteById(Long id) {
        this.partnerRepository.deleteById(id);
    }

    public Optional<Partner> findById(Long id) {
        return this.partnerRepository.findById(id);
    }
}
