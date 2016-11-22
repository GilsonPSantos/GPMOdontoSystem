package br.com.gpmodontosystem.model;

import java.util.Calendar;

public class Convenio {
	
	private Integer idConvenio;
	private String numeroConvenio;
	private String naturezaConvenio;
	private String acomodacao;
	private Calendar dataValidade;
	private String abrangencia;
	private String cobertura;
	private String observacao;
	private Paciente paciente;
	private Plano plano;
	
	public Convenio() {
	}

	/**
	 * @param idConvenio
	 * @param numeroConvenio
	 * @param naturezaConvenio
	 * @param acomodacao
	 * @param dataValidade
	 * @param abrangencia
	 * @param cobertura
	 * @param observacao
	 */
	public Convenio(Integer idConvenio, String numeroConvenio, String naturezaConvenio, String acomodacao,
			Calendar dataValidade, String abrangencia, String cobertura, String observacao) {
		super();
		this.idConvenio = idConvenio;
		this.numeroConvenio = numeroConvenio;
		this.naturezaConvenio = naturezaConvenio;
		this.acomodacao = acomodacao;
		this.dataValidade = dataValidade;
		this.abrangencia = abrangencia;
		this.cobertura = cobertura;
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "Convenio [idConvenio=" + idConvenio + ", numeroConvenio=" + numeroConvenio + ", naturezaConvenio="
				+ naturezaConvenio + ", acomodacao=" + acomodacao + ", dataValidade=" + dataValidade + ", abrangencia="
				+ abrangencia + ", cobertura=" + cobertura + ", observacao=" + observacao + "]";
	}

	public Integer getIdConvenio() {
		return idConvenio;
	}

	public void setIdConvenio(Integer idConvenio) {
		this.idConvenio = idConvenio;
	}

	public String getNumeroConvenio() {
		return numeroConvenio;
	}

	public void setNumeroConvenio(String numeroConvenio) {
		this.numeroConvenio = numeroConvenio;
	}

	public String getNaturezaConvenio() {
		return naturezaConvenio;
	}

	public void setNaturezaConvenio(String naturezaConvenio) {
		this.naturezaConvenio = naturezaConvenio;
	}

	public String getAcomodacao() {
		return acomodacao;
	}

	public void setAcomodacao(String acomodacao) {
		this.acomodacao = acomodacao;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getAbrangencia() {
		return abrangencia;
	}

	public void setAbrangencia(String abrangencia) {
		this.abrangencia = abrangencia;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	
}
