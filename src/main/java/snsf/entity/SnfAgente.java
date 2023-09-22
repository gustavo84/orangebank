package snsf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SNSF_AGENTE", schema = "SNSFARMA_BE_BD_A_O")
public class SnfAgente {
	
	@Column(name = "DESC_AGENTE", nullable = false)
	private String descripcion;
	
	@Id
	@Column(name = "ID_AGENTE", nullable = false)
	private int idAgente;

	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdAgente() {
		return idAgente;
	}

	public void setIdAgente(int idAgente) {
		this.idAgente = idAgente;
	}

	public SnfAgente() {
		super();
	}
	
	

}
