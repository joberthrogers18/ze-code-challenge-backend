package com.example.demo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoverageAreaBody {

    private String type;

    private List<List<List<List<Integer>>>> coordinates;

}
