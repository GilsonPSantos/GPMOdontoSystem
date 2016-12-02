package br.com.gpmodontosystem.model;

import java.util.List;

public class Paciente extends Pessoa{
	
	
	private List<Pagamento> listaPagamento;
	private List<Tratamento> listaTratamento;
	private List<Consulta> listaConsulta;
	private List<Exame> listaExame;
	private List<Dente> listaDente;
	private List<Convenio> listaConvenio;
	private List<Agenda> listaAgenda;
	
	public Paciente() {
	}
	
	@Override
	public String toString() {
		return "" + getNomePessoa();
	}



	public List<Pagamento> getListaPagamento() {
		return listaPagamento;
	}

	public void setListaPagamento(List<Pagamento> listaPagamento) {
		this.listaPagamento = listaPagamento;
	}

	public List<Tratamento> getListaTratamento() {
		return listaTratamento;
	}

	public void setListaTratamento(List<Tratamento> listaTratamento) {
		this.listaTratamento = listaTratamento;
	}

	public List<Consulta> getListaConsulta() {
		return listaConsulta;
	}

	public void setListaConsulta(List<Consulta> listaConsulta) {
		this.listaConsulta = listaConsulta;
	}

	public List<Exame> getListaExame() {
		return listaExame;
	}

	public void setListaExame(List<Exame> listaExame) {
		this.listaExame = listaExame;
	}

	public List<Dente> getListaDente() {
		return listaDente;
	}

	public void setListaDente(List<Dente> listaDente) {
		this.listaDente = listaDente;
	}

	public List<Convenio> getListaConvenio() {
		return listaConvenio;
	}

	public void setListaConvenio(List<Convenio> listaConvenio) {
		this.listaConvenio = listaConvenio;
	}

	public List<Agenda> getListaAgenda() {
		return listaAgenda;
	}

	public void setListaAgenda(List<Agenda> listaAgenda) {
		this.listaAgenda = listaAgenda;
	}
	
}
