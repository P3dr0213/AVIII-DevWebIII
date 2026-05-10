package com.autobots.automanager.dto.CredencialCodigoBarra;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CredencialQRAtualizadorDTO {
    @NotNull(message = "O id da credencial é obrigatório para atualização")
    private Long id;

    @NotNull(message = "O código de barras é obrigatório")
    private Long codigo;

    @NotNull(message = "O status de atividade (inativo) deve ser informado")
    private Boolean inativo;
}
