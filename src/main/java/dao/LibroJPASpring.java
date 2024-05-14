package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import model.Libro;

public interface LibroJPASpring extends JpaRepository<Libro, Integer> {
    Libro findByTituloLibro(String tituloLibro);

    @Transactional
    @Modifying
    @Query("update Libro lib set lib.autorLibro = ?1, lib.descripcionLibro = ?2, lib.editorialLibro = ?3, lib.paginasLibro = ?4, lib.precioLibro = ?5 where lib.tituloLibro = ?6")
    void modifyByTitulo(String autorLibro, String descripcionLibro, String editorialLibro, int paginasLibro, double precioLibro, String tituloLibro);

    @Transactional
    @Modifying
    @Query("delete from Libro where tituloLibro = ?1")
    void deleteByTitulo(String tituloLibro);
}
