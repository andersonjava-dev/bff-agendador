package com.javanauta.bff.agendador.tarefas.business.dtos.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDTORequest {

    private Long id;
    private String cidade;
    private String rua;
    private String numero;
    private String complemento;
    private String estado;
    private String cep;

}
