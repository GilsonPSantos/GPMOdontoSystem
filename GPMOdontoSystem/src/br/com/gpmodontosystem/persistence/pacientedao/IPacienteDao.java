package br.com.gpmodontosystem.persistence.pacientedao;

import java.util.List;

import br.com.gpmodontosystem.model.Paciente;
import br.com.gpmodontosystem.persistence.dao.ICrudDao;

public interface IPacienteDao extends ICrudDao {
	
	public List<Paciente> listarPacientes() throws Exception;

}
