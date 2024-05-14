package model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "carritoUsuario")
@NamedQuery(name = "CarritoUsuario.findAll", query = "SELECT carU FROM CarritoUsuario carU")
public class CarritoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codCarrito;

    @ManyToOne
    @JoinColumn(name = "codUsuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "carritoUsuario")
	private List<LibroCarritoUsuario> libroCarritoUsuarios;

	public CarritoUsuario() {
	}

	public int getCodCarrito() {
		return this.codCarrito;
	}

	public void setCodCarrito(int codCarrito) {
		this.codCarrito = codCarrito;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<LibroCarritoUsuario> getLibroCarritoUsuarios() {
		return this.libroCarritoUsuarios;
	}

	public void setLibroCarritoUsuarios(List<LibroCarritoUsuario> libroCarritoUsuarios) {
		this.libroCarritoUsuarios = libroCarritoUsuarios;
	}

	public LibroCarritoUsuario addLibroCarritoUsuario(LibroCarritoUsuario libroCarritoUsuario) {
		getLibroCarritoUsuarios().add(libroCarritoUsuario);
		libroCarritoUsuario.setCarritoUsuario(this);

		return libroCarritoUsuario;
	}

	public LibroCarritoUsuario removeLibroCarritoUsuario(LibroCarritoUsuario libroCarritoUsuario) {
		getLibroCarritoUsuarios().remove(libroCarritoUsuario);
		libroCarritoUsuario.setCarritoUsuario(null);

		return libroCarritoUsuario;
	}
}
