package com.ficha.service;

import com.ficha.Entity.Atributo;
import com.ficha.dto.request.AtributoDtoRequest;
import com.ficha.dto.response.AtributoDtoResponse;
import com.ficha.exception.ConflitoException;
import com.ficha.exception.RecursoNaoEncontradoException;
import com.ficha.repository.AtributoRepository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtributoService {

    private final AtributoRepository atributoRepository;

    public AtributoService(AtributoRepository atributoRepository) {
        this.atributoRepository = atributoRepository;
    }

    @Transactional
    public AtributoDtoResponse criarAtributo(AtributoDtoRequest request){
        String descricao = request.getDescricao().trim();

        if (atributoRepository.existsByDescricaoIgnoreCase(descricao)){
            throw new ConflitoException("Atributo " + descricao + " já cadastrado");
        }

        Atributo atri = new Atributo();
        atri.setDescricao(descricao);

        atri = atributoRepository.save(atri);

        return toResponse(atri);
    }

    @Transactional(readOnly = true)
    public List<AtributoDtoResponse> listar(){
        return atributoRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    private AtributoDtoResponse toResponse(Atributo atri) {
        return new AtributoDtoResponse(atri.getIdAtri(), atri.getDescricao());
    }

    @Transactional
    public void deletar(Integer id){
        Atributo atributo = atributoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("atributo " + id + " não encontrado"));
        atributoRepository.delete(atributo);
    }
}
