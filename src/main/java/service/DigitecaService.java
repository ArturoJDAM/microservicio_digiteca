package service;

import java.util.List;

import model.CarritoUsuario;
import model.Libro;
import model.Usuario;

public interface DigitecaService {
    boolean agregarLibro(Libro libro);
    Libro mostrarLibro(int codLibro);
    Libro mostrarLibroTitulo(String tituloLibro);
    List<Libro> mostrarLibros();
    void modificarLibro(Libro libro);
    void modificarLibroTitulo(String tituloLibro, String nuevoAutor, String nuevaDescripcion, String nuevaEditorial,
                        int nuevasPaginas, double nuevoPrecio);
    boolean eliminarLibro(int codLibro);
    boolean eliminarLibroTitulo(String tituloLibro);

    boolean agregarUsuario(Usuario usuario);
    Usuario mostrarUsuario(int codUsuario);
    List<Usuario> mostrarUsuarios();
    void modificarUsuario(Usuario usuario);
    boolean eliminarUsuario(int codUsuario);

    boolean agregarCarrito(CarritoUsuario carrito);
    CarritoUsuario mostrarCarrito(int codUsuario);
    void modificarCarrito(CarritoUsuario carrito);
    boolean eliminarCarrito(int codCarrito);
    boolean agregarLibroCarrito(int codUsuario, int codLibro, int cantidad);
    void modificarCantidadLibroCarrito(int codUsuario, int codLibro, int cantidad);
    boolean eliminarLibroCarrito(int codUsuario, int codLibro);
}
