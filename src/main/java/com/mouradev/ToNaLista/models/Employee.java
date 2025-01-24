package com.mouradev.ToNaLista.models;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "employee_type", length = 50)
    private String employeeType;

    @Column(name = "cpf", length = 11, nullable = true)
    private String cpf;

    @Column(name = "cnpj", length = 14, nullable = true)
    private String cnpj;

    @Column(name = "razao_social", nullable = true)
    private String razaoSocial;

    @Column(name = "assignment", length = 100)
    private String assignment;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Schedule> schedules;

    @Column(name = "turn", length = 50)
    private String turn;

    @Column(name = "salary", nullable = true)
    private Double salary;

    @Column(name = "salary_hour", nullable = true)
    private Double salaryHour;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
