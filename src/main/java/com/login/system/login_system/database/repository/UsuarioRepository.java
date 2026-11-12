package com.login.system.login_system.database.repository;

import com.login.system.login_system.database.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Transactional
    void deleteByEmail(String email);
    void deleteById(Integer id);

    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findById(Integer id);
    Optional<Usuario> findByTelefone(String telefone);



}
