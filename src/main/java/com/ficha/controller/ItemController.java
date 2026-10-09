package com.ficha.controller;

import com.ficha.dto.request.ItemDtoRequest;
import com.ficha.dto.response.ItemDtoResponse;
import com.ficha.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemDtoResponse> criarItem(@Valid @RequestBody ItemDtoRequest request){
        ItemDtoResponse item = itemService.criarItem(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @GetMapping
    public ResponseEntity<List<ItemDtoResponse>> listar(){
        return ResponseEntity.ok(itemService.listar());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        itemService.deletarItem(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDtoResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody ItemDtoRequest request){
        return ResponseEntity.ok(itemService.atualizarItem(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDtoResponse> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(itemService.buscarPorId(id));
    }
}
