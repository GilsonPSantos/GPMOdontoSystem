package br.com.gpmodontosystem.model;

import java.util.Calendar;

public class Exame {
	
	private Integer idExame;
	private Calendar dataHoraExame;
	private String tipoExame;
	private Paciente paciente;
	
	public Exame() {
	}

	/**
	 * @param idExame
	 * @param dataHoraExame
	 * @param tipoExame
	 */
	public Exame(Integer idExame, Calendar dataHoraExame, String tipoExame) {
		super();
		this.idExame = idExame;
		this.dataHoraExame = dataHoraExame;
		this.tipoExame = tipoExame;
	}

	@Override
	public String toString() {
		return "Exame [idExame=" + idExame + ", dataHoraExame=" + dataHoraExame + ", tipoExame=" + tipoExame + "]";
	}

	public Integer getIdExame() {
		return idExame;
	}

	public void setIdExame(Integer idExame) {
		this.idExame = idExame;
	}

	public Calendar getDataHoraExame() {
		return dataHoraExame;
	}

	public void setDataHoraExame(Calendar dataHoraExame) {
		this.dataHoraExame = dataHoraExame;
	}

	public String getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(String tipoExame) {
		this.tipoExame = tipoExame;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
}
