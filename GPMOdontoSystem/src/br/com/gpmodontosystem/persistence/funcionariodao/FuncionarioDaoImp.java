package br.com.gpmodontosystem.persistence.funcionariodao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.gpmodontosystem.model.Funcionario;
import br.com.gpmodontosystem.model.Pessoa;
import br.com.gpmodontosystem.persistence.dao.Dao;
import br.com.gpmodontosystem.type.TypeSexo;

public class FuncionarioDaoImp extends Dao implements IFuncionarioDao{

	@Override
	public void inserir(Funcionario f) throws Exception {
		open();
			String sql = "INSERT INTO FUNCIONARIO (FUN_CODIGO, FUN_MATRICULA) VALUES (?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, f.getIdPessoa());
			stmt.setString(2, f.getMatricula());
			stmt.execute();
			stmt.close();
		close();
	}

	@Override
	public Funcionario consultarPeloId(Funcionario f) throws Exception {
		open();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("PES_CODIGO, PES_CPF, PES_IDENTIDADE, PES_NOME, PES_NASCIMENTO, PES_SEXO, PES_EMAIL,");
		sql.append("PES_DDD, PES_CEL, PES_TEL FROM FUNCIONARIO F ");
		sql.append("INNER JOIN PESSOA P ON F.FUN_CODIGO = P.PES_CODIGO WHERE FUN_CODIGO = ?");
		stmt.setInt(1, f.getIdPessoa());
		stmt = con.prepareStatement(sql.toString());
		rs = stmt.executeQuery();
		Funcionario func = null;
		if(rs.next()){
			func = new Funcionario();
			func.setIdPessoa(rs.getInt("PES_CODIGO"));
			func.setCpf(rs.getString("PES_CPF"));
			func.setIdentidade(rs.getString("PES_IDENTIDADE"));
			func.setNomePessoa(rs.getString("PES_NOME"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("PES_NASCIMENTO"));
			func.setDataNascimento(data);
			func.setSexo(TypeSexo.valueOf("PES_SEXO"));
			func.setEmail(rs.getString("PES_EMAIL"));
			func.setDdd(rs.getString("PES_DDD"));
			func.setCelular(rs.getString("PES_CEL"));
			func.setTelefone(rs.getString("PES_TEL"));
		}
		stmt.close();
		rs.close();
	close();
	return func;
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
		open();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ");
			sql.append("PES_CODIGO, PES_CPF, PES_IDENTIDADE, PES_NOME, PES_NASCIMENTO, PES_SEXO, PES_EMAIL,");
			sql.append("PES_DDD, PES_CEL, PES_TEL FROM FUNCIONARIO F ");
			sql.append("INNER JOIN PESSOA P ON F.FUN_CODIGO = P.PES_CODIGO");
			stmt = con.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			Funcionario func = null;
			List<Funcionario> lst = new ArrayList<>();
			while(rs.next()){
				func = new Funcionario();
				func.setIdPessoa(rs.getInt("PES_CODIGO"));
				func.setCpf(rs.getString("PES_CPF"));
				func.setIdentidade(rs.getString("PES_IDENTIDADE"));
				func.setNomePessoa(rs.getString("PES_NOME"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("PES_NASCIMENTO"));
				func.setDataNascimento(data);
				func.setSexo(TypeSexo.valueOf("PES_SEXO"));
				func.setEmail(rs.getString("PES_EMAIL"));
				func.setDdd(rs.getString("PES_DDD"));
				func.setCelular(rs.getString("PES_CEL"));
				func.setTelefone(rs.getString("PES_TEL"));
				lst.add(func);
			}
			stmt.close();
			rs.close();
	close();
	return lst;
	}

}
