package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.LibroCarritoUsuario;
import model.LibroCarritoUsuarioPK;

public interface LibroCarritoUsuarioJPASpring extends JpaRepository<LibroCarritoUsuario, LibroCarritoUsuarioPK> {
    
}
