package com.moacirbarbosa.estudo.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.moacirbarbosa.estudo.domain.Cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty
	@Length(min = 5,max = 120, message = "O tamanho deve ser entre 5 a 120 caracteres")
	private String nome;
	@NotEmpty
	@Email(message = "Email inválido")
	private String email;

	public ClienteDTO(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	
	}

	public ClienteDTO() {
		super();
	}
	
	public ClienteDTO(Cliente obj) {
		
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
