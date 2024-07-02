package com.example.demo.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
@ToString
@Builder
@Data
@AllArgsConstructor
public class Coordenada {
    private UUID id;
    private Double latitud;
    private Double longitud;
    private LocalDateTime registro;
}
