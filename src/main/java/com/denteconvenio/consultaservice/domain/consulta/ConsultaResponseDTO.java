package com.denteconvenio.consultaservice.domain.consulta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;


public record ConsultaResponseDTO(

    UUID id,
    UUID idBeneficiario,
    UUID idDentista,
    UUID idConsultorio,
    UUID idBeneficio,
    LocalDate data,
    LocalTime hora,
    Status status


) {

    public ConsultaResponseDTO(Consulta consulta){
        this(consulta.getId(), consulta.getIdBeneficiario(), consulta.getIdDentista(), 
        consulta.getIdConsultorio(), consulta.getIdBeneficio(), consulta.getData(), consulta.getHora(), consulta.getStatus());
    }
}
