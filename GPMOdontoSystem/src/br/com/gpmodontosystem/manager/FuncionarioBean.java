package br.com.gpmodontosystem.manager;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.gpmodontosystem.model.Cargo;
import br.com.gpmodontosystem.model.Endereco;
import br.com.gpmodontosystem.model.Funcionario;
import br.com.gpmodontosystem.model.Usuario;
import br.com.gpmodontosystem.service.cargo.CargoServiceImp;
import br.com.gpmodontosystem.service.cargo.ICargoService;
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
	
	private List<Cargo> listaCargo;
	
	private boolean flagCadastroEndereco = true;
	private boolean flagCadastroFuncionario = true;
	private String labelBtnModalEnd;
	
	private IFuncionarioService funcionarioService;
	private IEnderecoService enderecoService;
	private ICargoService cargoService;
	
	private String styleDisplayBtnFormFuncionarioCadastrar;
	private String styleDisplayBtnFormFuncionarioAlterar;
	private String styleDisplayBtnFormEnderecoCadastrar;
	private String styleDisplayBtnFormEnderecoAlterar;
	
	@PostConstruct
	public void init(){
		funcionarioService = new FuncionarioServiceImp();
		funcionario = new Funcionario();
		funcionario.setEndereco(new Endereco());
		funcionario.setUsuario(new Usuario());
		funcionario.setCargo(new Cargo());
		Calendar c = Calendar.getInstance();
		funcionario.setDataNascimento(c);
		
		flagCadastroEndereco = Boolean.TRUE;
		styleDisplayBtnFormFuncionarioCadastrar = "block";
		styleDisplayBtnFormFuncionarioAlterar = "none";
		
		styleDisplayBtnFormEnderecoCadastrar = "block";
		styleDisplayBtnFormEnderecoAlterar = "none";
	}
	
	public void cadastrarFuncionario(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {//alterar a criação da tabela de funcionario para apontar a chave para a tabela pessoa
			funcionarioService.inserir(funcionario);
			labelBtnModalEnd = "Adicionar Endereço";
			styleDisplayBtnFormFuncionarioCadastrar = "none";
			styleDisplayBtnFormFuncionarioAlterar = "block";
			fc.addMessage("pgrowFormFuncionario", new FacesMessage("Funcionário cadastrado com sucesso."));
		} catch (Exception e) {
			labelBtnModalEnd = "Adicionar Endereço";
			fc.addMessage("pgrowFormFuncionario", new FacesMessage("Ocorreu um erro interno ao cadastrar o Funcionário."));
			e.printStackTrace();
		}
	}
	
	public void cosultarFuncionario(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			funcionario = funcionarioService.consultarPeloId(funcionario);
			labelBtnModalEnd = "Consultar Endereço";
			styleDisplayBtnFormFuncionarioCadastrar = "none";
			styleDisplayBtnFormFuncionarioAlterar = "block";
			
			styleDisplayBtnFormEnderecoCadastrar = "none";
			styleDisplayBtnFormEnderecoAlterar = "block";
			
		} catch (Exception e) {
			labelBtnModalEnd = "Adicionar Endereço";
			styleDisplayBtnFormFuncionarioCadastrar = "block";
			styleDisplayBtnFormFuncionarioAlterar = "none";
			fc.addMessage("pgrowFormFuncionario", new FacesMessage("Ocorreu um erro interno ao consultar o Funcionário."));
			e.printStackTrace();
		}
	}
	
