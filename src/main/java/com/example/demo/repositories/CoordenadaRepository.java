package com.example.demo.repositories;

import com.example.demo.models.Coordenada;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CoordenadaRepository extends MongoRepository<Coordenada, UUID> {
}
