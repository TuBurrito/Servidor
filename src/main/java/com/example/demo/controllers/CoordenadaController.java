package com.example.demo.controllers;

import com.example.demo.models.Coordenada;
import com.example.demo.services.CoordenadaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CoordenadaController {

    private final CoordenadaService service;

    @PostMapping("/insert-coordenada")
    public ResponseEntity<String> insertCoordenada(@RequestParam Double latitud,@RequestParam Double longitud){
        return service.insertCoordenada(latitud, longitud);
    }

    @GetMapping("/obtener-coordenada")
    public ResponseEntity<Coordenada> getLastCoordenada(){
        return service.getLastCoordenada();
    }
}
