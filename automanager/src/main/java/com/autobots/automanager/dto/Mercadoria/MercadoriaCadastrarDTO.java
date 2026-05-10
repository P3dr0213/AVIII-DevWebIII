package com.autobots.automanager.dto.Mercadoria;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class MercadoriaCadastrarDTO {
    @NotBlank(message = "O nome da mercadoria é obrigatório")
    private String nome;

    private String descricao;

    @PositiveOrZero(message = "A quantidade não pode ser negativa")
    private long quantidade;

    @PositiveOrZero(message = "O valor não pode ser negativo")
    private double valor;

    @NotNull(message = "A data de validade é obrigatória")
    private Date validade;

    @NotNull(message = "A data de fabricação é obrigatória")
    private Date fabricao;
}