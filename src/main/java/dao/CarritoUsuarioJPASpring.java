package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.CarritoUsuario;

public interface CarritoUsuarioJPASpring extends JpaRepository<CarritoUsuario, Integer> {
    
}
