package br.com.gpmodontosystem.utilitario;

import org.lavieri.modelutil.cep.WebServiceCep;

import br.com.gpmodontosystem.model.Endereco;

public class BuscaCep {
	
	public boolean buscarCep(Endereco e) throws Exception{
		WebServiceCep busca = WebServiceCep.searchCep(e.getCep());
		if(busca.wasSuccessful()){
			e.setLogradouro(busca.getLogradouroFull());//full traz o tipo do logradouro
			e.setBairro(busca.getBairro());
			e.setCidade(busca.getCidade());
			e.setUf(busca.getUf());
			return true;
		}else{
			e = new Endereco();
			return false;
		}
	}
	
	

}
