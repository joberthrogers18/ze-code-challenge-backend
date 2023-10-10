package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BodyPartnerCreation {

    private Long id;

    private String tradingName;

    private String document;

    private CoverageAreaBody coverageArea;

    private AddressBody address;

}
