package br.com.gpmodontosystem.service.funcionario;

import java.util.Calendar;
import java.util.List;

import br.com.gpmodontosystem.model.Endereco;
import br.com.gpmodontosystem.model.Funcionario;
import br.com.gpmodontosystem.model.Paciente;
import br.com.gpmodontosystem.persistence.enderecodao.EnderecoDaoImp;
import br.com.gpmodontosystem.persistence.enderecodao.IEnderecoDao;
import br.com.gpmodontosystem.persistence.funcionariodao.FuncionarioDaoImp;
import br.com.gpmodontosystem.persistence.funcionariodao.IFuncionarioDao;
import br.com.gpmodontosystem.persistence.pessoadao.IPessoaDao;
import br.com.gpmodontosystem.persistence.pessoadao.PessoaDaoImp;
import br.com.gpmodontosystem.service.endereco.IEnderecoService;

public class FuncionarioServiceImp implements IFuncionarioService{

	private IFuncionarioDao funcionarioDao;
	private IPessoaDao pessoaDao;
	private IEnderecoDao enderecoDao;
	
	public FuncionarioServiceImp() {
		funcionarioDao = new FuncionarioDaoImp();
	}
	
	@Override
	public void inserir(Funcionario f) throws Exception {
		pessoaDao = new PessoaDaoImp();
		Calendar c = Calendar.getInstance();
		f.setFlagAtivo(0);
		f.setDataCadastro(c);
		f.setDataAtualizacao(c);
		pessoaDao.inserir(f);
		funcionarioDao.inserir(f);
	}

	@Override
	public Funcionario consultarPeloId(Funcionario f) throws Exception {
		enderecoDao = new EnderecoDaoImp();
		Endereco e = new Endereco();
		e.setIdEndereco(f.getIdPessoa());
		e = enderecoDao.consultarPeloId(e);
		f = funcionarioDao.consultarPeloId(f);
		f.setEndereco(e);
		return f;
		
	}
	
	@Override
	public void alterar(Funcionario f) throws Exception {
		pessoaDao = new PessoaDaoImp();
		Calendar c = Calendar.getInstance();
		f.setDataAtualizacao(c);
		pessoaDao.alterar(f);
	}

	@Override
	public void deletar(Funcionario f) throws Exception {
		funcionarioDao.deletar(f);
	}

	@Override
	public List<Funcionario> listarFuncionarios() throws Exception {
		return funcionarioDao.listarFuncionarios();
	}
	

}
