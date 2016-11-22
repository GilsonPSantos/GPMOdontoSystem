package br.com.gpmodontosystem.model;

import br.com.gpmodontosystem.type.TypeFuncionario;

public class Funcionario extends Pessoa {
	
	private String matricula;
	private Integer flagAtivo; //0-INATIVO, 1-ATIVO
	private Usuario usuario;
	private TypeFuncionario tipoFuncionario;
	
	public Funcionario() {
	}

	/**
	 * @param matricula
	 * @param flagAtivo
	 * @param tipoFuncionario
	 */
	public Funcionario(String matricula, Integer flagAtivo, TypeFuncionario tipoFuncionario) {
		super();
		this.matricula = matricula;
		this.flagAtivo = flagAtivo;
		this.tipoFuncionario = tipoFuncionario;
	}

	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + ", flagAtivo=" + flagAtivo + ", tipoFuncionario="
				+ tipoFuncionario + "]";
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Integer getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(Integer flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TypeFuncionario getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(TypeFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
	
}
