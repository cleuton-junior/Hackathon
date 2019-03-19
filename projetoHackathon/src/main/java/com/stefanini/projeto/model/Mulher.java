package com.stefanini.projeto.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;



@Entity
public class Mulher implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SQ_ML_NU", sequenceName = "SQ_ML_NU", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ML_NU")
	@Column(name = "ML_NU")
	private Long id;

	@Column(name = "ML_NO")
	private String nome;
	

	@OneToMany(mappedBy = "mulher")
	@Size(max=5)
	private List<Sapato> sapatos;
		

	public Mulher() {
		super();
	}

	

	public Mulher(Long id, String nome, @Size(max = 5) List<Sapato> sapatos) {
		super();
		this.id = id;
		this.nome = nome;
		this.sapatos = sapatos;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Sapato> getSapatos() {
		return sapatos;
	}

	public void setSapatos(List<Sapato> sapatos) {
		this.sapatos = sapatos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Mulher other = (Mulher) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}