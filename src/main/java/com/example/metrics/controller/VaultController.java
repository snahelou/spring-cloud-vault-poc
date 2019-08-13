package com.example.metrics.controller;

import com.example.metrics.service.IVaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VaultController {

    @Autowired
    private IVaultService vaultService;

    @GetMapping(value = "/vault", produces = "application/json")
    public @ResponseBody
    ResponseEntity<String> getSecret() {
        return new ResponseEntity<>(vaultService.findFoo() , null, HttpStatus.OK);
    }

}
