package br.com.gpmodontosystem.service.paciente;

import java.util.List;

import br.com.gpmodontosystem.model.Paciente;
import br.com.gpmodontosystem.persistence.pacientedao.IPacienteDao;
import br.com.gpmodontosystem.persistence.pacientedao.PacienteDaoImp;

public class PacienteServiceImp implements IPacienteService{

	private IPacienteDao pacienteDao;
	
	public PacienteServiceImp() {
		pacienteDao = new PacienteDaoImp();
	}
	
	@Override
	public void inserir(Paciente p) throws Exception {
		pacienteDao.inserir(p);
	}

	@Override
	public Paciente consultarPeloId(Paciente p) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Paciente p) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Paciente p) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Paciente> listarPacientes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
