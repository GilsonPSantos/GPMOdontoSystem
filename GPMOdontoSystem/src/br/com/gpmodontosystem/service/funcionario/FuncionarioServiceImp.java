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
import br.com.gpmodontosystem.persistence.usuariodao.IUsuarioDao;
import br.com.gpmodontosystem.persistence.usuariodao.UsuarioDaoImp;
import br.com.gpmodontosystem.service.endereco.IEnderecoService;
import br.com.gpmodontosystem.service.usuario.IUsuarioService;
import br.com.gpmodontosystem.utilitario.CriptografaSenha;

public class FuncionarioServiceImp implements IFuncionarioService{

	private IFuncionarioDao funcionarioDao;
	private IPessoaDao pessoaDao;
	private IEnderecoDao enderecoDao;
	private IUsuarioDao usuarioDao;
	
	public FuncionarioServiceImp() {
		funcionarioDao = new FuncionarioDaoImp();
		usuarioDao = new UsuarioDaoImp();
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
		
		f.getUsuario().setIdUsuario(f.getIdPessoa());
		f.getUsuario().setLogin(f.getCpf());
		f.getUsuario().setFlagAtivo(0);
		new CriptografaSenha().criptografarSenha(f.getUsuario());
		usuarioDao.inserir(f.getUsuario());
		
		
	}

	@Override
	public Funcionario consultarPeloId(Funcionario f) throws Exception {
		enderecoDao = new EnderecoDaoImp();
		Endereco e = new Endereco();
		e.setIdEndereco(f.getIdPessoa());
		e = enderecoDao.consultarPeloId(e);
		f = funcionarioDao.consultarPeloId(f);
		f.setEndereco(e);
		f.setUsuario(f.getUsuario());
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
		enderecoDao = new EnderecoDaoImp();
		funcionarioDao.deletar(f);
		usuarioDao.deletar(f.getUsuario());
		enderecoDao.deletar(f.getEndereco());
	}

	@Override
	public List<Funcionario> listarFuncionarios() throws Exception {
		return funcionarioDao.listarFuncionarios();
	}
	

}
