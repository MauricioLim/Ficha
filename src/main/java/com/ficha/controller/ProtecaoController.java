package com.ficha.controller;


import com.ficha.dto.request.ProtecaoDtoRequest;
import com.ficha.dto.response.ProtecaoDtoResponse;
import com.ficha.service.ProtecaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/protecao")
public class ProtecaoController {

    private final ProtecaoService protecaoService;

    public ProtecaoController(ProtecaoService protecaoService) {
        this.protecaoService = protecaoService;
    }

    @PostMapping
    public ResponseEntity<ProtecaoDtoResponse> criarAtributo(@Valid @RequestBody ProtecaoDtoRequest request) {
        ProtecaoDtoResponse response = protecaoService.criarProtecao(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProtecaoDtoResponse>> listar() {
        return ResponseEntity.ok(protecaoService.listar());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        protecaoService.deletar(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProtecaoDtoResponse> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(protecaoService.buscaPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProtecaoDtoResponse> atualizar(@PathVariable Integer id, @RequestBody ProtecaoDtoRequest request){
        return ResponseEntity.ok(protecaoService.atualizarProtecao(id, request));
    }
}
