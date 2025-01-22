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

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "cnpj", length = 14)
    private String cnpj;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "assignment", length = 100)
    private String assignment;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Schedule> schedules;

    @Column(name = "turn", length = 50)
    private String turn;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "salary_hour")
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
