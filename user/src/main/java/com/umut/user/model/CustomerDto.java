package com.umut.user.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class CustomerDto{
        private Long id;
        private String name;
        private String surname;
        private LocalDate birthDate;
        private String email;
        private String phoneNumber;
        private Status status;
        private List<AddressDto> addresses;
}
