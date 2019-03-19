package com.stefanini.projeto.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Sapato implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SQ_SA_NU", sequenceName = "SQ_SA_NU", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SA_NU")
	@Column(name = "SA_NU")
	private Long id;

	@Column(name = "SA_MODELO")
	private String modelo;

	@ManyToOne
	@com.fasterxml.jackson.annotation.JsonIgnore
	@JoinColumn(name = "ML_NU", referencedColumnName = "ML_NU")
	private Mulher mulher;

	public Sapato() {
		super();
	}
	
	public Sapato(Long id, String modelo, Mulher mulher) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.mulher = mulher;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Mulher getMulher() {
		return mulher;
	}

	public void setMulher(Mulher Mulher) {
		this.mulher = Mulher;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sapato other = (Sapato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		return true;
	}

	
	

}