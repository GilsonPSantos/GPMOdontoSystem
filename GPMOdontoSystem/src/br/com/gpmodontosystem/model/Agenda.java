package br.com.gpmodontosystem.model;

import java.util.Calendar;
import java.util.List;

public class Agenda {
	
	private Integer idAgenda;
	private Calendar dataHoraAgenda;
	private Calendar dataCadastro;
	private Calendar dataAtualizacao;
	private Integer flagSituacao; //0-NÃO, 1-SIM
	private List<Paciente> listaPaciente;
	private List<Odontologista> listaOdontologista;	
	
	public Agenda() {
	}

	/**
	 * @param idAgenda
	 * @param dataHoraAgenda
	 * @param dataCadastro
	 * @param dataAtualizacao
	 * @param flagSituacao
	 */
	public Agenda(Integer idAgenda, Calendar dataHoraAgenda, Calendar dataCadastro, Calendar dataAtualizacao,
			Integer flagSituacao) {
		super();
		this.idAgenda = idAgenda;
		this.dataHoraAgenda = dataHoraAgenda;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
		this.flagSituacao = flagSituacao;
	}

	@Override
	public String toString() {
		return "Agenda [idAgenda=" + idAgenda + ", dataHoraAgenda=" + dataHoraAgenda + ", dataCadastro=" + dataCadastro
				+ ", dataAtualizacao=" + dataAtualizacao + ", flagSituacao=" + flagSituacao + "]";
	}

	public Integer getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(Integer idAgenda) {
		this.idAgenda = idAgenda;
	}

	public Calendar getDataHoraAgenda() {
		return dataHoraAgenda;
	}

	public void setDataHoraAgenda(Calendar dataHoraAgenda) {
		this.dataHoraAgenda = dataHoraAgenda;
	}

	public Integer getFlagSituacao() {
		return flagSituacao;
	}

	public void setFlagSituacao(Integer flagSituacao) {
		this.flagSituacao = flagSituacao;
	}

	public List<Paciente> getListaPaciente() {
		return listaPaciente;
	}

	public void setListaPaciente(List<Paciente> listaPaciente) {
		this.listaPaciente = listaPaciente;
	}

	public List<Odontologista> getListaOdontologista() {
		return listaOdontologista;
	}

	public void setListaOdontologista(List<Odontologista> listaOdontologista) {
		this.listaOdontologista = listaOdontologista;
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
