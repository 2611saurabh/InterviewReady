package com.bank.accounts.dto;


import lombok.Data;

@Data
public class CustomerDetailsDTO {

    private String name;
    private String email;
    private String mobileNumber;

    private AccountsDTO accountsDTO;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public AccountsDTO getAccountsDTO() {
        return accountsDTO;
    }

    public void setAccountsDTO(AccountsDTO accountsDTO) {
        this.accountsDTO = accountsDTO;
    }
}
