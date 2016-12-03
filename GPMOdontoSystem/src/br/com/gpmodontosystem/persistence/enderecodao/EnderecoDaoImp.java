package br.com.gpmodontosystem.persistence.enderecodao;

import java.sql.Date;
import java.sql.Statement;
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
			stmt = con.prepareStatement(sql.toString() , Statement.RETURN_GENERATED_KEYS);
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
		StringBuilder sql = new StringBuilder();
		sql.append("");
		sql.append("");
		sql.append("");
		
		
		
		
		
		return null;
	}

	@Override
	public void alterar(Endereco e) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Endereco e) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Endereco> listarEndereco() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
