package com.denteconvenio.consultaservice.infra.rest;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlanoServiceClient {

    private final RestTemplate restTemplate;

    @Autowired
    public PlanoServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Boolean consultarBeneficio(String token, UUID idBeneficio) {
        String url = "http://localhost:8082/planoservice/assinatura/" + idBeneficio ;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.POST, entity, Boolean.class);
        return response.getBody();
    }

    public Boolean consultarBeneficioConsultorio(UUID idConsultorio, UUID idBeneficio) {
        String url = "http://localhost:8082/planoservice/cobertura/"+ idConsultorio + "/" + idBeneficio ;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.POST, entity, Boolean.class);
        return response.getBody();
    }
}