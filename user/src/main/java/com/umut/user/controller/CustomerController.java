package com.umut.user.controller;

import com.umut.user.model.CreateCustomerRequest;
import com.umut.user.model.CustomerDto;
import com.umut.user.model.Status;
import com.umut.user.model.UpdateCustomerRequest;
import com.umut.user.service.CustomerService;
import com.umut.user.specification.CustomerSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDto> getCustomers(Status status, String name) {
        return customerService.getCustomers(status, name);
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public CustomerDto createCustomer(@RequestBody CreateCustomerRequest request) {
        return customerService.createCustomer(request);
    }

    @PatchMapping("{id}")
    public CustomerDto updateCustomer(@PathVariable Long id, @RequestBody UpdateCustomerRequest request) {
        return customerService.updateCustomer(id, request);
    }

    @PatchMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

}
