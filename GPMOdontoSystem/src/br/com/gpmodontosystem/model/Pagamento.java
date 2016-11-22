package br.com.gpmodontosystem.model;

public class Pagamento {
	
	private Integer idPagamento;
	private String formaPagamento;
	private Double valorPagamento;
	private Paciente paciente;
	
	public Pagamento() {
	}

	/**
	 * @param idPagamento
	 * @param formaPagamento
	 * @param valorPagamento
	 */
	public Pagamento(Integer idPagamento, String formaPagamento, Double valorPagamento) {
		super();
		this.idPagamento = idPagamento;
		this.formaPagamento = formaPagamento;
		this.valorPagamento = valorPagamento;
	}

	@Override
	public String toString() {
		return "Pagamento [idPagamento=" + idPagamento + ", formaPagamento=" + formaPagamento + ", valorPagamento="
				+ valorPagamento + "]";
	}

	public Integer getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
}
