package com.mouradev.ToNaLista.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToOne
    @JoinColumn(name = "companion_id")
    private Guest companion;

    @Column(name = "event_table")
    private String table;

    @Column(name = "annotation")
    private String annotation;

    @Column(name = "gender", length = 15)
    private String gender;

    @Column(name = "age", length = 3)
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "guest_group_id")
    private GuestGroup guestGroup;

    @Column(name = "status", length = 50)
    private String status;

}