package br.com.gpmodontosystem.persistence.pacientedao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.gpmodontosystem.model.Paciente;
import br.com.gpmodontosystem.persistence.dao.DaoImpl;

public class PacienteDaoImp extends DaoImpl implements IPacienteDao {
	
	java.sql.Date dataSql = null;
	
//ver melhor esse m�todo, pois paciente � uma pessoa e no final nem precisa dos atributos dele, basta uma classe sem
	//ID pq o ID � da classe pessoa
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
		
		return null;
	}
	
	

@Override
public List<Paciente> listarPacientesPeloNomeCpfEmail(String nome) throws Exception {
	open();
	StringBuilder sql = new StringBuilder();
	sql.append("SELECT PAC_CODIGO, PES_NOME FROM PACIENTE PAC ");
	sql.append("INNER JOIN PESSOA PES ON PAC.PAC_CODIGO = PES.PES_CODIGO WHERE PES_NOME LIKE ? OR PES_CPF LIKE ? OR PES_EMAIL LIKE ?");	
	
	stmt = con.prepareStatement(sql.toString());
	stmt.setString(1, nome + "%");
	stmt.setString(2, nome+ "%");
	stmt.setString(3, nome+ "%");
	rs = stmt.executeQuery();
	Paciente pc = null;
	List<Paciente> lst = new ArrayList<>();
	while(rs.next()){
		pc = new Paciente();
		pc.setNomePessoa(rs.getString("PES_NOME"));
		pc.setIdPessoa(rs.getInt("PAC_CODIGO"));
		lst.add(pc);
	}
	if(lst.isEmpty()){
		pc = new Paciente();
		lst.add(pc);
	}
	stmt.close();
	rs.close();
	close();
	return lst;
}

	
	
	

public static void main(String[] args) {
	Calendar c = Calendar.getInstance();
	java.sql.Date data = new java.sql.Date(c.getTime().getTime());
	System.out.println(data);
}

}
