package br.com.gpmodontosystem.model;

import java.util.Calendar;

import br.com.gpmodontosystem.type.TypeSexo;

public class Pessoa {
	
	private Integer idPessoa;
	private String cpf;
	private String identidade;
	private String nomePessoa;
	private Calendar dataNascimento;
	private Calendar dataCadastro;
	private Calendar dataAtualizacao;
	private TypeSexo sexo;
	private String email;
	private String ddd;
	private String celular;
	private String telefone;	
	private Endereco endereco;
	
	public Pessoa() {
	}

	/**
	 * @param idPessoa
	 * @param cpf
	 * @param identidade
	 * @param nomePessoa
	 * @param dataNascimento
	 * @param dataCadastro
	 * @param dataAtualizacao
	 * @param sexo
	 * @param email
	 * @param ddd
	 * @param celular
	 * @param telefone
	 */
	public Pessoa(Integer idPessoa, String cpf, String identidade, String nomePessoa, Calendar dataNascimento,
			Calendar dataCadastro, Calendar dataAtualizacao, TypeSexo sexo, String email, String ddd, String celular,
			String telefone) {
		super();
		this.idPessoa = idPessoa;
		this.cpf = cpf;
		this.identidade = identidade;
		this.nomePessoa = nomePessoa;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
		this.sexo = sexo;
		this.email = email;
		this.ddd = ddd;
		this.celular = celular;
		this.telefone = telefone;
	}


	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", cpf=" + cpf + ", identidade=" + identidade + ", nomePessoa="
				+ nomePessoa + ", dataNascimento=" + dataNascimento + ", dataCadastro=" + dataCadastro
				+ ", dataAtualizacao=" + dataAtualizacao + ", sexo=" + sexo + ", email=" + email + ", ddd=" + ddd
				+ ", celular=" + celular + ", telefone=" + telefone + "]";
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TypeSexo getSexo() {
		return sexo;
	}

	public void setSexo(TypeSexo sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Calendar dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
}
