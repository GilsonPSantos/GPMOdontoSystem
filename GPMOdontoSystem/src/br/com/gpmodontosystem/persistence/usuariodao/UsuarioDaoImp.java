package br.com.gpmodontosystem.persistence.usuariodao;

import br.com.gpmodontosystem.model.Usuario;
import br.com.gpmodontosystem.persistence.dao.Dao;

public class UsuarioDaoImp extends Dao implements IUsuarioDao {

	@Override
	public void inserir(Usuario u) throws Exception {
		open();
			String sql = "INSERT INTO USUARIO (US_CODIGO, US_NOME, US_SENHA, US_NIVEL) VALUES (?, ?, ?, ?) ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, u.getIdUsuario());
			stmt.setString(2, u.getLogin());
			stmt.setString(3, u.getSenha());
			stmt.setString(4, u.getNivelPermissao());
			stmt.execute();
			stmt.close();
		close();
	}

	@Override
	public Usuario consultarPeloId(Usuario u) throws Exception {
		open();
			String sql = " SELECT US_CODIGO, US_NOME, US_SENHA, US_NIVEL, US_ATIVO FROM USUARIO WHERE US_CODIGO = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, u.getIdUsuario());
			rs = stmt.executeQuery();
			Usuario usu = null;
			if(rs.next()){
				usu = new Usuario();
				usu.setIdUsuario(rs.getInt("US_CODIGO"));
				usu.setLogin(rs.getString("US_NOME"));
				usu.setSenha(rs.getString("US_SENHA"));
				usu.setNivelPermissao(rs.getString("US_NIVEL"));
				usu.setFlagAtivo(rs.getInt("US_ATIVO"));
			}
			stmt.close();
			rs.close();
		close();
		return usu;
	}

	@Override
	public void alterar(Usuario u) throws Exception {
		open();
			String sql = "UPDATE USUARIO SET US_NOME = ?, US_SENHA = ?, US_NIVEL = ? WHERE US_CODIGO = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, u.getLogin());
			stmt.setString(2, u.getSenha());
			stmt.setString(3, u.getNivelPermissao());
			stmt.setInt(4, u.getIdUsuario());
			stmt.execute();
			stmt.close();
		close();
	}

	@Override
	public void deletar(Usuario u) throws Exception {
		open();
			String sql = "UPDATE USUARIO SET US_ATIVO = 1 WHERE US_CODIGO = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, u.getIdUsuario());
			stmt.execute();
			stmt.close();
		close();
		
	}

}
