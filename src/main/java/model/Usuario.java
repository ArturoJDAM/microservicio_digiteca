package model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
@NamedQuery(name = "Usuario.findAll", query = "SELECT usu FROM Usuario usu")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codUsuario;

	private String emailUsuario;
	private String nombreUsuario;
	private String passwordUsuario;

	@OneToMany(mappedBy = "usuario")
	private List<CarritoUsuario> carritoUsuarios;

	@OneToMany(mappedBy = "usuario")
	private List<Lectura> lecturas;

	@OneToMany(mappedBy = "usuario")
	private List<ListaUsuario> listaUsuarios;

	public Usuario() {
	}

	public int getCodUsuario() {
		return this.codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPasswordUsuario() {
		return this.passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public List<CarritoUsuario> getCarritoUsuarios() {
		return this.carritoUsuarios;
	}

	public void setCarritoUsuarios(List<CarritoUsuario> carritoUsuarios) {
		this.carritoUsuarios = carritoUsuarios;
	}

	public CarritoUsuario addCarritoUsuario(CarritoUsuario carritoUsuario) {
		getCarritoUsuarios().add(carritoUsuario);
		carritoUsuario.setUsuario(this);

		return carritoUsuario;
	}

	public CarritoUsuario removeCarritoUsuario(CarritoUsuario carritoUsuario) {
		getCarritoUsuarios().remove(carritoUsuario);
		carritoUsuario.setUsuario(null);

		return carritoUsuario;
	}

	public List<Lectura> getLecturas() {
		return this.lecturas;
	}

	public void setLecturas(List<Lectura> lecturas) {
		this.lecturas = lecturas;
	}

	public Lectura addLectura(Lectura lectura) {
		getLecturas().add(lectura);
		lectura.setUsuario(this);

		return lectura;
	}

	public Lectura removeLectura(Lectura lectura) {
		getLecturas().remove(lectura);
		lectura.setUsuario(null);

		return lectura;
	}

	public List<ListaUsuario> getListaUsuarios() {
		return this.listaUsuarios;
	}

	public void setListaUsuarios(List<ListaUsuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public ListaUsuario addListaUsuario(ListaUsuario listaUsuario) {
		getListaUsuarios().add(listaUsuario);
		listaUsuario.setUsuario(this);

		return listaUsuario;
	}

	public ListaUsuario removeListaUsuario(ListaUsuario listaUsuario) {
		getListaUsuarios().remove(listaUsuario);
		listaUsuario.setUsuario(null);

		return listaUsuario;
	}
}
