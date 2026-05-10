package com.autobots.automanager.dto.Empresa;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmpresaCadastrarDTO {
    @NotBlank(message = "A razão social é obrigatória")
    private String razaoSocial;

    private String nomeFantasia;
}