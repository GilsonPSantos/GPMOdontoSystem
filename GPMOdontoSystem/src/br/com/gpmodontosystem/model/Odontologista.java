package br.com.gpmodontosystem.model;

import java.util.List;

public class Odontologista extends Funcionario {
	
	private String cro;
	private List<Consulta> listaConsulta;
	private List<Agenda> listaAgenda;
	
	public Odontologista() {
	}

	/**
	 * @param cro
	 */
	public Odontologista(String cro) {
		super();
		this.cro = cro;
	}

	@Override
	public String toString() {
		return "Odontologista [cro=" + cro + "]";
	}

	public String getCro() {
		return cro;
	}

	public void setCro(String cro) {
		this.cro = cro;
	}

	public List<Consulta> getListaConsulta() {
		return listaConsulta;
	}

	public void setListaConsulta(List<Consulta> listaConsulta) {
		this.listaConsulta = listaConsulta;
	}

	public List<Agenda> getListaAgenda() {
		return listaAgenda;
	}

	public void setListaAgenda(List<Agenda> listaAgenda) {
		this.listaAgenda = listaAgenda;
	}
	
}
