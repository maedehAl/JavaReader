package com.example.JavaReader.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;


@Data
@Entity
@Table(schema = "CUSTOMER")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "CUSTOMER_SURNAME")
    private String customerSurname;

    @Column(name = "CUSTOMER_ADDRESS")
    private String customerAddress;

    @Column(name = "CUSTOMER_ZIP_CODE")
    private String customerZipCode;

    @Column(name = "CUSTOMER_NATIONAL_ID")
    private String customerNationalId;

    @Column(name = "CUSTOMER_BIRTH_DATE")
    private String customerBirthDate;


}
