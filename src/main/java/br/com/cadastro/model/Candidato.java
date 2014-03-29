package br.com.cadastro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import br.com.cadastro.enumeration.EnumSexo;

@Entity
@Table(name="candidatos")
@SequenceGenerator(name="seq_candidatos", sequenceName="seq_candidatos")
public class Candidato implements Serializable{

	private static final long serialVersionUID = 7952651438557653902L;

	@Id
	@Column(name="id")
	@GeneratedValue(generator="seq_candidatos")
	private Long id;
	
	@Column(name="nome", length=100, nullable=false)
	private String nome;
	
	@Column(name="sexo", length=1, nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumSexo sexo;
	
	@Column(name="cpf", length=14, nullable=false)
	private String cpf;
	
	@Column(name="telefone", length=13)
	private String telefone;
	
	@Column(name="celular", length=14)
	private String celular;
	
	@Column(name="email", length=70)
	private String email;
	
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
	
	public EnumSexo getSexo() {
		return sexo;
	}
	
	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
