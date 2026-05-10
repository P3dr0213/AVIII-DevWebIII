package com.autobots.automanager.controles;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.autobots.automanager.dto.Venda.VendaAtualizadorDTO;
import com.autobots.automanager.dto.Venda.VendaCadastrarDTO;
import com.autobots.automanager.dto.Venda.VendaExibirDTO;
import com.autobots.automanager.servicos.VendaServico;
import com.autobots.automanager.modeladores.VendaModelador;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/vendas")
public class VendaControle {

    @Autowired
    private VendaServico servico;

    @Autowired
    private VendaModelador modelador;

    @GetMapping
    public ResponseEntity<CollectionModel<VendaExibirDTO>> obterTodos() {
        List<VendaExibirDTO> vendas = servico.buscarTodos();
        List<VendaExibirDTO> modelos = vendas.stream()
                .map(modelador::toModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(modelos, 
                linkTo(methodOn(VendaControle.class).obterTodos()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaExibirDTO> obterPorId(@PathVariable Long id) {
        VendaExibirDTO dto = servico.buscarPorIdDTO(id);
        return ResponseEntity.ok(modelador.toModel(dto));
    }

    @PostMapping
    public ResponseEntity<VendaExibirDTO> cadastrar(@Valid @RequestBody VendaCadastrarDTO dto) {
        VendaExibirDTO criado = servico.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelador.toModel(criado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody VendaAtualizadorDTO dto) {
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