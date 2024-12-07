package com.denteconvenio.consultaservice.service;

import java.util.List;
import java.util.UUID;

import com.denteconvenio.consultaservice.domain.consulta.Consulta;

import jakarta.servlet.http.HttpServletRequest;

public interface RelacionamentoInterface {

    public void criarRelacionamento(Consulta consulta);
      
    public void aceitarConsulta(HttpServletRequest request, UUID id);

    public void recusarConsulta(HttpServletRequest request, UUID id);

    public void deletarRelacionamentos(List<UUID> ids);
}