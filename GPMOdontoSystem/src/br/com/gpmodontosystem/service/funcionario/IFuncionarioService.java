package br.com.gpmodontosystem.service.funcionario;

import java.util.List;

import br.com.gpmodontosystem.model.Funcionario;

public interface IFuncionarioService {
	
public void inserir(Funcionario f) throws Exception;
	
	public Funcionario consultarPeloId(Funcionario f) throws Exception;
	
	public void alterar(Funcionario f) throws Exception;
	
	public void deletar(Funcionario f) throws Exception;
	
	public List<Funcionario> listarFuncionarios() throws Exception;


}
