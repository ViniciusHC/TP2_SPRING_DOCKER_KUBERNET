package com.pedidos.restauranteservice.service;

import com.pedidos.restauranteservice.DTO.ProdutoDTO;
import com.pedidos.restauranteservice.DTO.RestauranteDTO;
import com.pedidos.restauranteservice.interfaces.ProdutoClient;
import com.pedidos.restauranteservice.model.ItemCardapio;
import com.pedidos.restauranteservice.model.RestauranteModel;
import com.pedidos.restauranteservice.repository.RestauranteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;
    private final ProdutoClient produtoClient;

    public RestauranteService(RestauranteRepository restauranteRepository, ProdutoClient produtoClient) {
        this.restauranteRepository = restauranteRepository;
        this.produtoClient = produtoClient;
    }

    public List<RestauranteModel> listarTodos() {
        return restauranteRepository.findAll();
    }

    public RestauranteModel cadastrarRestaurante(RestauranteDTO dto) {
        RestauranteModel restaurante = new RestauranteModel();
        restaurante.setNome(dto.getNome());
        restaurante.setEndereco(dto.getEndereco());
        restaurante.setCardapio(new ArrayList<>());
        return restauranteRepository.save(restaurante);
    }

    public List<ItemCardapio> buscarCardapio(String nomeRestaurante) {
        RestauranteModel restaurante = buscarPorNome(nomeRestaurante);
        return restaurante.getCardapio();
    }

    public ItemCardapio adicionarProdutoAoCardapio(String nomeRestaurante, String nomeProduto) {
        RestauranteModel restaurante = buscarPorNome(nomeRestaurante);

        ProdutoDTO produtoDTO = produtoClient.buscarProdutoPorNome(nomeProduto.trim());

        ItemCardapio novoItem = new ItemCardapio(
                produtoDTO.getId(),
                produtoDTO.getNome(),
                produtoDTO.getPreco()
        );

        restaurante.getCardapio().add(novoItem);
        restauranteRepository.save(restaurante);

        return novoItem;
    }

    private RestauranteModel buscarPorNome(String nome) {
        return restauranteRepository.findFirstByNome(nome)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado: " + nome));
    }
}