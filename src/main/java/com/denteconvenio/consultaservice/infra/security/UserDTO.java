package com.denteconvenio.consultaservice.infra.security;

import java.util.UUID;


public record UserDTO(

    UUID id,
    String username,
    String email,
    String tipo
    
) {}