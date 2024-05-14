package model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "lectura")
@NamedQuery(name = "Lectura.findAll", query = "SELECT lec FROM Lectura lec")
public class Lectura implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codLeido;

	@Temporal(TemporalType.DATE)
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	private Date fechaInicio;

	private int paginasLeidas;

	@ManyToOne
	@JoinColumn(name="codLibro")
	private Libro libro;

	@ManyToOne
	@JoinColumn(name="codUsuario")
	private Usuario usuario;

	public Lectura() {
	}

	public int getCodLeido() {
		return this.codLeido;
	}

	public void setCodLeido(int codLeido) {
		this.codLeido = codLeido;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getPaginasLeidas() {
		return this.paginasLeidas;
	}

	public void setPaginasLeidas(int paginasLeidas) {
		this.paginasLeidas = paginasLeidas;
	}

	public Libro getLibro() {
		return this.libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
