package com.javanauta.bff.agendador.tarefas.business.dtos.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTORequest {

    private String nome;
    private String email;
    private String senha;

}
