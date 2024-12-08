package com.denteconvenio.consultaservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.denteconvenio.consultaservice.domain.consulta.ConsultaRequestDTO;
import com.denteconvenio.consultaservice.service.ConsultaService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    
    @Autowired
    private ConsultaService service;


    @GetMapping
    @PreAuthorize("hasAnyRole('BENEFICIARIO', 'CONSULTORIO')")
    public ResponseEntity verConsulta(HttpServletRequest request){
        return ResponseEntity.ok(service.verConsultas(request));
    }
    
    @PostMapping
    @PreAuthorize("hasAnyRole('BENEFICIARIO')")
    public void agendarConsulta(HttpServletRequest request,@RequestBody ConsultaRequestDTO dto){
        service.agendarConsulta(request, dto);
    }

    
    @DeleteMapping("/{idConsulta}")
    @PreAuthorize("hasAnyRole('BENEFICIARIO', 'CONSULTORIO')")
    public void cancelarConsulta(HttpServletRequest request, @PathVariable UUID idConsulta){
        service.cancelarConsulta(request, idConsulta);
    }

}
