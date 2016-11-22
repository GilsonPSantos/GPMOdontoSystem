package br.com.gpmodontosystem.model;

import java.util.Calendar;
import java.util.List;

public class Consulta {
	
	private Integer idConsulta;
	private Integer flagConfirmado; //0-NÃO, 1-SIM
	private Calendar dataCadastro;	
	private Calendar dataAtualizacao;
	private Paciente paciente;
	private Odontologista odontologista;
	private List<Historico> listaHistorico;
	
	public Consulta() {
	}

	/**
	 * @param idConsulta
	 * @param flagConfirmado
	 * @param dataCadastro
	 * @param dataAtualizacao
	 */
	public Consulta(Integer idConsulta, Integer flagConfirmado, Calendar dataCadastro, Calendar dataAtualizacao) {
		super();
		this.idConsulta = idConsulta;
		this.flagConfirmado = flagConfirmado;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		return "Consulta [idConsulta=" + idConsulta + ", flagConfirmado=" + flagConfirmado + ", dataCadastro="
				+ dataCadastro + ", dataAtualizacao=" + dataAtualizacao + "]";
	}

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Integer getFlagConfirmado() {
		return flagConfirmado;
	}

	public void setFlagConfirmado(Integer flagConfirmado) {
		this.flagConfirmado = flagConfirmado;
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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Odontologista getOdontologista() {
		return odontologista;
	}

	public void setOdontologista(Odontologista odontologista) {
		this.odontologista = odontologista;
	}

	public List<Historico> getListaHistorico() {
		return listaHistorico;
	}

	public void setListaHistorico(List<Historico> listaHistorico) {
		this.listaHistorico = listaHistorico;
	}
	
}
