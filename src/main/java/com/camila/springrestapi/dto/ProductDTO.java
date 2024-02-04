package com.camila.springrestapi.dto;

import java.util.UUID;

public record ProductDTO(UUID id, String categoria, String descricao, Integer valor) {
}
