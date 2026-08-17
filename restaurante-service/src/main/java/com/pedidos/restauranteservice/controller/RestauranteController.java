package com.pedidos.restauranteservice.controller;

import com.pedidos.restauranteservice.DTO.AdicionarItemCardapioDTO;
import com.pedidos.restauranteservice.DTO.RestauranteDTO;
import com.pedidos.restauranteservice.model.ItemCardapio;
import com.pedidos.restauranteservice.model.RestauranteModel;
import com.pedidos.restauranteservice.service.RestauranteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @GetMapping
    public ResponseEntity<List<RestauranteModel>> listarRestaurantes() {
        return ResponseEntity.ok(restauranteService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<RestauranteModel> cadastrarRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restauranteService.cadastrarRestaurante(restauranteDTO));
    }

    @GetMapping("/{nome}/cardapio")
    public ResponseEntity<List<ItemCardapio>> buscarCardapio(@PathVariable String nome) {
        return ResponseEntity.ok(restauranteService.buscarCardapio(nome));
    }

    @PostMapping("/{nomeRestaurante}/cardapio/AdicionarItens")
    public ResponseEntity<ItemCardapio> adicionarItemAoCardapio(@PathVariable String nomeRestaurante, @RequestBody AdicionarItemCardapioDTO body) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restauranteService.adicionarProdutoAoCardapio(nomeRestaurante, body.getNomeProduto()));
    }
}