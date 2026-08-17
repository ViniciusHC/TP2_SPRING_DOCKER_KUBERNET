package com.pedidos.productservice.service;

import com.pedidos.productservice.model.Produto;
import com.pedidos.productservice.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    public void save(Produto produto) {
        produtoRepository.save(produto);
    }


    public List<Produto> buscarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto buscarProdutoPorNome(String nome) {
        return produtoRepository.findFirstByNome(nome).orElse(null);
    }


}
