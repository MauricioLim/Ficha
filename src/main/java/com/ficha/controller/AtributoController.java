package com.ficha.controller;

import com.ficha.Entity.Atributo;
import com.ficha.dto.request.ItemDtoRequest;
import com.ficha.dto.response.ItemDtoResponse;
import com.ficha.service.AtributoService;
import com.ficha.dto.request.AtributoDtoRequest;
import com.ficha.dto.response.AtributoDtoResponse;
import com.ficha.repository.AtributoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atributos")
public class AtributoController {

    private final AtributoService atributoService;

    public AtributoController(AtributoService atributoService) {
        this.atributoService = atributoService;
    }

    @PostMapping
    public ResponseEntity<AtributoDtoResponse> criarAtributo(@Valid @RequestBody AtributoDtoRequest request) {
        AtributoDtoResponse response = atributoService.criarAtributo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AtributoDtoResponse>> listar() {
        return ResponseEntity.ok(atributoService.listar());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        atributoService.deletar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtributoDtoResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody AtributoDtoRequest request){
        return ResponseEntity.ok(atributoService.atualizarAtributo(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtributoDtoResponse> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(atributoService.buscarPorId(id));
    }

}
