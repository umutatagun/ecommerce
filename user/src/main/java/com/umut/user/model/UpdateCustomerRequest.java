package com.umut.user.model;

import com.umut.user.entity.Address;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class UpdateCustomerRequest{
        private String name;
        private String surname;
        private LocalDate birthDate;
        private String email;
        private String phoneNumber;
        private String password;
        private Status status;
        private Address address;
}
