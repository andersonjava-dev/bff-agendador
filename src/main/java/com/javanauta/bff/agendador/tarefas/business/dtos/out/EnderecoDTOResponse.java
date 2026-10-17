package com.javanauta.bff.agendador.tarefas.business.dtos.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDTOResponse {

    private Long id;
    private String cidade;
    private String rua;
    private String numero;
    private String complemento;
    private String estado;
    private String cep;

}
