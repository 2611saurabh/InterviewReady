package com.bank.accounts.service;

import com.bank.accounts.dto.CustomerDetailsDTO;

public interface IAccountsService {

    /**
     *
     * @param customerDto - Detatils of CutomerDto Object
     *
     */
    void creatAccount(CustomerDetailsDTO customerDto);

    CustomerDetailsDTO fetchAccount(String mobileNumber);
}
