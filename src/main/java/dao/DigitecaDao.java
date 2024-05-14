package dao;

import java.util.List;

import model.CarritoUsuario;
import model.Libro;
import model.Usuario;

public interface DigitecaDao {
    void agregarLibro(Libro libro);
    Libro mostrarLibro(int codLibro);
    Libro mostrarLibroTitulo(String tituloLibro);
    List<Libro> mostrarLibros();
    void modificarLibro(Libro libro);
    void modificarLibroTitulo(String tituloLibro, String nuevoAutor, String nuevaDescripcion, String nuevaEditorial,
                        int nuevasPaginas, double nuevoPrecio);
    void eliminarLibro(int codLibro);
    void eliminarLibroTitulo(String tituloLibro);

    void agregarUsuario(Usuario usuario);
    Usuario mostrarUsuario(int codUsuario);
    List<Usuario> mostrarUsuarios();
    void modificarUsuario(Usuario usuario);
    void eliminarUsuario(int codUsuario);

    void agregarCarrito(CarritoUsuario carrito);
    CarritoUsuario mostrarCarrito(int codUsuario);
    void modificarCarrito(CarritoUsuario carrito);
    void eliminarCarrito(int codCarrito);
    void agregarLibroCarrito(int codUsuario, int codLibro, int cantidad);
    void modificarCantidadLibroCarrito(int codUsuario, int codLibro, int cantidad);
    void eliminarLibroCarrito(int codUsuario, int codLibro);
}
