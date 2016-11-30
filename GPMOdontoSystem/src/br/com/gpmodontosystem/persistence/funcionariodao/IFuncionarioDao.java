package br.com.gpmodontosystem.persistence.funcionariodao;

import java.util.List;

import br.com.gpmodontosystem.model.Funcionario;
import br.com.gpmodontosystem.persistence.dao.ICrudDao;

public interface IFuncionarioDao extends ICrudDao<Funcionario>{
	
	public List<Funcionario> listarFuncionarios() throws Exception;
		

}
