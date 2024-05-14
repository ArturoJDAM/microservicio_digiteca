package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DigitecaDao;
import model.CarritoUsuario;
import model.Libro;
import model.Usuario;

@Service
public class DigitecaServiceImpl implements DigitecaService {
    @Autowired
    DigitecaDao dao;

    @Override
    public boolean agregarLibro(Libro libro) {
        if (dao.mostrarLibro(libro.getCodLibro()) == null) {
            dao.agregarLibro(libro);
            return true;
        }

        return false;
    }

    @Override
    public Libro mostrarLibro(int codLibro) {
        return dao.mostrarLibro(codLibro);
    }

    @Override
    public Libro mostrarLibroTitulo(String tituloLibro) {
        return dao.mostrarLibroTitulo(tituloLibro);
    }

    @Override
    public List<Libro> mostrarLibros() {
        return dao.mostrarLibros();
    }

    @Override
    public void modificarLibro(Libro libro) {
        if (dao.mostrarLibro(libro.getCodLibro()) != null) {
            dao.modificarLibro(libro);
        }
    }

    @Override
    public void modificarLibroTitulo(String tituloLibro, String nuevoAutor, String nuevaDescripcion, String nuevaEditorial,
                                int nuevasPaginas, double nuevoPrecio) {
        Libro libro = dao.mostrarLibroTitulo(tituloLibro);

        if (libro != null) {
            libro.setAutorLibro(nuevoAutor);
            libro.setDescripcionLibro(nuevaDescripcion);
            libro.setEditorialLibro(nuevaEditorial);
            libro.setPaginasLibro(nuevasPaginas);
            libro.setPrecioLibro(nuevoPrecio);

            dao.modificarLibro(libro);
        }
    }

    @Override
    public boolean eliminarLibro(int codLibro) {
        if (dao.mostrarLibro(codLibro) != null) {
            dao.eliminarLibro(codLibro);
            return true;
        }

        return false;
    }

    @Override
    public boolean eliminarLibroTitulo(String tituloLibro) {
        if (dao.mostrarLibroTitulo(tituloLibro) != null) {
            dao.eliminarLibroTitulo(tituloLibro);
            return true;
        }

        return false;
    }

    @Override
    public boolean agregarUsuario(Usuario usuario) {
        if (dao.mostrarUsuario(usuario.getCodUsuario()) == null) {
            dao.agregarUsuario(usuario);
            return true;
        }

        return false;
    }

    @Override
    public Usuario mostrarUsuario(int codUsuario) {
        return dao.mostrarUsuario(codUsuario);
    }

    @Override
    public List<Usuario> mostrarUsuarios() {
        return dao.mostrarUsuarios();
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        if (dao.mostrarUsuario(usuario.getCodUsuario()) != null) {
            dao.modificarUsuario(usuario);
        }
    }

    @Override
    public boolean eliminarUsuario(int codUsuario) {
        if (dao.mostrarUsuario(codUsuario) != null) {
            dao.eliminarUsuario(codUsuario);
            return true;
        }

        return false;
    }

    @Override
    public boolean agregarCarrito(CarritoUsuario carrito) {
        if (dao.mostrarCarrito(carrito.getCodCarrito()) == null) {
            dao.agregarCarrito(carrito);
            return true;
        }

        return false;
    }

    @Override
    public CarritoUsuario mostrarCarrito(int codUsuario) {
        return dao.mostrarCarrito(codUsuario);
    }

    @Override
    public void modificarCarrito(CarritoUsuario carrito) {
        if (dao.mostrarCarrito(carrito.getCodCarrito()) != null) {
            dao.modificarCarrito(carrito);
        }
    }

    @Override
    public boolean eliminarCarrito(int codCarrito) {
        if (dao.mostrarCarrito(codCarrito) != null) {
            dao.eliminarCarrito(codCarrito);
            return true;
        }

        return false;
    }

    @Override
    public boolean agregarLibroCarrito(int codUsuario, int codLibro, int cantidad) {
        CarritoUsuario carrito = dao.mostrarCarrito(codUsuario);

        if (carrito == null) {
            dao.agregarLibroCarrito(codUsuario, codLibro, cantidad);
            return true;
        }
        
        return false;
    }

    @Override
    public void modificarCantidadLibroCarrito(int codUsuario, int codLibro, int cantidad) {
        CarritoUsuario carrito = dao.mostrarCarrito(codUsuario);

        if (carrito != null) {
            dao.modificarCantidadLibroCarrito(codUsuario, codLibro, cantidad);
        }
    }

    @Override
    public boolean eliminarLibroCarrito(int codUsuario, int codLibro) {
        CarritoUsuario carrito = dao.mostrarCarrito(codUsuario);

        if (carrito != null) {
            dao.eliminarLibroCarrito(codUsuario, codLibro);
            return true;
        }
        
        return false;
    }
}
