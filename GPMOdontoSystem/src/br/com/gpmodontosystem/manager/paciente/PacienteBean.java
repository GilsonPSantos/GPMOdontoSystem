package br.com.gpmodontosystem.manager.paciente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.gpmodontosystem.model.Paciente;
import br.com.gpmodontosystem.persistence.pacientedao.IPacienteDao;
import br.com.gpmodontosystem.persistence.pacientedao.PacienteDaoImp;
import br.com.gpmodontosystem.service.paciente.IPacienteService;
import br.com.gpmodontosystem.service.paciente.PacienteServiceImp;
import br.com.gpmodontosystem.type.TypeSexo;

@ManagedBean(name="mbPaciente")
@RequestScoped
public class PacienteBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Paciente paciente;
	private List<Paciente> listaPaciente;
	
	private IPacienteService pacienteService;
	
	private TypeSexo tipoSexo;
	
	@PostConstruct
	public void init(){
		paciente = new Paciente();
		listaPaciente = new ArrayList<Paciente>();
		pacienteService = new PacienteServiceImp();
		
		//dados fack para testes.
		paciente.setNomePessoa("Gilson Santos");
		paciente.setCpf("010212112121");
		paciente.setSexo(TypeSexo.M);
		paciente.setIdentidade("123456");
		
	}
	
	public void cadastrar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			pacienteService.inserir(paciente);
			fc.addMessage("formCadConsPaciente", new FacesMessage("Paciente gravado com sucesso."));
		} catch (Exception e) {
			fc.addMessage("formCadConsPaciente", new FacesMessage("Ocorreu um erro interno ao salvar o Paciente."));
			e.printStackTrace();
		}
	}
	
	public void consultar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			paciente = pacienteService.consultarPeloId(paciente);
		} catch (Exception e) {
			fc.addMessage("formCadConsPaciente", new FacesMessage("Ocorreu um erro interno ao consultar o Paciente."));
			e.printStackTrace();
		}
	}
	
	public void excluir(){
		FacesContext fc = FacesContext.getCurrentInstance();
		
		
	}
	
	public String cancelarCadastro(){
		
		return null;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TypeSexo getTipoSexo() {
		return tipoSexo;
	}

	public void setTipoSexo(TypeSexo tipoSexo) {
		this.tipoSexo = tipoSexo;
	}
	
	

}
