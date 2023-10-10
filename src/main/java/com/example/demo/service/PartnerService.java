package com.example.demo.service;

import com.example.demo.models.Partner;
import com.example.demo.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerService {

    @Autowired
    PartnerRepository partnerRepository;

    public Partner createPartner() {
        return this.partnerRepository.save(null);
    }
}
