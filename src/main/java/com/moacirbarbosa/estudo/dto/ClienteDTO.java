package com.moacirbarbosa.estudo.dto;

import java.io.Serializable;

import com.moacirbarbosa.estudo.domain.Cliente;
import com.moacirbarbosa.estudo.domain.enuns.TipoCliente;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private Integer tipo;

	public ClienteDTO(Integer id, String nome, String email, String cpfOuCnpj, Integer tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo;
	}

	public ClienteDTO() {
		super();
	}
	
	public ClienteDTO(Cliente obj) {
		
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.cpfOuCnpj = obj.getCpfOuCnpj();
		this.tipo = obj.getTipo().getCod();
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

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}

}
