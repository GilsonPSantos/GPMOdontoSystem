package br.com.gpmodontosystem.model;

import java.util.List;

public class Plano {
	
	private Integer idPlano;
	private String nomePlano;
	private List<Convenio> listaConvenio;
	
	public Plano() {
	}

	/**
	 * @param idPlano
	 * @param nomePlano
	 */
	public Plano(Integer idPlano, String nomePlano) {
		super();
		this.idPlano = idPlano;
		this.nomePlano = nomePlano;
	}

	@Override
	public String toString() {
		return "Plano [idPlano=" + idPlano + ", nomePlano=" + nomePlano + "]";
	}

	public Integer getIdPlano() {
		return idPlano;
	}

	public void setIdPlano(Integer idPlano) {
		this.idPlano = idPlano;
	}

	public String getNomePlano() {
		return nomePlano;
	}

	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}

	public List<Convenio> getListaConvenio() {
		return listaConvenio;
	}

	public void setListaConvenio(List<Convenio> listaConvenio) {
		this.listaConvenio = listaConvenio;
	}
	
}
