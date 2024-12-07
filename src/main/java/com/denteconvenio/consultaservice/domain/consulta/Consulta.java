package com.denteconvenio.consultaservice.domain.consulta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "consultas")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Consulta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    private UUID idBeneficiario;
    private UUID idDentista;
    private UUID idConsultorio;
    private UUID idBeneficio;

    
    private LocalDate data;
    private LocalTime hora;

    @Enumerated
    private Status status;

    public Consulta(UUID idBeneficiario,  UUID idConsultorio, LocalDate data, LocalTime hora, UUID idBeneficio) {
        this.idBeneficiario = idBeneficiario;
        this.idBeneficio = idBeneficio;
        this.idDentista = null;
        this.idConsultorio = idConsultorio;
        this.data = data;
        this.hora = hora;
        this.status = Status.Pendente;
    }


}
