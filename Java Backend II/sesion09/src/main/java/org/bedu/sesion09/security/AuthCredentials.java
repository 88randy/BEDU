package org.bedu.sesion09.security;

import lombok.Data;

@Data
public class AuthCredentials {
    private String email;
    private String password;
}
