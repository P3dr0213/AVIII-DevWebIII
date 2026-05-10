package com.autobots.automanager.dto.CredencialUsuarioSenha;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CredencialUsuarioSenhaCadastrarDTO {
    @NotBlank(message = "O nome de usuário é obrigatório")
    private String nomeUsuario;

    @NotBlank(message = "A senha é obrigatória")
    private String senha;
}