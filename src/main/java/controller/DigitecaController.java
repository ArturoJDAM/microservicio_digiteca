package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.CarritoUsuario;
import model.Libro;
import model.Usuario;
import service.DigitecaService;

@RestController
@RequestMapping("/digiteca")
public class DigitecaController {
    @Autowired
    DigitecaService service;

    @GetMapping(value = "/libro/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Libro mostrarLibro(@PathVariable("id") int id) {
        return service.mostrarLibro(id);
    }

    @GetMapping(value = "/libro/{titulo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Libro mostrarLibroTitulo(@PathVariable("titulo") String titulo) {
        return service.mostrarLibroTitulo(titulo);
    }

    @GetMapping(value = "/libros", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Libro> mostrarLibros() {
        return service.mostrarLibros();
    }

    @PostMapping(value = "/libro", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String agregarLibro(@RequestBody Libro libro) {
        return String.valueOf(service.agregarLibro(libro));
    }

    @PutMapping(value = "/modLibro/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void modificarLibro(@RequestBody Libro libro, @PathVariable("id") int id) {
        service.modificarLibro(libro);
    }

    @PutMapping(value = "/modiLibro/{titulo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void modificarLibroTitulo(@RequestBody Libro libro, @PathVariable("titulo") String titulo) {
        service.modificarLibroTitulo(titulo, libro.getAutorLibro(), libro.getDescripcionLibro(), 
                                    libro.getEditorialLibro(), libro.getPaginasLibro(), libro.getPrecioLibro());
    }

    @DeleteMapping(value = "/delLibro/{id}")
    public void eliminarLibro(@PathVariable("id") int id) {
        service.eliminarLibro(id);
    }

    @DeleteMapping(value = "/deleLibro/{titulo}")
    public void eliminarLibroTitulo(@PathVariable("titulo") String titulo) {
        service.eliminarLibroTitulo(titulo);
    }

    @GetMapping(value = "/usuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario mostrarUsuario(@PathVariable("id") int id) {
        return service.mostrarUsuario(id);
    }

    @GetMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> mostrarUsuarios() {
        return service.mostrarUsuarios();
    }

    @PostMapping(value = "/usuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String agregarUsuario(@RequestBody Usuario usuario) {
        return String.valueOf(service.agregarUsuario(usuario));
    }

    @PutMapping(value = "/modUsuario/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void modificarUsuario(@RequestBody Usuario usuario, @PathVariable("id") int id) {
        service.modificarUsuario(usuario);
    }

    @DeleteMapping(value = "/delUsuario/{id}")
    public void eliminarUsuario(@PathVariable("id") int id) {
        service.eliminarUsuario(id);
    }

    @GetMapping(value = "/carrito/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CarritoUsuario mostrarCarrito(@PathVariable("id") int id) {
        return service.mostrarCarrito(id);
    }

    @PostMapping(value = "/carrito", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String agregarCarrito(@RequestBody CarritoUsuario carrito) {
        return String.valueOf(service.agregarCarrito(carrito));
    }

    @PutMapping(value = "/carrito", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void modificarCarrito(@RequestBody CarritoUsuario carrito) {
        service.modificarCarrito(carrito);
    }

    @DeleteMapping(value = "/carrito/{id}")
    public void eliminarCarrito(@PathVariable("id") int id) {
        service.eliminarCarrito(id);
    }

    @PostMapping(value = "/carrito/agregarLibro", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String agregarLibroCarritoUsuario(@RequestBody int codUsuario, int codLibro, int cantidad) {
        return String.valueOf(service.agregarLibroCarrito(codUsuario, codLibro, cantidad));
    }

    @PutMapping(value = "/carrito/modificarLibro", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void modificarCantidadLibroCarrito(@RequestBody int codUsuario, int codLibro, int cantidad) {
        service.modificarCantidadLibroCarrito(codUsuario, codLibro, cantidad);
    }

    @DeleteMapping(value = "/carrito/{idUsu}/{idLib}")
    public void eliminarLibroCarritoUsuario(@PathVariable("idUsu") int idUsu, @PathVariable("idLib") int idLib) {
        service.eliminarLibroCarrito(idUsu, idLib);
    }
}
