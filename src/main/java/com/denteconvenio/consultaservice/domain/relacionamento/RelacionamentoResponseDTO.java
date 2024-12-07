package com.denteconvenio.consultaservice.domain.relacionamento;

import java.io.Serializable;
import java.util.UUID;

public record RelacionamentoResponseDTO(

    UUID idRelacionamento,
    UUID idConsulta,
    UUID idBeneficiario,
    UUID idConsultorio,
    StatusRelacionamento tipo,
    Boolean respostaConsultorio,
    Boolean respostaBeneficiaro

) implements Serializable{
    
    public RelacionamentoResponseDTO(Relacionamento relacionamento){
    this(relacionamento.getId(), relacionamento.getConsulta().getId(), relacionamento.getIdBeneficiario(), relacionamento.getIdConsultorio(),
     relacionamento.getTipo(), relacionamento.getRespostaConsultorio(), relacionamento.getRespostaBeneficiaro());
    }

}
