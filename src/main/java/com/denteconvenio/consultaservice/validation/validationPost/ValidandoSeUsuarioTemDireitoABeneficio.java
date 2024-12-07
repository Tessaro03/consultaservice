package com.denteconvenio.consultaservice.validation.validationPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denteconvenio.consultaservice.domain.consulta.ConsultaRequestDTO;
import com.denteconvenio.consultaservice.infra.rest.PlanoServiceClient;
import com.denteconvenio.consultaservice.infra.security.TokenService;
import com.denteconvenio.consultaservice.infra.validation.ValidacaoException;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ValidandoSeUsuarioTemDireitoABeneficio implements ValidationConsultaPost{
    
    @Autowired
    private PlanoServiceClient planoServiceClient;

    @Autowired
    private TokenService tokenService;


    public void validar(ConsultaRequestDTO dto, HttpServletRequest request) {
        
        if (! planoServiceClient.consultarBeneficio(tokenService.recuperarToken(request) , dto.idBeneficio())) {
            throw new ValidacaoException("Beneficiario não tem acesso a beneficio");
        }
    }

}
