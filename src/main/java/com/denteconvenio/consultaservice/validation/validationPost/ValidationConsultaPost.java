/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.denteconvenio.consultaservice.validation.validationPost;

import com.denteconvenio.consultaservice.domain.consulta.ConsultaRequestDTO;

import jakarta.servlet.http.HttpServletRequest;


public interface ValidationConsultaPost {

    void validar(ConsultaRequestDTO dto, HttpServletRequest request);

}
