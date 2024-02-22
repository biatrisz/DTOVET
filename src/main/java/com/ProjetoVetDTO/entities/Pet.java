package com.ProjetoVetDTO.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "pet")
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotBlank
	@Column(name = "nome")
	private String nome;

	@NotBlank
	@Column(name = "documento")
	private String documento;
	
	@NotBlank
	@Column(name = "nascimento")
	private String nascimento;
	
	@NotBlank
	@Column(name = "cuidador")
	private String cuidador;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getnome(){
		return nome;
	}
	public void setnome(String nome) {
		this.nome = nome;
	}
	public String getdocumento(){
		return documento;
	}
	public void setdocumento(String documento) {
		this.documento = documento;
	}
	public String getnascimento(){
		return nascimento;
	}
	public void setnascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getCuidador () {
		return cuidador;
	}
	public void setCuidador(String cuidador) {
		this.cuidador = cuidador;
	}
	public Pet(String nome,String nascimento, String cuidador) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.cuidador = cuidador;
		
	}

}