package com.bank.accounts.controller;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @GetMapping("sayHello")
    public String hello(){
        return "Hello E veryOne";
    }
    /*
    hi saurabh
     */
}
