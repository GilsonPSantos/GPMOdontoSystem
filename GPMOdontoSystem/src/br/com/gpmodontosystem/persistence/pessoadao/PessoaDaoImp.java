package br.com.gpmodontosystem.persistence.pessoadao;

import java.sql.Date;
import java.sql.Statement;
import java.util.Calendar;

import br.com.gpmodontosystem.model.Pessoa;
import br.com.gpmodontosystem.persistence.dao.DaoImpl;
import br.com.gpmodontosystem.type.TypeSexo;

public class PessoaDaoImp extends DaoImpl implements IPessoaDao {
	
	java.sql.Date dataSql = null;
	
	@Override
	public void inserir(Pessoa p) throws Exception {
		open();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO PESSOA (PES_CPF, PES_IDENTIDADE, PES_NOME, PES_NASCIMENTO, PES_SEXO, PES_EMAIL,");
			sql.append("PES_DDD, PES_CEL, PES_TEL, PES_ATIVO, PES_CADASTRO, PES_ATUALIZACAO) ");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, p.getCpf());
			stmt.setString(2, p.getIdentidade());
			stmt.setString(3, p.getNomePessoa());
			dataSql = new Date(p.getDataNascimento().getTimeInMillis());
			stmt.setDate(4, dataSql);
			stmt.setString(5, p.getSexo().toString());
			stmt.setString(6, p.getEmail());
			stmt.setString(7, p.getDdd());
			stmt.setString(8, p.getCelular());
			stmt.setString(9, p.getTelefone());
			stmt.setInt(10, p.getFlagAtivo());
			dataSql = new Date(p.getDataCadastro().getTimeInMillis());
			stmt.setDate(11, dataSql);
			dataSql = new Date(p.getDataAtualizacao().getTimeInMillis());
			stmt.setDate(12, dataSql);
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			if(rs.next()){
				p.setIdPessoa(rs.getInt(1));
			}
			stmt.close();
			rs.close();
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
				pessoa.setSexo(TypeSexo.valueOf("PES_SEXO"));
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
		sql.append("UPDATE PESSOA SET PES_CPF = ?, PES_IDENTIDADE = ?, PES_NOME = ?, PES_NASCIMENTO = ?, ");
		sql.append("PES_SEXO = ?, PES_EMAIL = ?, PES_DDD = ?, PES_CEL = ?, PES_TEL = ?, PES_ATUALIZACAO = ? ");
		sql.append("WHERE PES_CODIGO = ?");
		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1, p.getCpf());
		stmt.setString(2, p.getIdentidade());
		stmt.setString(3, p.getNomePessoa());
		dataSql = new Date(p.getDataNascimento().getTime().getTime());
		stmt.setDate(4, dataSql);
		stmt.setString(5, p.getSexo().getSexo());
		stmt.setString(6, p.getEmail());
		stmt.setString(7, p.getDdd());
		stmt.setString(8, p.getCelular());
		stmt.setString(9, p.getTelefone());
		dataSql = new Date(p.getDataAtualizacao().getTimeInMillis());
		stmt.setDate(10, dataSql);
		stmt.setInt(11, p.getIdPessoa());
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

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		Pessoa p = new Pessoa(null,"123","456","Pedro",c,c,c,TypeSexo.M,"p@gmail","21","098","980",1);
		try {
			IPessoaDao pd = new PessoaDaoImp();
			pd.inserir(p);
			System.out.println("dados gravados...");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
