package com.denteconvenio.consultaservice.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.denteconvenio.consultaservice.domain.consulta.Consulta;
import com.denteconvenio.consultaservice.domain.consulta.ConsultaRequestDTO;
import com.denteconvenio.consultaservice.domain.consulta.ConsultaResponseDTO;
import com.denteconvenio.consultaservice.domain.consulta.Status;
import com.denteconvenio.consultaservice.infra.security.TokenService;
import com.denteconvenio.consultaservice.repository.ConsultaRepository;
import com.denteconvenio.consultaservice.validation.ValidationConsulta;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ConsultaService {
    
    @Autowired
    private ConsultaRepository repository;
    
    @Autowired
    private TokenService tokenService;

    @Autowired
    private ValidationConsulta validacao;

    @Autowired
    private RelacionamentoInterface relacionamento;

    public void agendarConsulta(HttpServletRequest request, ConsultaRequestDTO dto) {
        validacao.validarPost(request, dto);
        var beneficiario = tokenService.extrairInformacoes(request);
        var consulta = new Consulta(beneficiario.id(),dto.idConsultorio(), dto.data(), dto.hora(), dto.idBeneficio());
        repository.save(consulta);
        relacionamento.criarRelacionamento(consulta);
    }

    public void cancelarConsulta(HttpServletRequest request, UUID idConsulta) {
        var consulta = repository.findById(idConsulta);
        if (consulta.isPresent()) {
            consulta.get().setStatus(Status.Cancelado);
        }
    }

    public List<ConsultaResponseDTO> verConsultas(HttpServletRequest request) {
        var user = tokenService.extrairInformacoes(request);
        List<Consulta> consultas = new ArrayList<>();
        if ( "Consultorio".equals(user.tipo())) {
            consultas = repository.findAllByIdConsultorio(user.id());
        }
        if ("Beneficiario".equals(user.tipo())) {
            consultas = repository.findAllByIdBeneficiario(user.id());
        }
        return consultas.stream().map(ConsultaResponseDTO::new).collect(Collectors.toList());
    }


    @Scheduled(cron = "0 0 0 * * ?") // Executa a cada hora 
    public void removerCancelados() { 
        List<Consulta> cancelados =  repository.findAllByDataBeforeAndStatus(LocalDateTime.now().minusWeeks(1), Status.Cancelado);
        repository.deleteAll(cancelados);
    }


}
