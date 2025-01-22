package com.mouradev.ToNaLista.models;

import java.time.LocalDateTime;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "notificate_at")
    private LocalDateTime notificateAt;

    @Column(name = "show_to_customer")
    private boolean showToCustomer;

    @Column(name = "customer_responsability")
    private boolean customerResponsability;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "status", length = 50)
    private String status;

}
