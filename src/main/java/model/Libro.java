package model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
@NamedQuery(name = "Libro.findAll", query = "SELECT lib FROM Libro lib")
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codLibro;

	private String autorLibro;
	private String descripcionLibro;
	private String editorialLibro;
	private String tituloLibro;
	private int paginasLibro;
	private double precioLibro;

	@OneToMany(mappedBy = "libro")
	private List<Lectura> lecturas;

	@OneToMany(mappedBy = "libro")
	private List<LibroCarritoUsuario> libroCarritoUsuarios;

	@ManyToMany(mappedBy = "libros")
	private List<ListaUsuario> listaUsuarios;

	public Libro() {
	}

	public int getCodLibro() {
		return this.codLibro;
	}

	public void setCodLibro(int codLibro) {
		this.codLibro = codLibro;
	}

	public String getAutorLibro() {
		return this.autorLibro;
	}

	public void setAutorLibro(String autorLibro) {
		this.autorLibro = autorLibro;
	}

	public String getDescripcionLibro() {
		return this.descripcionLibro;
	}

	public void setDescripcionLibro(String descripcionLibro) {
		this.descripcionLibro = descripcionLibro;
	}

	public String getEditorialLibro() {
		return this.editorialLibro;
	}

	public void setEditorialLibro(String editorialLibro) {
		this.editorialLibro = editorialLibro;
	}

	public String getTituloLibro() {
		return this.tituloLibro;
	}

	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public int getPaginasLibro() {
		return this.paginasLibro;
	}

	public void setPaginasLibro(int paginasLibro) {
		this.paginasLibro = paginasLibro;
	}

	public double getPrecioLibro() {
		return this.precioLibro;
	}

	public void setPrecioLibro(double precioLibro) {
		this.precioLibro = precioLibro;
	}

	public List<Lectura> getLecturas() {
		return this.lecturas;
	}

	public void setLecturas(List<Lectura> lecturas) {
		this.lecturas = lecturas;
	}

	public Lectura addLectura(Lectura lectura) {
		getLecturas().add(lectura);
		lectura.setLibro(this);

		return lectura;
	}

	public Lectura removeLectura(Lectura lectura) {
		getLecturas().remove(lectura);
		lectura.setLibro(null);

		return lectura;
	}

	public List<LibroCarritoUsuario> getLibroCarritoUsuarios() {
		return this.libroCarritoUsuarios;
	}

	public void setLibroCarritoUsuarios(List<LibroCarritoUsuario> libroCarritoUsuarios) {
		this.libroCarritoUsuarios = libroCarritoUsuarios;
	}

	public LibroCarritoUsuario addLibroCarritoUsuario(LibroCarritoUsuario libroCarritoUsuario) {
		getLibroCarritoUsuarios().add(libroCarritoUsuario);
		libroCarritoUsuario.setLibro(this);

		return libroCarritoUsuario;
	}

	public LibroCarritoUsuario removeLibroCarritoUsuario(LibroCarritoUsuario libroCarritoUsuario) {
		getLibroCarritoUsuarios().remove(libroCarritoUsuario);
		libroCarritoUsuario.setLibro(null);

		return libroCarritoUsuario;
	}

	public List<ListaUsuario> getListaUsuarios() {
		return this.listaUsuarios;
	}

	public void setListausuarios(List<ListaUsuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
}
