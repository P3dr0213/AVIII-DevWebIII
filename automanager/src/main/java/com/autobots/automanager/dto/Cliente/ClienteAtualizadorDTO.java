package com.autobots.automanager.dto.Cliente;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClienteAtualizadorDTO {
    @NotNull(message = "O id do cliente é obrigatório")
    private Long id;

    @NotBlank(message = "O nome do cliente é obrigatório")
    private String nome;

    @NotBlank(message = "O nome social é obrigatório")
    private String nomeSocial;

    @NotNull(message = "A data de nascimento é obrigatória")
    private Date dataNascimento;
}
