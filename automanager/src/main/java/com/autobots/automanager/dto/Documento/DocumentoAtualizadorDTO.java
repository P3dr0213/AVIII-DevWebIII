package com.autobots.automanager.dto.Documento;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DocumentoAtualizadorDTO {
    @NotNull(message = "O id do documento é obrigatório")
    private Long id;

    @NotBlank(message = "O tipo do documento é obrigatório")
    private String tipo;

    @NotBlank(message = "O número do documento é obrigatório")
    private String numero;
}
