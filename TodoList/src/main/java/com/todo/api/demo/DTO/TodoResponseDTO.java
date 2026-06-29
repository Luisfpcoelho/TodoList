package com.todo.api.demo.DTO;

import com.todo.api.demo.Model.Status;
import com.todo.api.demo.Model.Todo;


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
    public TodoResponseDTO(Todo todo) {
        this(
                todo.getId(),
                todo.getTitulo(),
                todo.getDescricao(),
                todo.getConcluido(),
                todo.getDataCriacao(),
                todo.getDataConclusao()
        );
    }
}
