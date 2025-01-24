package com.mouradev.ToNaLista.models;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "cep", length = 8)
    private String cep;

    @Column(name = "city")
    private String city;

    @Column(name = "state", length = 2)
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "reference")
    private String reference;

    @Column(name = "annotation")
    private String annotation;

    @Column(name = "qualification", length = 15)
    private String qualification;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
