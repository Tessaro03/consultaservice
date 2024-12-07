package com.denteconvenio.consultaservice.validation.validationPost;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.denteconvenio.consultaservice.domain.consulta.ConsultaRequestDTO;
import com.denteconvenio.consultaservice.infra.validation.ValidacaoException;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidandoDataDeAgendamentoFutura implements  ValidationConsultaPost{

    public void validar(ConsultaRequestDTO dto, HttpServletRequest request) {
    
        if (dto.data().isBefore(LocalDate.now().plusWeeks(1))) {
            throw new ValidacaoException("Data deve ser marcada com antecedência de 1 semana");
        }
    
    }
    
}
