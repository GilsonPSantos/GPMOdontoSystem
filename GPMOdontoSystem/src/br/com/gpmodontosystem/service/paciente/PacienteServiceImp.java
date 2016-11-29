package br.com.gpmodontosystem.service.paciente;

import java.util.Calendar;
import java.util.List;

import br.com.gpmodontosystem.model.Paciente;
import br.com.gpmodontosystem.persistence.pacientedao.IPacienteDao;
import br.com.gpmodontosystem.persistence.pacientedao.PacienteDaoImp;
import br.com.gpmodontosystem.persistence.pessoadao.IPessoaDao;
import br.com.gpmodontosystem.persistence.pessoadao.PessoaDaoImp;

public class PacienteServiceImp implements IPacienteService{

	private IPacienteDao pacienteDao;
	private IPessoaDao pessoaDao;
	
	public PacienteServiceImp() {
		pacienteDao = new PacienteDaoImp();
		pessoaDao = new PessoaDaoImp();
	}
	
	public void inserir(Paciente p) throws Exception {
		Calendar c = Calendar.getInstance();
		p.setFlagAtivo(0);
		p.setDataCadastro(c);
		p.setDataAtualizacao(c);
		pessoaDao.inserir(p);
		pacienteDao.inserir(p);
	}

	public Paciente consultarPeloId(Paciente p) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void alterar(Paciente p) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void deletar(Paciente p) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Paciente> listarPacientes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> listarPacientesPeloNomeCpfEmail(Paciente p) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
