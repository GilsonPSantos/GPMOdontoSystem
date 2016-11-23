package br.com.gpmodontosystem.persistence.pessoa;

import java.sql.Date;
import java.sql.Statement;
import java.util.Calendar;

import br.com.gpmodontosystem.model.Pessoa;
import br.com.gpmodontosystem.persistence.dao.Dao;

public class PessoaDaoImp extends Dao implements IPessoaDao {
	
	java.sql.Date dataSql = null;
	
	@Override
	public void inserir(Pessoa p) throws Exception {
		open();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO PESSOA (PES_CPF, PES_IDENTIDADE, PES_NOME, PES_NASCIMENTO, PES_SEXO, PES_EMAIL, )");
			sql.append("PES_DDD, PES_CEL, PES_TEL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, p.getCpf());
			stmt.setString(2, p.getIdentidade());
			stmt.setString(3, p.getNomePessoa());
			dataSql = new Date(p.getDataNascimento().getTime().getTime());
			stmt.setDate(4, dataSql);
			stmt.setString(5, p.getSexo());
			stmt.setString(6, p.getEmail());
			stmt.setString(7, p.getDdd());
			stmt.setString(8, p.getCelular());
			stmt.setString(9, p.getTelefone());
			rs = stmt.executeQuery();
			p.setIdPessoa(rs.getInt(1));
			stmt.close();
		close();
	}

	@Override
	public Pessoa consultarPeloId(Pessoa p) throws Exception {
		open();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ");
			sql.append("PES_CODIGO, PES_CPF, PES_IDENTIDADE, PES_NOME, PES_NASCIMENTO, PES_SEXO, PES_EMAIL,");
			sql.append("PES_DDD, PES_CEL, PES_TEL FROM PESSOA WHERE PES_CODIGO = ?");
			stmt.setInt(1, p.getIdPessoa());
			stmt = con.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			Pessoa pessoa = null;
			if(rs.next()){
				pessoa = new Pessoa();
				pessoa.setIdPessoa(rs.getInt("PES_CODIGO"));
				pessoa.setCpf(rs.getString("PES_CPF"));
				pessoa.setIdentidade(rs.getString("PES_IDENTIDADE"));
				pessoa.setNomePessoa(rs.getString("PES_NOME"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("PES_NASCIMENTO"));
				pessoa.setDataNascimento(data);
				pessoa.setSexo(rs.getString("PES_SEXO"));
				pessoa.setEmail(rs.getString("PES_EMAIL"));
				pessoa.setDdd(rs.getString("PES_DDD"));
				pessoa.setCelular(rs.getString("PES_CEL"));
				pessoa.setTelefone(rs.getString("PES_TEL"));
			}
			stmt.close();	
		close();
		return pessoa;
	}

	@Override
	public void alterar(Pessoa p) throws Exception {
		open();
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE PESSOA SET PES_CPF = ?, PES_IDENTIDADE = ?, PES_NOME = ?, PES_NASCIMENTO = ?, )");
		sql.append("PES_SEXO = ?, PES_EMAIL = ?, PES_DDD = ?, PES_CEL = ?, PES_TEL = ? ");
		sql.append("WHERE PES_CODIGO = ?");
		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1, p.getCpf());
		stmt.setString(2, p.getIdentidade());
		stmt.setString(3, p.getNomePessoa());
		dataSql = new Date(p.getDataNascimento().getTime().getTime());
		stmt.setDate(4, dataSql);
		stmt.setString(5, p.getSexo());
		stmt.setString(6, p.getEmail());
		stmt.setString(7, p.getDdd());
		stmt.setString(8, p.getCelular());
		stmt.setString(9, p.getTelefone());
		stmt.setInt(10, p.getIdPessoa());
		stmt.execute();
		stmt.close();
	close();
	}

	@Override
	public void deletar(Pessoa p) throws Exception {
		open();
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM PESSOA WHERE PES_CODIGO = ?)");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, p.getIdPessoa());
			stmt.execute();
			stmt.close();
		close();
	}

}
