package br.com.gpmodontosystem.model;

public class Tratamento {
	
	private Integer idTratamento;
	private String descricao;
	private Paciente paciente;
	
	public Tratamento() {
	}

	/**
	 * @param idTratamento
	 * @param descricao
	 */
	public Tratamento(Integer idTratamento, String descricao) {
		super();
		this.idTratamento = idTratamento;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Tratamento [idTratamento=" + idTratamento + ", descricao=" + descricao + "]";
	}

	public Integer getIdTratamento() {
		return idTratamento;
	}

	public void setIdTratamento(Integer idTratamento) {
		this.idTratamento = idTratamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
}
