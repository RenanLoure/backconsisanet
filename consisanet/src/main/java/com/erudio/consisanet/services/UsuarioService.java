package com.erudio.consisanet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erudio.consisanet.exceptions.ResourceNotFoundException;
import com.erudio.consisanet.model.Usuario;
import com.erudio.consisanet.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));
    }

    public Usuario criarUsuario(String nome) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Long id, String novoNome) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        usuario.setNome(novoNome);
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        usuarioRepository.delete(usuario);
    }
}
