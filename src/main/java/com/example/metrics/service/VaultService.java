package com.example.metrics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class VaultService  implements IVaultService {

    @Autowired
    Environment env;

    @Value("${foo}")
    private String foo;

    public String findFoo() {
        return foo;
    }

}
