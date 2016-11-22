package br.com.gpmodontosystem.model;

import java.util.Calendar;

public class Endereco {
	
	private Integer idEndereco;
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private Integer flagAtivo;
	private Calendar dataCadastro;
	private Calendar dataAtualizacao;
	private Pessoa pessoa;
	
	public Endereco() {
	}

	/**
	 * @param idEndereco
	 * @param cep
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param bairro
	 * @param cidade
	 * @param uf
	 * @param flagAtivo
	 * @param dataCadastro
	 * @param dataAtualizacao
	 */
	public Endereco(Integer idEndereco, String cep, String logradouro, String numero, String complemento, String bairro,
			String cidade, String uf, Integer flagAtivo, Calendar dataCadastro, Calendar dataAtualizacao) {
		super();
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.flagAtivo = flagAtivo;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", cep=" + cep + ", logradouro=" + logradouro + ", numero="
				+ numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf
				+ ", flagAtivo=" + flagAtivo + ", dataCadastro=" + dataCadastro + ", dataAtualizacao=" + dataAtualizacao
				+ "]";
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(Integer flagAtivo) {
		this.flagAtivo = flagAtivo;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
