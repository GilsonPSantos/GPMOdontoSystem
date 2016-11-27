package br.com.gpmodontosystem.persistence.pacientedao;

import java.util.Calendar;
import java.util.List;

import br.com.gpmodontosystem.model.Paciente;
import br.com.gpmodontosystem.persistence.dao.Dao;

public class PacienteDaoImp extends Dao implements IPacienteDao {
	
	java.sql.Date dataSql = null;
	
//ver melhor esse método, pois paciente é uma pessoa e no final nem precisa dos atributos dele, basta uma classe sem
	//ID pq o ID é da classe pessoa
	@Override
	public void inserir(Paciente p) throws Exception {
		open();
		String sql = "INSERT INTO PACIENTE (PAC_CODIGO) VALUES (?)";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, p.getIdPessoa());
		stmt.execute();
		stmt.close();
	close();
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

public static void main(String[] args) {
	Calendar c = Calendar.getInstance();
	java.sql.Date data = new java.sql.Date(c.getTime().getTime());
	System.out.println(data);
}

}
