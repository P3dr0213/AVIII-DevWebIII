package com.autobots.automanager.dto.Servico;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ServicoAtualizadorDTO {
    @NotNull(message = "O id do serviço é obrigatório")
    private Long id;

    private String nome;
    private Double valor;
    private String descricao;
}