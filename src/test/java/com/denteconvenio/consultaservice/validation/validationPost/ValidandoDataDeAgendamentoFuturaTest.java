package com.denteconvenio.consultaservice.validation.validationPost;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.denteconvenio.consultaservice.domain.consulta.ConsultaRequestDTO;
import com.denteconvenio.consultaservice.infra.validation.ValidacaoException;

public class ValidandoDataDeAgendamentoFuturaTest {

    @InjectMocks
    private ValidandoDataDeAgendamentoFutura validacao;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testValidar() {
        var dto = new ConsultaRequestDTO(null, null, LocalDate.now(), null);
        assertThrows(ValidacaoException.class, () -> validacao.validar(dto, null));
    }

    @Test
    void testValidar2() {
        var dto = new ConsultaRequestDTO(null, null, LocalDate.now().plusWeeks(1), null);
        assertDoesNotThrow( () -> validacao.validar(dto, null));
    }
}
