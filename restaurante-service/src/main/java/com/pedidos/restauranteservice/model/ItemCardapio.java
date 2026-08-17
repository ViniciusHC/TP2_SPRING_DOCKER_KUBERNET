package com.pedidos.restauranteservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCardapio {

    private Long idProduto;
    private String nome;
    private Integer preco;

}
