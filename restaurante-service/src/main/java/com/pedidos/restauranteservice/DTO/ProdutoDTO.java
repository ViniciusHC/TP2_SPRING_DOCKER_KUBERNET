package com.pedidos.restauranteservice.DTO;

import lombok.Data;

@Data
public class ProdutoDTO {

    Long id;
    String nome;
    Integer preco;
    Integer estoque;
}
