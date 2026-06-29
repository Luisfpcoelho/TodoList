package com.todo.api.demo.DTO;

public record TodoRequestUpdateDTO(
        String titulo,
        String descricao,
        boolean concluido) {


}
