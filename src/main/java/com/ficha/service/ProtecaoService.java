package com.ficha.service;


import com.ficha.Entity.Protecao;
import com.ficha.dto.request.ProtecaoDtoRequest;
import com.ficha.dto.response.ProtecaoDtoResponse;
import com.ficha.exception.ConflitoException;
import com.ficha.exception.RecursoNaoEncontradoException;
import com.ficha.repository.ProtecaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProtecaoService {

    private final ProtecaoRepository protecaoRepository;

    public ProtecaoService(ProtecaoRepository protecaoRepository) {
        this.protecaoRepository = protecaoRepository;
    }

    @Transactional
    public ProtecaoDtoResponse criarProtecao(ProtecaoDtoRequest request){
        String descricao = request.getDescricao().trim();

        if (protecaoRepository.existsByDescricaoIgnoreCase(descricao)){
            throw new ConflitoException("Protecao " + descricao + " já cadastrado");
        }

        Protecao protecao = new Protecao();
        protecao.setDescricao(descricao);

        protecao = protecaoRepository.save(protecao);

        return toResponse(protecao);
    }

    @Transactional(readOnly = true)
    public List<ProtecaoDtoResponse> listar(){
        return protecaoRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    private ProtecaoDtoResponse toResponse(Protecao protecao) {
        return new ProtecaoDtoResponse(protecao.getIdProtecao(), protecao.getDescricao());
    }

    @Transactional
    public void deletar(Integer id){
        Protecao protecao = protecaoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Protecao " + id + " não encontrado"));
        protecaoRepository.delete(protecao);
    }
}
