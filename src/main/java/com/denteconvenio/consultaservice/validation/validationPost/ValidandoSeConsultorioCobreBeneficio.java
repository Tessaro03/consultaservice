package com.denteconvenio.consultaservice.validation.validationPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denteconvenio.consultaservice.domain.consulta.ConsultaRequestDTO;
import com.denteconvenio.consultaservice.infra.rest.PlanoServiceClient;
import com.denteconvenio.consultaservice.infra.validation.ValidacaoException;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidandoSeConsultorioCobreBeneficio implements ValidationConsultaPost {
    

    @Autowired
    private PlanoServiceClient planoServiceClient;

  
    public void validar(ConsultaRequestDTO dto, HttpServletRequest request) {
        
        if (! planoServiceClient.consultarBeneficioConsultorio(dto.idConsultorio() , dto.idBeneficio())) {
            throw new ValidacaoException("Consultorio não cobre beneficio");
        }
    }
}
