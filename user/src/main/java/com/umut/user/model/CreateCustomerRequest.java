package com.umut.user.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateCustomerRequest {
        private String name;
        private String surname;
        private LocalDate birthDate;
        private String email;
        private String phoneNumber;
        private String password;
}
