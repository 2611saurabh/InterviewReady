package com.bank.accounts.mapper;

import com.bank.accounts.dto.AccountsDTO;
import com.bank.accounts.dto.CustomerDetailsDTO;
import com.bank.accounts.entity.Accounts;
import com.bank.accounts.entity.Customer;

public class CustomerMapper {


    public static CustomerDetailsDTO mapToCustomerDto(Customer customer, CustomerDetailsDTO customerDto){
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());

        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDetailsDTO customerDTO, Customer customer){
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setMobileNumber(customerDTO.getMobileNumber());

        return customer;
    }
}
