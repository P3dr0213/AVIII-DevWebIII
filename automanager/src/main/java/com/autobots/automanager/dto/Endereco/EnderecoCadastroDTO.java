package com.autobots.automanager.dto.Endereco;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EnderecoCadastroDTO {

    private Long idCliente;

    @NotBlank(message = "O estado é obrigatório")
    @Size(max = 100, message = "O estado deve ter no máximo 100 caracteres")
    private String estado;

    @NotBlank(message = "A cidade é obrigatória")
    private String cidade;

    @NotBlank(message = "O bairro é obrigatório")
    private String bairro;

    @NotBlank(message = "A rua é obrigatória")
    private String rua;

    @NotBlank(message = "O número é obrigatório")
    private String numero;

    @NotBlank(message = "O CEP é obrigatório")
    private String cep;

    private String informacoesAdicionais;
}