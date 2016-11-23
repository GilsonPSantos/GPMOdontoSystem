package br.com.gpmodontosystem.manager.paciente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.gpmodontosystem.model.Paciente;
import br.com.gpmodontosystem.persistence.pacientedao.IPacienteDao;
import br.com.gpmodontosystem.persistence.pacientedao.PacienteDaoImp;

@ManagedBean(name="mbPaciente")
@RequestScoped
public class PacienteBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Paciente paciente;
	private List<Paciente> listaPaciente;
	
	private IPacienteDao pacienteDao;
	
	@PostConstruct
	public void init(){
		paciente = new Paciente();
		listaPaciente = new ArrayList<Paciente>();
		pacienteDao = new PacienteDaoImp();
	}
	
	

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getListaPaciente() {
		return listaPaciente;
	}

	public void setListaPaciente(List<Paciente> listaPaciente) {
		this.listaPaciente = listaPaciente;
	}

	public IPacienteDao getPacienteDao() {
		return pacienteDao;
	}

	public void setPacienteDao(IPacienteDao pacienteDao) {
		this.pacienteDao = pacienteDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
