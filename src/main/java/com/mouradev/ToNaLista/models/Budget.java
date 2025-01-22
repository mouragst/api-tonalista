package com.mouradev.ToNaLista.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "budget")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "total_value")
    private Double totalValue;

    @Column(name = "value_remaining")
    private Double valueRemaining;

    @Column(name = "description")
    private String description;
}
