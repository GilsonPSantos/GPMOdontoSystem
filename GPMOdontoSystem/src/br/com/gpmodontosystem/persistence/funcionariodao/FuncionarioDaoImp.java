package br.com.gpmodontosystem.persistence.funcionariodao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.gpmodontosystem.model.Cargo;
import br.com.gpmodontosystem.model.Funcionario;
import br.com.gpmodontosystem.persistence.dao.Dao;
import br.com.gpmodontosystem.type.TypeSexo;

public class FuncionarioDaoImp extends Dao implements IFuncionarioDao{

	@Override
	public void inserir(Funcionario f) throws Exception {
		open();
			String sql = "INSERT INTO FUNCIONARIO (FUN_CODIGO, FUN_MATRICULA, CARGO_CAR_CODIGO) VALUES (?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, f.getIdPessoa());
			stmt.setString(2, f.getMatricula());
			stmt.setInt(3, f.getCargo().getIdCargo());
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
		sql.append("PES_DDD, PES_CEL, PES_TEL, PES_ATIVO, PES_CADASTRO, PES_ATUALIZACAO, C.CAR_CODIGO, C.CAR_FUNCAO FROM FUNCIONARIO F ");
		sql.append("INNER JOIN PESSOA P ON F.FUN_CODIGO = P.PES_CODIGO ");
		sql.append("INNER JOIN CARGO C ON C.CAR_CODIGO = F.CARGO_CAR_CODIGO WHERE FUN_CODIGO = ?");
		stmt = con.prepareStatement(sql.toString());
		stmt.setInt(1, f.getIdPessoa());
		rs = stmt.executeQuery();
		Funcionario func = null;
		if(rs.next()){
			func = new Funcionario();
			func.setCargo(new Cargo());
			func.setIdPessoa(rs.getInt("PES_CODIGO"));
			func.setCpf(rs.getString("PES_CPF"));
			func.setIdentidade(rs.getString("PES_IDENTIDADE"));
			func.setNomePessoa(rs.getString("PES_NOME"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("PES_NASCIMENTO"));
			func.setDataNascimento(data);
			func.setSexo(TypeSexo.valueOf(rs.getString("PES_SEXO")));
			func.setEmail(rs.getString("PES_EMAIL"));
			func.setDdd(rs.getString("PES_DDD"));
			func.setCelular(rs.getString("PES_CEL"));
			func.setTelefone(rs.getString("PES_TEL"));
			func.setFlagAtivo(rs.getInt("PES_ATIVO"));
			data = Calendar.getInstance();
			data.setTime(rs.getDate("PES_CADASTRO"));
			func.setDataCadastro(data);
			data = Calendar.getInstance();
			data.setTime(rs.getDate("PES_ATUALIZACAO"));
			func.setDataAtualizacao(data);
			func.getCargo().setIdCargo(rs.getInt("CAR_CODIGO"));
			func.getCargo().setNomeCargo(rs.getString("CAR_FUNCAO"));
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
		open();
			String sql = "UPDATE PESSOA SET PES_ATIVO = 1 WHERE PES_CODIGO = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, f.getIdPessoa());
			stmt.execute();
			stmt.close();
		close();
	}

	@Override
	public List<Funcionario> listarFuncionarios() throws Exception {
		open();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ");
			sql.append("PES_CODIGO, PES_CPF, PES_IDENTIDADE, PES_NOME, PES_NASCIMENTO, PES_SEXO, PES_EMAIL,");
			sql.append("PES_DDD, PES_CEL, PES_TEL, C.CAR_CODIGO, C.CAR_FUNCAO FROM FUNCIONARIO F ");
			sql.append("INNER JOIN PESSOA P ON F.FUN_CODIGO = P.PES_CODIGO ");
			sql.append("INNER JOIN CARGO C ON C.CAR_CODIGO = F.CARGO_CAR_CODIGO WHERE P.PES_ATIVO = 0");
			stmt = con.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			Funcionario func = null;
			List<Funcionario> lst = new ArrayList<>();
			while(rs.next()){
				func = new Funcionario();
				func.setCargo(new Cargo());
				func.setIdPessoa(rs.getInt("PES_CODIGO"));
				func.setCpf(rs.getString("PES_CPF"));
				func.setIdentidade(rs.getString("PES_IDENTIDADE"));
				func.setNomePessoa(rs.getString("PES_NOME"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("PES_NASCIMENTO"));
				func.setDataNascimento(data);
				func.setSexo(TypeSexo.valueOf(rs.getString("PES_SEXO")));
				func.setEmail(rs.getString("PES_EMAIL"));
				func.setDdd(rs.getString("PES_DDD"));
				func.setCelular(rs.getString("PES_CEL"));
				func.setTelefone(rs.getString("PES_TEL"));
				func.getCargo().setIdCargo(rs.getInt("CAR_CODIGO"));
				func.getCargo().setNomeCargo(rs.getString("CAR_FUNCAO"));
				lst.add(func);
			}
			stmt.close();
			rs.close();
	close();
	return lst;
	}

}
