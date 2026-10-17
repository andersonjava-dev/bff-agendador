package com.javanauta.bff.agendador.tarefas.business.dtos.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDTORequest {

    private Long id;
    private String numero;
    private String ddd;
}
