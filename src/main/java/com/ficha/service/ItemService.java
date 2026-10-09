package com.ficha.service;

import com.ficha.Entity.Item;
import com.ficha.dto.request.ItemDtoRequest;
import com.ficha.dto.response.ItemDtoResponse;
import com.ficha.exception.RecursoNaoEncontradoException;
import com.ficha.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;


    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public ItemDtoResponse criarItem(ItemDtoRequest request){
        Item item = new Item();

        item.setNome(request.getNome());
        item.setPesoItem(request.getPesoItem());

        item = itemRepository.save(item);

        return toResponse(item);
    }

    private ItemDtoResponse toResponse(Item item) {
        return new ItemDtoResponse(item.getIdItem(), item.getNome(), item.getPesoItem());
    }

    @Transactional(readOnly = true)
    public List<ItemDtoResponse> listar(){
        return itemRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional
    public void deletarItem(Integer id){
        Item item = itemRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Item " + id + " não encontrado"));
        itemRepository.delete(item);
    }

    private Item buscarEntidade(Integer id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Item " + id + " não encontrado"));
    }

    @Transactional(readOnly = true)
    public ItemDtoResponse buscarPorId(Integer id) {
        return toResponse(buscarEntidade(id));
    }

    @Transactional
    public ItemDtoResponse atualizarItem(Integer id, ItemDtoRequest request) {
        Item item = buscarEntidade(id);
        item.setNome(request.getNome());
        item.setPesoItem(request.getPesoItem());
        return toResponse(item);
    }

}
