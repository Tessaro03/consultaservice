package com.denteconvenio.consultaservice.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.denteconvenio.consultaservice.domain.consulta.Consulta;
import com.denteconvenio.consultaservice.domain.consulta.Status;

public interface ConsultaRepository extends JpaRepository<Consulta, UUID>{
    
    public List<Consulta> findAllByIdBeneficiario(UUID id);

    public List<Consulta> findAllByIdConsultorio(UUID id);

    public List<Consulta> findAllByDataBeforeAndStatus(LocalDateTime now, Status status);

    public List<Consulta> findAllByDataAfterAndStatus(LocalDateTime now, Status cancelado);

}
