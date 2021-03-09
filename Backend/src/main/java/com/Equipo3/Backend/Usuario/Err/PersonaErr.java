package com.Equipo3.Backend.Usuario.Err;

import com.Equipo3.Backend.Shared.Err.DomainError;

/**
 * Clase Persona
 */
public class PersonaErr extends DomainError {
    public PersonaErr(String errcode, String errtext) {
        super(errcode, errtext);
    }
}