package com.denteconvenio.consultaservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.denteconvenio.consultaservice.service.RelacionamentoService;

import jakarta.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("relacionamento")
public class RelacionamentoController {
    
    @Autowired
    private RelacionamentoService service;


    @GetMapping
    public ResponseEntity verRelacionamentos(HttpServletRequest request) {
        return ResponseEntity.ok(service.verRelacionamentos(request));
    }
    
    @PostMapping("/{idRelacionamento}")
    @PreAuthorize("hasAnyRole('BENEFICIARIO', 'CONSULTORIO')")
    public void aceitarConsulta(HttpServletRequest request, @PathVariable UUID idRelacionamento) {
        service.aceitarConsulta(request, idRelacionamento);
    }
    
    @DeleteMapping("/{idRelacionamento}")
    @PreAuthorize("hasAnyRole('BENEFICIARIO', 'CONSULTORIO')")
    public void recusarConsulta(HttpServletRequest request, @PathVariable UUID idRelacionamento) {
        service.recusarConsulta(request, idRelacionamento);
    }

}
