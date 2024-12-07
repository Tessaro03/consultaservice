package com.denteconvenio.consultaservice.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denteconvenio.consultaservice.domain.consulta.ConsultaRequestDTO;
import com.denteconvenio.consultaservice.validation.validationPost.ValidationConsultaPost;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidationConsulta {
    
    @Autowired
    private List<ValidationConsultaPost> validationPost;

    public void validarPost(HttpServletRequest request, ConsultaRequestDTO dto){
        validationPost.forEach(v -> v.validar(dto, request));
    }

    


}
