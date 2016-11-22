package br.com.gpmodontosystem.persistence.enderecodao;

import java.util.List;

import br.com.gpmodontosystem.model.Endereco;
import br.com.gpmodontosystem.persistence.dao.ICrudDao;

public interface IEnderecoDao extends ICrudDao<Endereco> {
	
	public List<Endereco> listarEndereco() throws Exception;

}
