package com.example.minor_project_1.controllers;

import com.example.minor_project_1.models.TransactionType;
import com.example.minor_project_1.models.User;
import com.example.minor_project_1.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/initiate")
    public String initiateTransaction(@RequestParam("bookId") Integer bookId,
                                      @RequestParam("transactionType") TransactionType transactionType) throws Exception {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        Integer studentId = user.getStudent().getId();
        return this.transactionService.initiateTxn(studentId,bookId,transactionType);
    }

}
