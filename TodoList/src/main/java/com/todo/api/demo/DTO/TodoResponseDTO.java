package com.todo.api.demo.DTO;

import com.todo.api.demo.Model.Status;

public record TodoResponseDTO (
        String titulo,
        String descricao,
        Status status){
}
