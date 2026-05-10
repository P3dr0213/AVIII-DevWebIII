package com.autobots.automanager.dto.Email;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailCadastroDTO {
    @NotBlank(message = "O endereço de e-mail é obrigatório")
    @Email(message = "O formato do e-mail é inválido")
    private String endereco;
}