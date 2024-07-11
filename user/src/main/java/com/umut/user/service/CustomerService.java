package com.umut.user.service;

import com.umut.user.converter.CustomerConverter;
import com.umut.user.entity.Customer;
import com.umut.user.model.CreateCustomerRequest;
import com.umut.user.model.CustomerDto;
import com.umut.user.model.UpdateCustomerRequest;
import com.umut.user.repository.CustomerRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter converter;
    private final ModelMapper mapper;

    public CustomerService(CustomerRepository customerRepository,
                           CustomerConverter converter,
                           ModelMapper mapper) {
        this.customerRepository = customerRepository;
        this.converter = converter;
        this.mapper = mapper;
    }

    public List<CustomerDto> getCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return converter.convert(customers);
    }

    public CustomerDto getCustomerById(Long id) {
        Customer customer = findById(id);

        return converter.convert(customer);
    }

    public CustomerDto createCustomer(CreateCustomerRequest request) {
        if (isExist(request.getEmail())) {
            throw new EntityExistsException("Customer already exists with email: " + request.getEmail());
        }

        Customer customer = customerRepository.save(converter.convert(request));

        return converter.convert(customer);
    }

    public CustomerDto updateCustomer(Long id, UpdateCustomerRequest request) {
        Customer customer = findById(id);
        mapper.map(request, customer);
        return converter.convert(customerRepository.save(customer));
    }

    public void deleteCustomer(Long id) {
        customerRepository.delete(findById(id));
    }

    private Customer findByEmail(String email) {
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with email: " + email));
    }

    private boolean isExist(String email) {
        return customerRepository.findByEmail(email).isPresent();
    }

    private Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
    }

}
