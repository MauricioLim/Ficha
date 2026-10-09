package com.ficha.service;


import com.ficha.Entity.Resistencia;

import com.ficha.dto.request.ResistenciaDtoRequest;

import com.ficha.dto.response.ResistenciaDtoResponse;
import com.ficha.exception.ConflitoException;
import com.ficha.exception.RecursoNaoEncontradoException;

import com.ficha.repository.ResistenciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResistenciaService {
    private final ResistenciaRepository resistenciaRepository;

    public ResistenciaService(ResistenciaRepository resistenciaRepository) {
        this.resistenciaRepository = resistenciaRepository;
    }

    @Transactional
    public ResistenciaDtoResponse criarResistencia(ResistenciaDtoRequest request){
        String descricao = request.getDescricao().trim();

        if (resistenciaRepository.existsByDescricaoIgnoreCase(descricao)){
            throw new ConflitoException("Resistencia " + descricao + " já cadastrado");
        }

        Resistencia resistencia = new Resistencia();
        resistencia.setDescricao(descricao);

        resistencia = resistenciaRepository.save(resistencia);

        return toResponse(resistencia);
    }

    @Transactional(readOnly = true)
    public List<ResistenciaDtoResponse> listar(){
        return resistenciaRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    private ResistenciaDtoResponse toResponse(Resistencia resistencia) {
        return new ResistenciaDtoResponse(resistencia.getIdRes(), resistencia.getDescricao());
    }

    @Transactional
    public void deletar(Integer id){
        Resistencia resistencia = buscarEntidade(id);
        resistenciaRepository.delete(resistencia);
    }


    public Resistencia buscarEntidade(Integer id){
        return resistenciaRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Resistencia " + id + " não encontrado"));
    }

    @Transactional
    public ResistenciaDtoResponse buscarPorId(Integer id){
        return toResponse(buscarEntidade(id));
    }

    @Transactional
    public ResistenciaDtoResponse atualizarResistencia(Integer id, ResistenciaDtoRequest request){
        Resistencia resistencia = buscarEntidade(id);
        resistencia.setDescricao(request.getDescricao());

        return toResponse(resistencia);
    }
}
