package br.com.gpmodontosystem.persistence.enderecodao;

import java.sql.Date;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;

import br.com.gpmodontosystem.model.Endereco;
import br.com.gpmodontosystem.persistence.dao.Dao;

public class EnderecoDaoImp extends Dao implements IEnderecoDao {

	java.sql.Date dataSql = null;
	
	@Override
	public void inserir(Endereco e) throws Exception {
		open();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ENDERECO (END_CODIGO,END_CEP, END_LOGRADOURO, END_NUMERO, END_COMPLEMENTO, ");
			sql.append("END_BAIRRO, END_CIDADE, END_UF, END_ATIVO, END_CADASTRO, END_ATUALIZACAO) ");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, e.getIdEndereco());
			stmt.setString(2, e.getCep());
			stmt.setString(3, e.getLogradouro());
			stmt.setString(4, e.getNumero());
			stmt.setString(5, e.getComplemento());
			stmt.setString(6, e.getBairro());
			stmt.setString(7, e.getCidade());
			stmt.setString(8, e.getUf());
			stmt.setInt(9, e.getFlagAtivo());
			stmt.setDate(10, new Date(e.getDataCadastro().getTimeInMillis()));
			stmt.setDate(11, new Date(e.getDataAtualizacao().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		close();
	}

	@Override
	public Endereco consultarPeloId(Endereco e) throws Exception {
		open();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT END_CODIGO, END_CEP, END_LOGRADOURO, END_NUMERO, END_COMPLEMENTO, END_BAIRRO, END_CIDADE, END_UF, ");
		sql.append("END_ATIVO, END_CADASTRO, END_ATUALIZACAO ");
		sql.append("FROM ENDERECO WHERE END_CODIGO = ? AND END_ATIVO = 0");
		stmt = con.prepareStatement(sql.toString());
		stmt.setInt(1, e.getIdEndereco());
		rs = stmt.executeQuery();
		Endereco end = null;
		if(rs.next()){
			end = new Endereco();
			end.setIdEndereco(rs.getInt("END_CODIGO"));
			end.setCep(rs.getString("END_CEP"));
			end.setLogradouro(rs.getString("END_LOGRADOURO"));
			end.setNumero(rs.getString("END_NUMERO"));
			end.setComplemento(rs.getString("END_COMPLEMENTO"));
			end.setBairro(rs.getString("END_BAIRRO"));
			end.setCidade(rs.getString("END_CIDADE"));
			end.setUf(rs.getString("END_UF"));
			end.setFlagAtivo(rs.getInt("END_ATIVO"));
			Calendar c = Calendar.getInstance();
			c.setTime(rs.getDate("END_CADASTRO"));
			end.setDataCadastro(c);
			c = Calendar.getInstance();
			c.setTime(rs.getDate("END_ATUALIZACAO"));
			end.setDataAtualizacao(c);
		}
		stmt.close();
		rs.close();
		close();
		return end;
	}

	@Override
	public void alterar(Endereco e) throws Exception {
		open();
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE ENDERECO SET END_CEP = ?, END_LOGRADOURO = ?, END_NUMERO = ?, END_COMPLEMENTO = ?, ");
			sql.append("END_BAIRRO = ?, END_CIDADE = ?, END_UF = ?, END_ATUALIZACAO = ? ");
			sql.append("WHERE END_CODIGO = ?");
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, e.getCep());
			stmt.setString(2, e.getLogradouro());
			stmt.setString(3, e.getNumero());
			stmt.setString(4, e.getComplemento());
			stmt.setString(5, e.getBairro());
			stmt.setString(6, e.getCidade());
			stmt.setString(7, e.getUf());
			stmt.setDate(8, new Date(e.getDataAtualizacao().getTimeInMillis()));
			stmt.setInt(9, e.getIdEndereco());
			stmt.execute();
			stmt.close();
		close();
	}

	@Override
	public void deletar(Endereco e) throws Exception {
		open();
			String sql = "UPDATE ENDERECO SET END_ATIVO = 1 WHERE END_CODIGO = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, e.getIdEndereco());
			stmt.execute();
			stmt.close();
		close();
		
	}

	@Override
	public List<Endereco> listarEndereco() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
