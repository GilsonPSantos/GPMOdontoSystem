package br.com.gpmodontosystem.manager;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.gpmodontosystem.model.Endereco;
import br.com.gpmodontosystem.model.Funcionario;
import br.com.gpmodontosystem.service.endereco.EnderecoServiceImpl;
import br.com.gpmodontosystem.service.endereco.IEnderecoService;
import br.com.gpmodontosystem.service.funcionario.FuncionarioServiceImp;
import br.com.gpmodontosystem.service.funcionario.IFuncionarioService;
import br.com.gpmodontosystem.utilitario.BuscaCep;

@ManagedBean(name="mbFuncionario")
@RequestScoped
public class FuncionarioBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Funcionario funcionario;
	private List<Funcionario> listaFuncionario;
	
	private boolean flagCadastroEndereco = true;
	private boolean flagCadastroFuncionario = true;
	
	private IFuncionarioService funcionarioService;
	private IEnderecoService enderecoService;
	
	@PostConstruct
	public void init(){
		funcionarioService = new FuncionarioServiceImp();
		funcionario = new Funcionario();
		funcionario.setEndereco(new Endereco());
		Calendar c = Calendar.getInstance();
		funcionario.setDataNascimento(c);
	}
	
	public void cadastrarFuncionario(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {//alterar a criação da tabela de funcionario para apontar a chave para a tabela pessoa
			funcionarioService.inserir(funcionario);
			fc.addMessage("formCadConsFuncionario", new FacesMessage("Funcionário cadastrado com sucesso."));
		} catch (Exception e) {
			fc.addMessage("formCadConsFuncionario", new FacesMessage("Ocorreu um erro interno ao cadastrar o Funcionário."));
			e.printStackTrace();
		}
	}
	
	
	
	public void cadastrarEndereco(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			enderecoService = new EnderecoServiceImpl();
			enderecoService.inserir(funcionario);
			flagCadastroEndereco = false;
			fc.addMessage("formCadConsFuncionario", new FacesMessage("Endereço cadastrado com sucesso."));
		} catch (Exception e) {
			e.printStackTrace();
			fc.addMessage("formCadConsFuncionario", new FacesMessage("Ocorreu um erro interno ao cadastrar o endereço."));
		}
	}
	
	public void buscarCep(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			if(!new BuscaCep().buscarCep(funcionario.getEndereco())){
			fc.addMessage("formBuscaCepFunc", new FacesMessage("CEP não localizado."));
			}
		} catch (Exception e) {
			fc.addMessage("formBuscaCepFunc", new FacesMessage("Ocorreu um erro interno ao consultar o CEP."));
		}
	}
	
	public void cancelarPreenchimentoEndereco(){
		funcionario.setEndereco(new Endereco());
	}
	

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getListaFuncionario() {
		
		try {
			listaFuncionario = funcionarioService.listarFuncionarios();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaFuncionario;
	}

	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}


	public boolean isFlagCadastroEndereco() {
		return flagCadastroEndereco;
	}


	public void setFlagCadastroEndereco(boolean flagCadastroEndereco) {
		this.flagCadastroEndereco = flagCadastroEndereco;
	}

	public boolean isFlagCadastroFuncionario() {
		return flagCadastroFuncionario;
	}


	public void setFlagCadastroFuncionario(boolean flagCadastroFuncionario) {
		this.flagCadastroFuncionario = flagCadastroFuncionario;
	}
	
	

}
