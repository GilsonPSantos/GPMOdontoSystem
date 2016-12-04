package br.com.gpmodontosystem.service.endereco;

import java.util.Calendar;

import br.com.gpmodontosystem.model.Endereco;
import br.com.gpmodontosystem.model.Pessoa;
import br.com.gpmodontosystem.persistence.enderecodao.EnderecoDaoImp;
import br.com.gpmodontosystem.persistence.enderecodao.IEnderecoDao;

public class EnderecoServiceImpl implements IEnderecoService{

	private IEnderecoDao enderecoDao;
	
	public EnderecoServiceImpl() {
		enderecoDao = new EnderecoDaoImp();
	}
	
	@Override
	public void inserir(Pessoa p) throws Exception {
		Calendar c = Calendar.getInstance();
		p.getEndereco().setFlagAtivo(0);
		p.getEndereco().setIdEndereco(p.getIdPessoa());
		p.getEndereco().setDataAtualizacao(c);
		p.getEndereco().setDataCadastro(c);
		enderecoDao.inserir(p.getEndereco());
	}

	@Override
	public Endereco consultarPeloId(Pessoa p) throws Exception {
		p.getEndereco().setIdEndereco(p.getIdPessoa());
		return enderecoDao.consultarPeloId(p.getEndereco());
	}

	@Override
	public void alterar(Pessoa p) throws Exception {
		Calendar c = Calendar.getInstance();
		p.getEndereco().setDataAtualizacao(c);
		enderecoDao.alterar(p.getEndereco());
	}

	@Override
	public void deletar(Pessoa p) throws Exception {
		enderecoDao.deletar(p.getEndereco());
	}

}
