package com.autobots.automanager.controles;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.autobots.automanager.dto.Mercadoria.MercadoriaAtualizadorDTO;
import com.autobots.automanager.dto.Mercadoria.MercadoriaCadastrarDTO;
import com.autobots.automanager.dto.Mercadoria.MercadoriaExibirDTO;
import com.autobots.automanager.servicos.MercadoriaServico;
import com.autobots.automanager.modeladores.MercadoriaModelador;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/mercadorias")
public class MercadoriaControle {

    @Autowired
    private MercadoriaServico servico;

    @Autowired
    private MercadoriaModelador modelador;

    @GetMapping
    public ResponseEntity<CollectionModel<MercadoriaExibirDTO>> obterTodos() {
        List<MercadoriaExibirDTO> mercadorias = servico.buscarTodos();
        List<MercadoriaExibirDTO> modelos = mercadorias.stream()
                .map(modelador::toModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(modelos, 
                linkTo(methodOn(MercadoriaControle.class).obterTodos()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MercadoriaExibirDTO> obterPorId(@PathVariable Long id) {
        MercadoriaExibirDTO dto = servico.buscarPorIdDTO(id);
        return ResponseEntity.ok(modelador.toModel(dto));
    }

    @PostMapping
    public ResponseEntity<MercadoriaExibirDTO> cadastrar(@Valid @RequestBody MercadoriaCadastrarDTO dto) {
        MercadoriaExibirDTO criado = servico.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelador.toModel(criado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody MercadoriaAtualizadorDTO dto) {
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