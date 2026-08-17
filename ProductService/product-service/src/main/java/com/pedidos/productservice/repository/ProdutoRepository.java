package com.pedidos.productservice.repository;
import com.pedidos.productservice.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findById(Long id);
    Optional<Produto> findFirstByNome(String nome);
}
