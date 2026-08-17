package com.pedidos.productservice.controller.Produto;

import com.pedidos.productservice.model.Produto;
import com.pedidos.productservice.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<Object> buscarProdutos(){
        return ResponseEntity.ok(produtoService.buscarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarProdutoPorId(@PathVariable Long id){
        return ResponseEntity.ok(produtoService.buscarProdutoPorId(id));
    }

    @GetMapping("/buscarProduto/{nome}")
    public ResponseEntity<Object> buscarProdutoPorNome(@PathVariable String nome){
        return ResponseEntity.ok(produtoService.buscarProdutoPorNome(nome));
    }

    @PostMapping()
    public ResponseEntity<Object> salvarProduto(@RequestBody Produto produto){
        produtoService.save(produto);
        return ResponseEntity.ok(produto);
    }

}
