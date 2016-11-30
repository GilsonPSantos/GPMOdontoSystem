package br.com.gpmodontosystem.service.funcionario;

import java.util.Calendar;
import java.util.List;

import br.com.gpmodontosystem.model.Funcionario;
import br.com.gpmodontosystem.persistence.funcionariodao.FuncionarioDaoImp;
import br.com.gpmodontosystem.persistence.funcionariodao.IFuncionarioDao;
import br.com.gpmodontosystem.persistence.pessoadao.IPessoaDao;
import br.com.gpmodontosystem.persistence.pessoadao.PessoaDaoImp;

public class FuncionarioServiceImp implements IFuncionarioService{

	private IFuncionarioDao funcionarioDao;
	private IPessoaDao pessoaDao;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Funcionario f) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Funcionario f) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Funcionario> listarFuncionarios() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
