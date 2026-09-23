package com.ficha.controller;

import com.ficha.Entity.Atributo;
import com.ficha.service.AtributoService;
import com.ficha.dto.request.AtributoDtoRequest;
import com.ficha.dto.response.AtributoDtoResponse;
import com.ficha.repository.AtributoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atributos")
public class AtributoController {

    @Autowired
    private AtributoRepository atributoRepository;

    @Autowired
    private AtributoService atributoService;

    @PostMapping("/criar")
    public AtributoDtoResponse criarAtributo(@RequestBody AtributoDtoRequest request){
        return atributoService.criarAtributo(request);
    }

    @GetMapping("/listar")
    public List<Atributo> list(){
        return atributoService.listar();
    }

}
