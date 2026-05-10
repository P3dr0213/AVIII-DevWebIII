package com.autobots.automanager.dto.Venda;

import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VendaCadastrarDTO {
    @NotBlank(message = "A identificação da venda é obrigatória")
    private String identificacao;

    @NotNull(message = "O ID do cliente é obrigatório")
    private Long clienteId;

    @NotNull(message = "O ID do funcionário é obrigatório")
    private Long funcionarioId;

    private Long veiculoId;
    private Set<Long> mercadoriasIds;
    private Set<Long> servicosIds;
}