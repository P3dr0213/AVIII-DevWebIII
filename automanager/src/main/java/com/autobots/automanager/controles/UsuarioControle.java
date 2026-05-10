package com.autobots.automanager.controles;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.autobots.automanager.dto.Usuario.UsuarioAtualizadorDTO;
import com.autobots.automanager.dto.Usuario.UsuarioCadastrarDTO;
import com.autobots.automanager.dto.Usuario.UsuarioExibirDTO;
import com.autobots.automanager.servicos.UsuarioServico;
import com.autobots.automanager.modeladores.UsuarioModelador;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControle {

    @Autowired
    private UsuarioServico servico;

    @Autowired
    private UsuarioModelador modelador;

    @GetMapping
    public ResponseEntity<CollectionModel<UsuarioExibirDTO>> obterTodos() {
        List<UsuarioExibirDTO> usuarios = servico.buscarTodos();
        List<UsuarioExibirDTO> modelos = usuarios.stream()
                .map(modelador::toModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(modelos, 
                linkTo(methodOn(UsuarioControle.class).obterTodos()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioExibirDTO> obterPorId(@PathVariable Long id) {
        UsuarioExibirDTO dto = servico.buscarPorIdDTO(id);
        return ResponseEntity.ok(modelador.toModel(dto));
    }

    @PostMapping
    public ResponseEntity<UsuarioExibirDTO> cadastrar(@Valid @RequestBody UsuarioCadastrarDTO dto) {
        UsuarioExibirDTO criado = servico.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelador.toModel(criado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioAtualizadorDTO dto) {
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