package br.com.gpmodontosystem.model;

import java.util.Calendar;

public class Usuario {
	
	private Integer idUsuario;
	private String login;
	private String senha;
	private String nivelPermissao;
	private Integer flagAtivo; //0-INATIVO, 1-ATIVO
	private Calendar dataCadastro;
	private Calendar dataAtualizacao;
	private Funcionario funcionaio;
	
	public Usuario() {
	}

	/**
	 * @param idUsuario
	 * @param login
	 * @param senha
	 * @param nivelPermissao
	 * @param flagAtivo
	 * @param dataCadastro
	 * @param dataAtualizacao
	 */
	public Usuario(Integer idUsuario, String login, String senha, String nivelPermissao, Integer flagAtivo,
			Calendar dataCadastro, Calendar dataAtualizacao) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.senha = senha;
		this.nivelPermissao = nivelPermissao;
		this.flagAtivo = flagAtivo;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", login=" + login + ", senha=" + senha + ", nivelPermissao="
				+ nivelPermissao + ", flagAtivo=" + flagAtivo + ", dataCadastro=" + dataCadastro + ", dataAtualizacao="
				+ dataAtualizacao + "]";
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNivelPermissao() {
		return nivelPermissao;
	}

	public void setNivelPermissao(String nivelPermissao) {
		this.nivelPermissao = nivelPermissao;
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

	public Funcionario getFuncionaio() {
		return funcionaio;
	}

	public void setFuncionaio(Funcionario funcionaio) {
		this.funcionaio = funcionaio;
	}
	
}
