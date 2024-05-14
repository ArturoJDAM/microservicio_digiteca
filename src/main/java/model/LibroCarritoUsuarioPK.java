package model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LibroCarritoUsuarioPK implements Serializable {
    private static final long serialVersionUID = 1L;

	@Column(insertable = false, updatable = false)
	private int codCarrito;

	@Column(insertable = false, updatable = false)
	private int codLibro;

	public LibroCarritoUsuarioPK() {
	}

	public int getCodCarrito() {
		return this.codCarrito;
	}

	public void setCodCarrito(int codCarrito) {
		this.codCarrito = codCarrito;
	}

	public int getCodLibro() {
		return this.codLibro;
	}

	public void setCodLibro(int codLibro) {
		this.codLibro = codLibro;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LibroCarritoUsuarioPK)) {
			return false;
		}
		LibroCarritoUsuarioPK castOther = (LibroCarritoUsuarioPK)other;
		return 
			(this.codCarrito == castOther.codCarrito)
			&& (this.codLibro == castOther.codLibro);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codCarrito;
		hash = hash * prime + this.codLibro;
		
		return hash;
	}
}
