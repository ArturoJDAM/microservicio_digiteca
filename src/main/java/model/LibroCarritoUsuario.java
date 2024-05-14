package model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "libroCarritoUsuario")
@NamedQuery(name = "LibroCarritoUsuario.findAll", query = "SELECT libCarU FROM LibroCarritoUsuario libCarU")
public class LibroCarritoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LibroCarritoUsuarioPK id;

	private int cantidad;

	@ManyToOne
	@JoinColumn(name="codCarrito")
	private CarritoUsuario carritoUsuario;

	@ManyToOne
	@JoinColumn(name="codLibro")
	private Libro libro;

	public LibroCarritoUsuario() {
	}

	public LibroCarritoUsuarioPK getId() {
		return this.id;
	}

	public void setId(LibroCarritoUsuarioPK id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public CarritoUsuario getCarritoUsuario() {
		return this.carritoUsuario;
	}

	public void setCarritoUsuario(CarritoUsuario carritoUsuario) {
		this.carritoUsuario = carritoUsuario;
	}

	public Libro getLibro() {
		return this.libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
}