//	public void mudarBtnSalvarAlterar(ActionEvent event){
//		FacesContext fc = FacesContext.getCurrentInstance();
//		HtmlCommandButton btn = new HtmlCommandButton();
//		
////		btn.setActionExpression();
//				
//	}
	
	public void alterarFuncionario(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			funcionarioService.alterar(funcionario);
			labelBtnModalEnd = "Consultar Endereço";
			styleDisplayBtnFormFuncionarioCadastrar = "none";
			styleDisplayBtnFormFuncionarioAlterar = "block";
			
			styleDisplayBtnFormEnderecoCadastrar = "none";
			styleDisplayBtnFormEnderecoAlterar = "block";
			fc.addMessage("pgrowFormFuncionario", new FacesMessage("Funcionário alterado com sucesso."));
			
		} catch (Exception e) {
			labelBtnModalEnd = "Consultar Endereço";
			styleDisplayBtnFormFuncionarioCadastrar = "none";
			styleDisplayBtnFormFuncionarioAlterar = "block";
			
			styleDisplayBtnFormEnderecoCadastrar = "none";
			styleDisplayBtnFormEnderecoAlterar = "block";
			fc.addMessage("pgrowFormFuncionario", new FacesMessage("Ocorreu um erro interno ao alterar o Funcionário."));
			e.printStackTrace();
		}
	}
	
	
	
	public void cadastrarEndereco(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			enderecoService = new EnderecoServiceImpl();
			enderecoService.inserir(funcionario);
			flagCadastroEndereco = false;
			styleDisplayBtnFormEnderecoCadastrar = "none";
			styleDisplayBtnFormEnderecoAlterar = "block";
			labelBtnModalEnd = "Consultar Endereço";
			fc.addMessage("pgrowlBuscaCep", new FacesMessage("Endereço cadastrado com sucesso."));
		} catch (Exception e) {
			styleDisplayBtnFormEnderecoCadastrar = "block";
			styleDisplayBtnFormEnderecoAlterar = "none";
			e.printStackTrace();
			fc.addMessage("pgrowlBuscaCep", new FacesMessage("Ocorreu um erro interno ao cadastrar o endereço."));
		}
	}
	
	public void alterarEndereco(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			enderecoService = new EnderecoServiceImpl();
			enderecoService.alterar(funcionario);
			
			styleDisplayBtnFormEnderecoCadastrar = "none";
			styleDisplayBtnFormEnderecoAlterar = "block";
			labelBtnModalEnd = "Consultar Endereço";
			fc.addMessage("pgrowlFormEnd", new FacesMessage("Endereço alterado com sucesso."));
			
		} catch (Exception e) {
			styleDisplayBtnFormEnderecoCadastrar = "none";
			styleDisplayBtnFormEnderecoAlterar = "block";
			e.printStackTrace();
			fc.addMessage("pgrowlFormEnd", new FacesMessage("Ocorreu um erro interno ao alterar o endereço."));
		}
	}
	
	public void deleterFuncionario(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			enderecoService = new EnderecoServiceImpl();
			enderecoService.deletar(funcionario);
			funcionarioService.deletar(funcionario);
			fc.addMessage("pgrowFormFuncionario", new FacesMessage("Funcionário excluído com sucesso."));
			
		} catch (Exception e) {
			e.printStackTrace();
			fc.addMessage("pgrowFormFuncionario", new FacesMessage("Ocorreu um erro interno ao excluir o Funcionário."));
		}
	}
	
	public void buscarCep(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			if(!new BuscaCep().buscarCep(funcionario.getEndereco())){
			fc.addMessage("pgrowlBuscaCep", new FacesMessage("CEP não localizado."));
			}
		} catch (Exception e) {
			fc.addMessage("pgrowlBuscaCep", new FacesMessage("Ocorreu um erro interno ao consultar o CEP."));
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

	public String getLabelBtnModalEnd() {
		return labelBtnModalEnd;
	}

	public void setLabelBtnModalEnd(String labelBtnModalEnd) {
		this.labelBtnModalEnd = labelBtnModalEnd;
	}

	public String getStyleDisplayBtnFormFuncionarioCadastrar() {
		return styleDisplayBtnFormFuncionarioCadastrar;
	}

	public void setStyleDisplayBtnFormFuncionarioCadastrar(String styleDisplayBtnFormFuncionarioCadastrar) {
		this.styleDisplayBtnFormFuncionarioCadastrar = styleDisplayBtnFormFuncionarioCadastrar;
	}

	public String getStyleDisplayBtnFormFuncionarioAlterar() {
		return styleDisplayBtnFormFuncionarioAlterar;
	}

	public void setStyleDisplayBtnFormFuncionarioAlterar(String styleDisplayBtnFormFuncionarioAlterar) {
		this.styleDisplayBtnFormFuncionarioAlterar = styleDisplayBtnFormFuncionarioAlterar;
	}

	public String getStyleDisplayBtnFormEnderecoCadastrar() {
		return styleDisplayBtnFormEnderecoCadastrar;
	}

	public void setStyleDisplayBtnFormEnderecoCadastrar(String styleDisplayBtnFormEnderecoCadastrar) {
		this.styleDisplayBtnFormEnderecoCadastrar = styleDisplayBtnFormEnderecoCadastrar;
	}

	public String getStyleDisplayBtnFormEnderecoAlterar() {
		return styleDisplayBtnFormEnderecoAlterar;
	}

	public void setStyleDisplayBtnFormEnderecoAlterar(String styleDisplayBtnFormEnderecoAlterar) {
		this.styleDisplayBtnFormEnderecoAlterar = styleDisplayBtnFormEnderecoAlterar;
	}

	public List<Cargo> getListaCargo() {
		FacesContext fc = FacesContext.getCurrentInstance();
		cargoService = new CargoServiceImp();
		try {
			listaCargo = cargoService.listarCargos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaCargo;
	}

	public void setListaCargo(List<Cargo> listaCargo) {
		this.listaCargo = listaCargo;
	}
	
	

}
