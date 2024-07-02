package com.example.demo.services;

import com.example.demo.models.Coordenada;
import com.example.demo.repositories.CoordenadaRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CoordenadaService {

    private final CoordenadaRepository repository;

    public ResponseEntity<String> insertCoordenada(Double latitud, Double longitud){
        Coordenada coordenada = Coordenada.builder()
                .id(UUID.randomUUID())
                .latitud(latitud)
                .longitud(longitud)
                .registro(LocalDateTime.now())
                .build();
        repository.save(coordenada);
        return ResponseEntity.ok("Coordenada ingresada exitosamente");
    }
    public ResponseEntity<Coordenada> getLastCoordenada(){
        return ResponseEntity.ok(repository.findAll().stream().max(new Comparator<Coordenada>() {
            @Override
            public int compare(Coordenada o1, Coordenada o2) {
                return o1.getRegistro().compareTo(o2.getRegistro());
            }
        }).orElse(null));
    }

}
