package com.pedidos.restauranteservice.repository;

import com.pedidos.restauranteservice.model.RestauranteModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RestauranteRepository extends MongoRepository<RestauranteModel, String> {
    Optional<RestauranteModel> findById(String id);
    Optional<RestauranteModel> findFirstByNome(String nome);
}
