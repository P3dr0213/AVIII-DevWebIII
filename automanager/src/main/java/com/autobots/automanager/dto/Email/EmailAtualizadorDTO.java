package com.autobots.automanager.dto.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import lombok.Data;

@Data
public class EmailAtualizadorDTO {
    @NotNull(message = "O id do e-mail é obrigatório")
    private Long id;

    @Email(message = "O formato do e-mail é inválido")
    private String endereco;
}