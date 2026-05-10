package com.autobots.automanager.dto.Telefone;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TelefoneAtualizadorDTO {
    private Long id;

    @NotBlank(message = "O DDD é obrigatório")
    @Size(min = 2, max = 2, message = "O DDD deve conter exatamente 2 caracteres")
    private String ddd;

    @NotBlank(message = "O número do telefone é obrigatório")
    @Size(min = 8, max = 9, message = "O número do telefone deve conter entre 8 e 9 caracteres")
    private String numero;
}
