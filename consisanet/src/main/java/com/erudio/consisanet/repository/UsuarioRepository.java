package com.erudio.consisanet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erudio.consisanet.model.Usuario;

/**
 * UsuarioRepository
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}