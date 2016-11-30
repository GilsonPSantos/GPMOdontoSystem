package br.com.gpmodontosystem.manager;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.gpmodontosystem.model.Funcionario;

@ManagedBean(name="mbFuncionario")
@RequestScoped
public class FuncionarioBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Funcionario funcionario;
	private List<Funcionario> listaFuncionario;
	
	
	
	@PostConstruct
	public void init(){
		
	}

}
