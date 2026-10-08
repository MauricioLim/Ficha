package com.ficha.controller;

import com.ficha.dto.request.ProficienciaDtoRequest;
import com.ficha.dto.response.ProficienciaDtoResponse;
import com.ficha.service.ProficienciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proficiencias")
public class ProficienciaController {

    private final ProficienciaService proficienciaService;

    public ProficienciaController(ProficienciaService proficienciaService) {
        this.proficienciaService = proficienciaService;
    }

    @PostMapping
    public ResponseEntity<ProficienciaDtoResponse> criarProficiencia(@Valid @RequestBody ProficienciaDtoRequest request){
        ProficienciaDtoResponse response = proficienciaService.criarProficiencia(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProficienciaDtoResponse>> listar(){
        return ResponseEntity.ok(proficienciaService.listar());
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        proficienciaService.deletar(id);
    }
}
