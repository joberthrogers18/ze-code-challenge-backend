package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "partner")
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tradingName")
    private String tradingName;

    @Column(name = "ownerName")
    private String ownerName;

    @Column(name = "document")
    private String document;

    @Column(name= "coverageArea")
    private String coverageArea;

    @Column(name="address")
    private String address;
}
