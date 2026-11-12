package com.login.system.login_system.business;


import com.login.system.login_system.database.entitys.Usuario;
import com.login.system.login_system.database.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService{

        private final UsuarioRepository repository;

        public UsuarioService(UsuarioRepository repository){
            this.repository = repository;
        }

        public void salvarUsuario(Usuario usuario){
                repository.save(usuario);
        }

        public Usuario buscarUsuarioPorEmail(String email){
                return repository.findByEmail(email).orElseThrow(
                        () -> new RuntimeException("Email nao encontrado.")
                );
        }

        public Usuario buscarUsuarioPorId(Integer id){
                return repository.findById(id).orElseThrow(
                        () -> new RuntimeException("Id nao encontrado.")
                );
        }

        public Usuario buscarUsuarioPorTelefone(String telefone){
                return repository.findByTelefone(telefone).orElseThrow(
                        () -> new RuntimeException("Telefone nao encontrado.")
                );
        }

        public void deletarUsuarioPorEmail(String email){
                repository.deleteByEmail(email);
        }

        public void atualizarUsuarioPorId(Integer id, Usuario usuario){
                Usuario usuarioEntity = repository.findById(id).orElseThrow(() ->
                        new RuntimeException("Usuario nao encontrado."));
                Usuario usuarioAtualizado = Usuario.builder()
                        .email(usuario.getEmail() != null ? usuario.getEmail():
                                usuarioEntity.getEmail())
                        .email(usuario.getEmail() != null ? usuario.getNome():
                                usuarioEntity.getNome())
                        .telefone(usuario.getTelefone() != null ? usuario.getTelefone():
                                usuarioEntity.getTelefone())
                        .id(usuario.getId())
                        .build();
        }

    }

