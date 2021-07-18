package com.deloitteinnovation.us.hbx.threescale.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data")
@Slf4j
@Validated
class DataController {

    private final PasswordEncoder passwordEncoder;

    DataController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    SampleData data(OAuth2Authentication authentication) {
        return SampleData.builder().field1("This is sample data field1").field2("This is sample data  field2").build();
    }
}