package com.todo.api.demo.DTO;

import com.todo.api.demo.Model.Status;


import java.time.LocalTime;
import java.util.UUID;

public record TodoResponseDTO (
        UUID id,
        String titulo,
        String descricao,
        Status status,
        LocalTime dataCriacao,
        LocalTime dataConclusao
    ){
}
