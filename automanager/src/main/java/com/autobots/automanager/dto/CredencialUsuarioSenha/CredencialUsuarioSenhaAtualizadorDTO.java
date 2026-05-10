package com.autobots.automanager.dto.CredencialUsuarioSenha;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CredencialUsuarioSenhaAtualizadorDTO {
    @NotNull(message = "O id da credencial é obrigatório")
    private Long id;

    private String nomeUsuario;
    private String senha;
    private Boolean inativo;
}