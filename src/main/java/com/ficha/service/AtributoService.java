package com.ficha.service;

import com.ficha.Entity.Atributo;
import com.ficha.dto.request.AtributoDtoRequest;
import com.ficha.dto.response.AtributoDtoResponse;
import com.ficha.repository.AtributoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtributoService {
    @Autowired
    private AtributoRepository atributoRepository;

    public AtributoDtoResponse criarAtributo(AtributoDtoRequest request){
        Atributo atri = new Atributo();
        atri.setIdAtri(request.getIdAtri());
        atri.setDescricao(request.getDescricao());

        atri = atributoRepository.save(atri);

        return new AtributoDtoResponse(atri.getIdAtri(), atri.getDescricao());
    }

    public List<Atributo> listar(){
        return atributoRepository.findAll();
    }
}
