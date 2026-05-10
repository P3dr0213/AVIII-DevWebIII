package com.autobots.automanager.controles;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.autobots.automanager.dto.Veiculo.VeiculoAtualizadorDTO;
import com.autobots.automanager.dto.Veiculo.VeiculoCadastrarDTO;
import com.autobots.automanager.dto.Veiculo.VeiculoExibirDTO;
import com.autobots.automanager.servicos.VeiculoServico;
import com.autobots.automanager.modeladores.VeiculoModelador;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/veiculos")
public class VeiculoControle {

    @Autowired
    private VeiculoServico servico;

    @Autowired
    private VeiculoModelador modelador;

    @GetMapping
    public ResponseEntity<CollectionModel<VeiculoExibirDTO>> obterTodos() {
        List<VeiculoExibirDTO> veiculos = servico.buscarTodos();
        List<VeiculoExibirDTO> modelos = veiculos.stream()
                .map(modelador::toModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(modelos, 
                linkTo(methodOn(VeiculoControle.class).obterTodos()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoExibirDTO> obterPorId(@PathVariable Long id) {
        VeiculoExibirDTO dto = servico.buscarPorIdDTO(id);
        return ResponseEntity.ok(modelador.toModel(dto));
    }

    @PostMapping
    public ResponseEntity<VeiculoExibirDTO> cadastrar(@Valid @RequestBody VeiculoCadastrarDTO dto) {
        VeiculoExibirDTO criado = servico.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelador.toModel(criado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody VeiculoAtualizadorDTO dto) {
        dto.setId(id);
        servico.atualizar(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        servico.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}