package com.denteconvenio.consultaservice.domain.consulta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record ConsultaRequestDTO(
    
    @NotNull
    UUID idConsultorio,

    @NotNull
    UUID idBeneficio,

    @NotNull
    LocalDate data,

    @NotNull
    LocalTime hora
) {
}