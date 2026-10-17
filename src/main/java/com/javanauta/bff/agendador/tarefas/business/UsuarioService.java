package com.javanauta.bff.agendador.tarefas.business;


import com.javanauta.bff.agendador.tarefas.business.dtos.in.EnderecoDTORequest;
import com.javanauta.bff.agendador.tarefas.business.dtos.in.LoginRequest;
import com.javanauta.bff.agendador.tarefas.business.dtos.in.TelefoneDTORequest;
import com.javanauta.bff.agendador.tarefas.business.dtos.in.UsuarioDTORequest;
import com.javanauta.bff.agendador.tarefas.business.dtos.out.EnderecoDTOResponse;
import com.javanauta.bff.agendador.tarefas.business.dtos.out.TelefoneDTOResponse;
import com.javanauta.bff.agendador.tarefas.business.dtos.out.UsuarioDTOResponse;
import com.javanauta.bff.agendador.tarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO) {
        return usuarioClient.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequest usuarioDTO) {
        return usuarioClient.login(usuarioDTO);
    }


    public UsuarioDTOResponse buscaUsuarioPorEmail(String email, String token) {
        return usuarioClient.buscaUsuarioPorEmail(email, token);

    }

    public void deletaUsuarioPorEmail(String email, String token) {
        usuarioClient.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizarDadosUsuario(UsuarioDTORequest dto, String token) {
        return usuarioClient.atualizarDadosUsuario(dto, token);
    }

    public EnderecoDTOResponse altulizarEndereco(EnderecoDTORequest dto, Long id, String token) {
        return usuarioClient.atualizarEndereco(dto, id, token);
    }


    public TelefoneDTOResponse atualizarTelefone(Long idTelefone, TelefoneDTORequest dto, String token) {
        return usuarioClient.atualizarTelefone(dto, idTelefone, token);
    }


    public EnderecoDTOResponse cadastrarEndereco(String token, EnderecoDTORequest dto) {
        return usuarioClient.cadastrarEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastrarTelefone(String token, TelefoneDTORequest dto) {
        return usuarioClient.cadastrarTelefone(dto, token);


    }
}















