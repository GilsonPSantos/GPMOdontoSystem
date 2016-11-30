package br.com.gpmodontosystem.model;

import br.com.gpmodontosystem.type.TypeFuncionario;

public class Funcionario extends Pessoa {
	
	private String matricula;
	private Usuario usuario;
	private TypeFuncionario tipoFuncionario;
	
	public Funcionario() {
	}

	/**
	 * @param matricula
	 * @param flagAtivo
	 * @param tipoFuncionario
	 */
	public Funcionario(String matricula, TypeFuncionario tipoFuncionario) {
		super();
		this.matricula = matricula;
		this.tipoFuncionario = tipoFuncionario;
	}

	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + ", flagAtivo=" + ", tipoFuncionario="
				+ tipoFuncionario + "]";
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
