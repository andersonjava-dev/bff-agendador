package com.javanauta.bff.agendador.tarefas.infrastructure.client;

import com.javanauta.bff.agendador.tarefas.business.dtos.in.EnderecoDTORequest;
import com.javanauta.bff.agendador.tarefas.business.dtos.in.LoginRequest;
import com.javanauta.bff.agendador.tarefas.business.dtos.in.TelefoneDTORequest;
import com.javanauta.bff.agendador.tarefas.business.dtos.in.UsuarioDTORequest;
import com.javanauta.bff.agendador.tarefas.business.dtos.out.EnderecoDTOResponse;
import com.javanauta.bff.agendador.tarefas.business.dtos.out.TelefoneDTOResponse;
import com.javanauta.bff.agendador.tarefas.business.dtos.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                           @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);


    @PostMapping("/login")
    String login(@RequestBody LoginRequest usuarioDTO);


    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);


    @PutMapping
    UsuarioDTOResponse atualizarDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                             @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizarEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);


    @PutMapping("/telefone")
    TelefoneDTOResponse atualizarTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastrarEndereco(@RequestBody EnderecoDTORequest dto,
                                          @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastrarTelefone(@RequestBody TelefoneDTORequest dto,
                                          @RequestHeader("Authorization") String token);
}







