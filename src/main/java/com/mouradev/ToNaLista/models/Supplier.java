package com.mouradev.ToNaLista.models;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cnpj", length = 14)
    private String cnpj;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "inscricao_municipal", length = 15)
    private String inscricaoMunicipal;

    @Column(name = "inscricao_estadual", length = 9)
    private String inscricaoEstadual;

    @Column(name = "cep", length = 8)
    private String cep;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "complement")
    private String complement;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    @Column(name = "uf", length = 2)
    private String uf;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
