package com.autobots.automanager.dto.Empresa;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmpresaAtualizadorDTO {
    @NotNull(message = "O id da empresa é obrigatório")
    private Long id;

    private String razaoSocial;
    private String nomeFantasia;
}