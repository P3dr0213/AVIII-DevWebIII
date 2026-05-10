package com.autobots.automanager.dto.Documento;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class DocumentoCadastroDTO {

    private Long idCliente;

    @NotBlank(message = "O tipo do documento é obrigatório")
    private String tipo;

    @NotBlank(message = "O número do documento é obrigatório")
    private String numero;
}