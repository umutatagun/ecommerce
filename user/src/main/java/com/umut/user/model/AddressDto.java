package com.umut.user.model;

import lombok.Data;

@Data
public class AddressDto {
    private String street;
    private String city;
    private String country;
    private String postalCode;
}
