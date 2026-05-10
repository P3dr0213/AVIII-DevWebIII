package com.autobots.automanager.dto.Servico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class ServicoCadastrarDTO {
    @NotBlank(message = "O nome do serviço é obrigatório")
    private String nome;

    @PositiveOrZero(message = "O valor do serviço não pode ser negativo")
    private double valor;

    private String descricao;
}