package com.example.demo.service;

import com.example.demo.model.domain.EValidation;
import com.example.demo.model.exception.ExceptionAbstract;
import com.example.demo.model.exception.PasswordNotFoundException;
import com.example.demo.model.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateExpiredException;
import java.util.Objects;

@Slf4j
@Service
public class CertificateService {
    private static final String PKCS12 = "PKCS12";
    private static final String LOG_ERROR =
            "A generic problem occurred when trying to read the digital certificate.";

    public void verifyCertificate(MultipartFile certificate, String password) throws CertificateExpiredException {
        try {
             buildSignedDocument( certificate, password );
        } catch (ExceptionAbstract | IllegalArgumentException | CertificateExpiredException e) {
            throw e;
        } catch (Exception e) {
            log.error(LOG_ERROR, e);
            throw new ResourceNotFoundException(EValidation.NOT_IDENTIFIED);
        }
    }

    private void buildSignedDocument(MultipartFile certificate, String password)
            throws Exception {
        var passwordCharArray = Objects.nonNull(password) ? password.toCharArray() : null;

        var keystore = buildKeystore(certificate, passwordCharArray);
    }

    public KeyStore buildKeystore(MultipartFile certificate, char[] password) throws KeyStoreException {
        var keystore = KeyStore.getInstance(PKCS12);
        loadCertificate(certificate, keystore, password);
        return keystore;
    }

    private void loadCertificate(MultipartFile certificate, KeyStore keyStore, char[] password){
        try {
            keyStore.load(certificate.getInputStream(), password);
        } catch (Exception e){
            throw new PasswordNotFoundException(EValidation.PASSWORD_NOT_IDENTIFIED);
        }
    }
}
