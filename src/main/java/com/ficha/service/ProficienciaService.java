package com.ficha.service;

import com.ficha.Entity.Atributo;
import com.ficha.Entity.Proficiencia;
import com.ficha.dto.request.ProficienciaDtoRequest;
import com.ficha.dto.response.AtributoDtoResponse;
import com.ficha.dto.response.ProficienciaDtoResponse;
import com.ficha.exception.ConflitoException;
import com.ficha.exception.RecursoNaoEncontradoException;
import com.ficha.repository.ProficienciaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProficienciaService {

    private final ProficienciaRepository proficienciaRepository;

    public ProficienciaService(ProficienciaRepository proficienciaRepository) {
        this.proficienciaRepository = proficienciaRepository;
    }

    @Transactional
    public ProficienciaDtoResponse criarProficiencia(ProficienciaDtoRequest request){
        String descricao = request.getDescricao().trim();

        if(proficienciaRepository.existsByDescricaoIgnoreCase(descricao)){
            throw new ConflitoException("Proficiencia " + descricao + " já cadastrada");
        }

        Proficiencia proficiencia = new Proficiencia();
        proficiencia.setDescricao(descricao);

        proficiencia = proficienciaRepository.save(proficiencia);

        return toResponse(proficiencia);
    }

    private ProficienciaDtoResponse toResponse(Proficiencia proficiencia){
        return new ProficienciaDtoResponse(proficiencia.getIdProe(), proficiencia.getDescricao());
    }

    @Transactional(readOnly = true)
    public List<ProficienciaDtoResponse> listar(){
        return proficienciaRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional
    public void deletar(Integer id){
        Proficiencia proficiencia = proficienciaRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Proficiencia " + id + " não encontrado"));
        proficienciaRepository.delete(proficiencia);
    }
}
