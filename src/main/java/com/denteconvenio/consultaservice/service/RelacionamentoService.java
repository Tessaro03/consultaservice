package com.denteconvenio.consultaservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denteconvenio.consultaservice.domain.consulta.Consulta;
import com.denteconvenio.consultaservice.domain.consulta.Status;
import com.denteconvenio.consultaservice.domain.relacionamento.Relacionamento;
import com.denteconvenio.consultaservice.domain.relacionamento.RelacionamentoResponseDTO;
import com.denteconvenio.consultaservice.infra.security.TokenService;
import com.denteconvenio.consultaservice.repository.RelacionamentoRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class RelacionamentoService implements RelacionamentoInterface {
    
    @Autowired
    private RelacionamentoRepository repository;

    @Autowired
    private TokenService tokenService;


    public void criarRelacionamento(Consulta consulta){
        var relacionamento = new Relacionamento(consulta, consulta.getIdBeneficiario(), consulta.getIdConsultorio());
        repository.save(relacionamento);
    }
    
    public List<RelacionamentoResponseDTO> verRelacionamentos(HttpServletRequest request) {
        var user = tokenService.extrairInformacoes(request);
        List<Relacionamento> relacionamentos = new ArrayList<>();
        if ( "Consultorio".equals(user.tipo())) {
            relacionamentos = repository.findAllByIdConsultorio(user.id());
        }
        if ("Beneficiario".equals(user.tipo())) {
            relacionamentos = repository.findAllByIdBeneficiario(user.id());
        }
        return relacionamentos.stream().map(RelacionamentoResponseDTO::new).collect(Collectors.toList());
    }
        
    public void aceitarConsulta(HttpServletRequest request, UUID id){
        var user = tokenService.extrairInformacoes(request);
        var relacionamentoOptional = repository.findById(id);
        if (relacionamentoOptional.isPresent() && "Consultorio".equals(user.tipo())) {
            var relacionamento = relacionamentoOptional.get();
            relacionamento.setRespostaConsultorio(true);
            relacionamento.getConsulta().setStatus(Status.Agendado);
            repository.save(relacionamento);
        }
    }

    public void recusarConsulta(HttpServletRequest request, UUID id){
        var user = tokenService.extrairInformacoes(request);
        var relacionamentoOptional = repository.findById(id);
        if (relacionamentoOptional.isPresent()) {            
            var relacionamento = relacionamentoOptional.get();
            relacionamento.getConsulta().setStatus(Status.Recusado);
            if ( "Consultorio".equals(user.tipo())) {
                relacionamento.setRespostaConsultorio(true);
                repository.save(relacionamento);
            }
            if ("Beneficiario".equals(user.tipo())) {
                relacionamento.setRespostaBeneficiaro(true);
                repository.save(relacionamento);
            }
        }
    }

    public void deletarRelacionamentos(List<UUID> ids) {
        repository.deleteAllById(ids);
    }

    

    

}
