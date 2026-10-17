package com.javanauta.bff.agendador.tarefas.controller;

import com.javanauta.bff.agendador.tarefas.business.TarefasService;
import com.javanauta.bff.agendador.tarefas.business.dtos.in.TarefasDTORequest;
import com.javanauta.bff.agendador.tarefas.business.dtos.out.TarefasDTOResponse;
import com.javanauta.bff.agendador.tarefas.business.enuns.StatusNotificacaoEnum;
import com.javanauta.bff.agendador.tarefas.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "cadatrar tarefas de usuário")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)

public class TarefasController {

    private final TarefasService tarefasService;


    @PostMapping
    @Operation(summary = "Salvar tarefa", description = "Criar uma nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> gravarTarefas(@RequestBody TarefasDTORequest dto,
                                                            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefas(dto, token));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Buscar tarefa por período ", description = "Buscar tarefas cadastrada por período")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "400", description = "Usuário já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscarTarefasAgendadaPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.buscarTarefasAgendadaPorPeriodo(dataInicial, dataFinal, token));
    }

    @GetMapping
    @Operation(summary = "Buscar lista de tarefas por email de Usuário",
            description = "Buscar tarefas cadastrada por usuário")
    @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscarTarefasPorEmail(@RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.buscarTarefasPorEmail(token));
    }

    @DeleteMapping
    @Operation(summary = "Deletar tarefas por id", description = "Deletar tarefa por id")
    @ApiResponse(responseCode = "200", description = "Tarefa deletada ")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deleteTarefaPorId(@RequestParam("id") String id,
                                                  @RequestHeader(name = "Authorization", required = false) String token) {
        tarefasService.deleteTarefaPorId(id, token);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Alterar status de tarefas", description = "Alterar status de tarefa")
    @ApiResponse(responseCode = "200", description = "Status da tarefa alterado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> alteraStatusPorNotificacao(@RequestParam StatusNotificacaoEnum status,
                                                                         @RequestParam("id") String id,
                                                                         @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.alteraStatusPorNotificacao(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Atualizar dados de tarefas", description = "Atualizar dados de tarefas")
    @ApiResponse(responseCode = "200", description = "Tarefa alterada")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> atualizarTarefas(@RequestBody TarefasDTORequest dto,
                                                               @RequestParam("id") String id,
                                                               @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.updateTarefas(id, dto, token));
    }
}
