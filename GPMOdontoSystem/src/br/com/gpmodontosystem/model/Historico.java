package br.com.gpmodontosystem.model;

import java.util.Calendar;

public class Historico {
	
	private Integer idHistorico;
	private String descricao;
	private Calendar dataHistorico;	
	private Consulta consulta;
	
	public Historico() {
	}

	/**
	 * @param idHistorico
	 * @param descricao
	 * @param dataHistorico
	 */
	public Historico(Integer idHistorico, String descricao, Calendar dataHistorico) {
		super();
		this.idHistorico = idHistorico;
		this.descricao = descricao;
		this.dataHistorico = dataHistorico;
	}

	@Override
	public String toString() {
		return "Historico [idHistorico=" + idHistorico + ", descricao=" + descricao + ", dataHistorico=" + dataHistorico
				+ "]";
	}

	public Integer getIdHistorico() {
		return idHistorico;
	}

	public void setIdHistorico(Integer idHistorico) {
		this.idHistorico = idHistorico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataHistorico() {
		return dataHistorico;
	}

	public void setDataHistorico(Calendar dataHistorico) {
		this.dataHistorico = dataHistorico;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	
}
