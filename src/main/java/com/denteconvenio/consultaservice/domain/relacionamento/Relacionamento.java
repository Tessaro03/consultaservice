package com.denteconvenio.consultaservice.domain.relacionamento;

import java.util.UUID;

import com.denteconvenio.consultaservice.domain.consulta.Consulta;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "relacionamentos")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Relacionamento {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    @OneToOne
    private Consulta consulta;

    private UUID idBeneficiario;
    private UUID idConsultorio;

    @Enumerated
    private StatusRelacionamento tipo;

    private Boolean respostaConsultorio; 
    private Boolean respostaBeneficiaro;


    public Relacionamento(Consulta consulta, UUID idBeneficiario, UUID idConsultorio ) {
        this.consulta = consulta;
        this.idBeneficiario = idBeneficiario;
        this.idConsultorio = idConsultorio;
        this.tipo = StatusRelacionamento.Confirmacao;
        this.respostaConsultorio = false;
        this.respostaBeneficiaro = true;
    } 

}
