package com.autobots.automanager.dto.Veiculo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.autobots.automanager.enumeracoes.TipoVeiculo;
import lombok.Data;

@Data
public class VeiculoCadastrarDTO {
    @NotNull(message = "O tipo do veículo é obrigatório")
    private TipoVeiculo tipo;

    @NotBlank(message = "O modelo do veículo é obrigatório")
    private String modelo;

    @NotBlank(message = "A placa do veículo é obrigatória")
    private String placa;
    
    // ID do proprietário caso seja vinculado no cadastro
    private Long proprietarioId;
}