package com.denteconvenio.consultaservice.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.denteconvenio.consultaservice.domain.relacionamento.Relacionamento;

public interface RelacionamentoRepository extends JpaRepository<Relacionamento, UUID>{

    Optional<Relacionamento> findByIdConsultorio(UUID idConsulta);

    public List<Relacionamento> findAllByIdBeneficiario(UUID id);

    public List<Relacionamento> findAllByIdConsultorio(UUID id);

    
}
