package com.zera.projetos.controllers;

import com.zera.projetos.models.ProjetoModel;
import com.zera.projetos.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<ProjetoModel> criarProjeto(@RequestBody ProjetoModel projeto){
        ProjetoModel request = projetoService.criarProjeto(projeto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(projeto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ProjetoModel>> findAll(){
        List<ProjetoModel> request = projetoService.buscarTodosProjetos();
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping
    public ResponseEntity<?> deletar (@PathVariable Long id){
        projetoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ProjetoModel buscarPorId(@PathVariable Long id){
        return projetoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoModel> atualizarCliente(@PathVariable Long id, @RequestBody ProjetoModel projeto){
        ProjetoModel model = projetoService.atualizar(id, projeto);
        return ResponseEntity.ok().body(model);
    }
}
