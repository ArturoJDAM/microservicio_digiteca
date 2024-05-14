package model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "listaUsuario")
@NamedQuery(name = "ListaUsuario.findAll", query = "SELECT listU FROM ListaUsuario listU")
public class ListaUsuario implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codLista;

	@ManyToMany
	@JoinTable(
		name = "libroListaUsuario"
		, joinColumns = {
			@JoinColumn(name = "codLista")
			}
		, inverseJoinColumns = {
			@JoinColumn(name = "codLibro")
			}
		)
	private List<Libro> libros;

	@ManyToOne
	@JoinColumn(name = "codUsuario")
	private Usuario usuario;

	public ListaUsuario() {
	}

	public int getCodLista() {
		return this.codLista;
	}

	public void setCodLista(int codLista) {
		this.codLista = codLista;
	}

	public List<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
