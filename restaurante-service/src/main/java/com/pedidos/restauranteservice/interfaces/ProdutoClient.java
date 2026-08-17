package com.pedidos.restauranteservice.interfaces;
import com.pedidos.restauranteservice.DTO.ProdutoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "product-service")
public interface ProdutoClient {

    @GetMapping("/produtos/buscarProduto/{nome}")
    ProdutoDTO buscarProdutoPorNome(@PathVariable String nome);

}
