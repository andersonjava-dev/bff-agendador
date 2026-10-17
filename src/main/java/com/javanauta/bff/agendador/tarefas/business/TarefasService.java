package com.javanauta.bff.agendador.tarefas.business;


import com.javanauta.bff.agendador.tarefas.business.dtos.in.TarefasDTORequest;
import com.javanauta.bff.agendador.tarefas.business.dtos.out.TarefasDTOResponse;
import com.javanauta.bff.agendador.tarefas.business.enuns.StatusNotificacaoEnum;
import com.javanauta.bff.agendador.tarefas.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;

    public TarefasDTOResponse gravarTarefas(TarefasDTORequest dto, String token) {
        return tarefasClient.gravarTarefas(dto, token);

    }

    public List<TarefasDTOResponse> buscarTarefasAgendadaPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal, String token) {
        return tarefasClient.buscarTarefasAgendadaPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscarTarefasPorEmail(String token) {
        return tarefasClient.buscarTarefasPorEmail(token);
    }


    public void deleteTarefaPorId(String id, String token) {
        tarefasClient.deleteTarefaPorId(id, token);
    }

    public TarefasDTOResponse alteraStatusPorNotificacao(StatusNotificacaoEnum status, String id, String token) {
        return tarefasClient.alteraStatusPorNotificacao(status, id, token);
    }

    public TarefasDTOResponse updateTarefas(String id, TarefasDTORequest dto, String token) {
        return tarefasClient.atualizarTarefas(dto, id, token);
    }
}
