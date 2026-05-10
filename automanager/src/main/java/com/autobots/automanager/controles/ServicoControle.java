package com.autobots.automanager.controles;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.autobots.automanager.dto.Servico.ServicoAtualizadorDTO;
import com.autobots.automanager.dto.Servico.ServicoCadastrarDTO;
import com.autobots.automanager.dto.Servico.ServicoExibirDTO;
import com.autobots.automanager.servicos.ServicoServico;
import com.autobots.automanager.modeladores.ServicoModelador;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/servicos")
public class ServicoControle {

    @Autowired
    private ServicoServico servico;

    @Autowired
    private ServicoModelador modelador;

    @GetMapping
    public ResponseEntity<CollectionModel<ServicoExibirDTO>> obterTodos() {
        List<ServicoExibirDTO> servicos = servico.buscarTodos();
        List<ServicoExibirDTO> modelos = servicos.stream()
                .map(modelador::toModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(modelos, 
                linkTo(methodOn(ServicoControle.class).obterTodos()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoExibirDTO> obterPorId(@PathVariable Long id) {
        ServicoExibirDTO dto = servico.buscarPorIdDTO(id);
        return ResponseEntity.ok(modelador.toModel(dto));
    }

    @PostMapping
    public ResponseEntity<ServicoExibirDTO> cadastrar(@Valid @RequestBody ServicoCadastrarDTO dto) {
        ServicoExibirDTO criado = servico.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelador.toModel(criado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody ServicoAtualizadorDTO dto) {
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