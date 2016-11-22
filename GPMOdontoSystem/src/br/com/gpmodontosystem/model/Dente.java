package br.com.gpmodontosystem.model;

import java.util.List;

public class Dente {
	
	private Integer idDente;
	private String descricao;
	private String foto;
	private Integer numeroDente;
	private List<Paciente> listaPaciente;
	
	public Dente() {
	}

	/**
	 * @param idDente
	 * @param descricao
	 * @param foto
	 * @param numeroDente
	 */
	public Dente(Integer idDente, String descricao, String foto, Integer numeroDente) {
		super();
		this.idDente = idDente;
		this.descricao = descricao;
		this.foto = foto;
		this.numeroDente = numeroDente;
	}

	@Override
	public String toString() {
		return "Dente [idDente=" + idDente + ", descricao=" + descricao + ", foto=" + foto + ", numeroDente="
				+ numeroDente + "]";
	}

	public Integer getIdDente() {
		return idDente;
	}

	public void setIdDente(Integer idDente) {
		this.idDente = idDente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getNumeroDente() {
		return numeroDente;
	}

	public void setNumeroDente(Integer numeroDente) {
		this.numeroDente = numeroDente;
	}

	public List<Paciente> getListaPaciente() {
		return listaPaciente;
	}

	public void setListaPaciente(List<Paciente> listaPaciente) {
		this.listaPaciente = listaPaciente;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
