package br.com.gpmodontosystem.service.endereco;

import br.com.gpmodontosystem.model.Endereco;
import br.com.gpmodontosystem.model.Pessoa;

public interface IEnderecoService {
	
	public void inserir(Pessoa p) throws Exception;
	
	public Endereco consultarPeloId(Pessoa p) throws Exception;
	
	public void alterar(Pessoa p) throws Exception;
	
	public void deletar(Pessoa p) throws Exception;

}
