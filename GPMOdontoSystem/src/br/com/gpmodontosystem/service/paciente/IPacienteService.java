package br.com.gpmodontosystem.service.paciente;

import java.util.List;

import br.com.gpmodontosystem.model.Paciente;

public interface IPacienteService {

	public void inserir(Paciente p) throws Exception;
	
	public Paciente consultarPeloId(Paciente p) throws Exception;
	
	public void alterar(Paciente p) throws Exception;
	
	public void deletar(Paciente p) throws Exception;
	
	public List<Paciente> listarPacientes() throws Exception;
	
	public List<Paciente> listarPacientesPeloNomeCpfEmail(String nome) throws Exception;

}
