package com.mouradev.ToNaLista.models;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {

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

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @Column(name = "plan_value")
    private Double planValue;

    @Column(name = "plan_expiration")
    @Temporal(TemporalType.DATE)
    private LocalDate planExpiration;

    @Column(name = "plan_last_payment")
    @Temporal(TemporalType.DATE)
    private LocalDate planLastPayment;

    @Column(name = "plan_discount")
    private Double planDiscount;

    @Transient
    private Double planTotalValue;

    @Column(name = "user_limit")
    private Integer userLimit;

    @Column(name = "cep", length = 8)
    private String cep;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private Integer number;

    @Column(name = "complement")
    private String complement;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    @Column(name = "state", length = 2)
    private String state;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PostLoad
    @PostPersist
    @PostUpdate
    private void updatePlanValue() {
        if (plan != null) {
            this.planValue = plan.getValue();
        }
    }

    @Transient
    public String getPlanTotalValue() {
        try {
            return String.valueOf(planValue - planDiscount);
        } catch (NumberFormatException e) {
            return "0";
        }
    }
}