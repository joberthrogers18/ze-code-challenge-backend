package com.example.demo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressBody {

    private String type;

    private List<Double> coordinates;

}
