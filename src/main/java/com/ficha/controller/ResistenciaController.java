package com.ficha.controller;

import com.ficha.dto.request.AtributoDtoRequest;
import com.ficha.dto.request.ResistenciaDtoRequest;
import com.ficha.dto.response.AtributoDtoResponse;
import com.ficha.dto.response.ResistenciaDtoResponse;
import com.ficha.service.AtributoService;
import com.ficha.service.ResistenciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resistencias")
public class ResistenciaController {

    private final ResistenciaService resistenciaService;

    public ResistenciaController(ResistenciaService resistenciaService) {
        this.resistenciaService = resistenciaService;
    }

    @PostMapping
    public ResponseEntity<ResistenciaDtoResponse> criarAtributo(@Valid @RequestBody ResistenciaDtoRequest request) {
        ResistenciaDtoResponse response = resistenciaService.criarResistencia(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ResistenciaDtoResponse>> listar() {
        return ResponseEntity.ok(resistenciaService.listar());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        resistenciaService.deletar(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResistenciaDtoResponse> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(resistenciaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResistenciaDtoResponse> atualizar(@PathVariable Integer id, @RequestBody ResistenciaDtoRequest request){
        return ResponseEntity.ok(resistenciaService.atualizarResistencia(id, request));
    }


}
