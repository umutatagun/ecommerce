package com.umut.user.converter;

import com.umut.user.entity.Customer;
import com.umut.user.model.CreateCustomerRequest;
import com.umut.user.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerConverter {
    private final ModelMapper mapper;

    public List<CustomerDto> convert(List<Customer> customers) {
        return customers.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public CustomerDto convert(Customer customer) {
        return mapper.map(customer, CustomerDto.class);
    }

    public Customer convert(CreateCustomerRequest request) {
        return mapper.map(request, Customer.class);
    }
}
