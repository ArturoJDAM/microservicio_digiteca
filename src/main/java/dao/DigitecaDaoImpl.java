package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import model.CarritoUsuario;
import model.Libro;
import model.LibroCarritoUsuario;
import model.LibroCarritoUsuarioPK;
import model.Usuario;

@Repository
@Transactional
public class DigitecaDaoImpl implements DigitecaDao {
    @Autowired
    LibroJPASpring libroJpa;

    @Autowired
    UsuarioJPASpring usuarioJpa;
    
    @Autowired
    CarritoUsuarioJPASpring carritoJpa;

    @Autowired
    LibroCarritoUsuarioJPASpring libCarUsuJpa;

    @Override
    public void agregarLibro(Libro libro) {
        if (!libroJpa.findById(libro.getCodLibro()).isPresent()) {
            libroJpa.save(libro);
        } else {
            System.err.println("El libro ya existe en la base de datos");
        }
    }

    @Override
    public Libro mostrarLibro(int codLibro) {
        return libroJpa.findById(codLibro).orElse(null);
    }

    @Override
    public Libro mostrarLibroTitulo(String tituloLibro) {
        return libroJpa.findByTituloLibro(tituloLibro);
    }

    @Override
    public List<Libro> mostrarLibros() {
        return libroJpa.findAll();
    }

    @Override
    public void modificarLibro(Libro libro) {
        libroJpa.save(libro);
    }

    @Override
    public void modificarLibroTitulo(String tituloLibro, String nuevoAutor, String nuevaDescripcion,
            String nuevaEditorial, int nuevasPaginas, double nuevoPrecio) {
        Libro libro = libroJpa.findByTituloLibro(tituloLibro);
        
        libro.setAutorLibro(nuevoAutor);
        libro.setDescripcionLibro(nuevaDescripcion);
        libro.setEditorialLibro(nuevaEditorial);
        libro.setPaginasLibro(nuevasPaginas);
        libro.setPrecioLibro(nuevoPrecio);

        libroJpa.save(libro);
    }

    @Override
    public void eliminarLibro(int codLibro) {
        libroJpa.deleteById(codLibro);
    }

    @Override
    public void eliminarLibroTitulo(String tituloLibro) {
        libroJpa.deleteByTitulo(tituloLibro);
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        if (!usuarioJpa.findById(usuario.getCodUsuario()).isPresent()) {
            usuarioJpa.save(usuario);
        } else {
            System.err.println("El usuario ya existe en la base de datos");
        }
    }

    @Override
    public Usuario mostrarUsuario(int codUsuario) {
        return usuarioJpa.findById(codUsuario).orElse(null);
    }

    @Override
    public List<Usuario> mostrarUsuarios() {
        return usuarioJpa.findAll();
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        usuarioJpa.save(usuario);
    }

    @Override
    public void eliminarUsuario(int codUsuario) {
        usuarioJpa.deleteById(codUsuario);
    }

    @Override
    public void agregarCarrito(CarritoUsuario carrito) {
        if (!carritoJpa.findById(carrito.getCodCarrito()).isPresent()) {
            carritoJpa.save(carrito);
        } else {
            System.err.println("El carrito ya existe en la base de datos");
        }
    }

    @Override
    public CarritoUsuario mostrarCarrito(int codUsuario) {
        return carritoJpa.findById(codUsuario).orElse(null);
    }

    @Override
    public void modificarCarrito(CarritoUsuario carrito) {
        carritoJpa.save(carrito);
    }

    @Override
    public void eliminarCarrito(int codCarrito) {
        carritoJpa.deleteById(codCarrito);
    }

    @Override
    public void agregarLibroCarrito(int codUsuario, int codLibro, int cantidad) {
        CarritoUsuario carrito = mostrarCarrito(codUsuario);
        Libro libro = mostrarLibro(codLibro);

        LibroCarritoUsuario libroCarritoUsuario = new LibroCarritoUsuario();
        libroCarritoUsuario.setCarritoUsuario(carrito);
        libroCarritoUsuario.setLibro(libro);
        libroCarritoUsuario.setCantidad(cantidad);

        libCarUsuJpa.save(libroCarritoUsuario);
    }

    @Override
    public void modificarCantidadLibroCarrito(int codUsuario, int codLibro, int cantidad) {
        CarritoUsuario carrito = mostrarCarrito(codUsuario);
        Libro libro = mostrarLibro(codLibro);

        LibroCarritoUsuario libroCarritoUsuario = new LibroCarritoUsuario();
        libroCarritoUsuario.setCarritoUsuario(carrito);
        libroCarritoUsuario.setLibro(libro);
        libroCarritoUsuario.setCantidad(cantidad);

        libCarUsuJpa.save(libroCarritoUsuario);
    }

    @Override
    public void eliminarLibroCarrito(int codUsuario, int codLibro) {
        CarritoUsuario carrito = mostrarCarrito(codUsuario);

        LibroCarritoUsuarioPK libroCarritoUsuarioPK = new LibroCarritoUsuarioPK();
        libroCarritoUsuarioPK.setCodCarrito(carrito.getCodCarrito());
        libroCarritoUsuarioPK.setCodLibro(codLibro);

        LibroCarritoUsuario libroCarritoUsuario = libCarUsuJpa.getReferenceById(libroCarritoUsuarioPK);

        if (libroCarritoUsuario != null) {
            libCarUsuJpa.delete(libroCarritoUsuario);
        }
    }
}
