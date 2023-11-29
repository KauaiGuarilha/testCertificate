package com.example.demo.controller;


import com.example.demo.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.security.cert.CertificateExpiredException;

import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/certificate")
public class TesteController {

    @Autowired
    private CertificateService service;

    @PostMapping(value = "/verify", consumes = MediaType.MULTIPART_FORM_DATA)
    public void verify(@RequestPart(value = "certificate") MultipartFile certificate, String password) throws CertificateExpiredException {
        service.verifyCertificate(certificate, password);
    }
}
