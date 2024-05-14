package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Usuario;

public interface UsuarioJPASpring extends JpaRepository<Usuario, Integer> {
    
}
