package com.autobots.automanager.controles;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid; 

import com.autobots.automanager.dto.Cliente.ClienteAtualizadorDTO;
import com.autobots.automanager.dto.Cliente.ClienteCadastrarDTO;
import com.autobots.automanager.dto.Cliente.ClienteExibirDTO;
import com.autobots.automanager.modeladores.ClienteModelador;
import com.autobots.automanager.servicos.ClienteServico;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/clientes")
public class ClienteControle {

    @Autowired
    private ClienteServico servico;

    @Autowired
    private ClienteModelador modelador;

    @PostMapping
    public ResponseEntity<ClienteExibirDTO> criar(@Valid @RequestBody ClienteCadastrarDTO dto) {
        ClienteExibirDTO clienteCriado = servico.cadastrarViaDTO(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelador.toModel(clienteCriado));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<ClienteExibirDTO>> listar() {
        List<ClienteExibirDTO> clientes = servico.buscarTodos();
        List<ClienteExibirDTO> modelos = clientes.stream()
                .map(modelador::toModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(modelos, 
                linkTo(methodOn(ClienteControle.class).listar()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteExibirDTO> obterPorId(@PathVariable Long id) {
        ClienteExibirDTO cliente = servico.buscarPorIdDTO(id);
        return ResponseEntity.ok(modelador.toModel(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteExibirDTO> editar(@PathVariable Long id, @Valid @RequestBody ClienteAtualizadorDTO dto) {
        dto.setId(id);
        servico.atualizarViaDTO(dto);
        ClienteExibirDTO atualizado = servico.buscarPorIdDTO(id);
        return ResponseEntity.ok(modelador.toModel(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        servico.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
















































































































































































































































































// https://avatars.githubusercontent.com/u/79658823?v=4