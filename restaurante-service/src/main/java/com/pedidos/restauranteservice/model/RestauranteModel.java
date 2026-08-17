package com.pedidos.restauranteservice.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "restaurantes")
public class RestauranteModel {

    @Id
    private String id;

    private String nome;
    private String endereco;
    private List<ItemCardapio> cardapio = new ArrayList<>();

}
