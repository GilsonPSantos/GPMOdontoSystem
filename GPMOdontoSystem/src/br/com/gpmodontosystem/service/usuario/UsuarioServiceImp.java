package br.com.gpmodontosystem.service.usuario;

import br.com.gpmodontosystem.model.Usuario;
import br.com.gpmodontosystem.persistence.usuariodao.IUsuarioDao;
import br.com.gpmodontosystem.persistence.usuariodao.UsuarioDaoImp;

public class UsuarioServiceImp implements IUsuarioService{

	private IUsuarioDao usuarioDao;
	
	public UsuarioServiceImp() {
		usuarioDao = new UsuarioDaoImp();
	}
	
	@Override
	public void inserir(Usuario u) throws Exception {
		usuarioDao.inserir(u);
	}

	@Override
	public Usuario consultarPeloId(Usuario u) throws Exception {
		return usuarioDao.consultarPeloId(u);
	}

	@Override
	public void alterar(Usuario u) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Usuario u) throws Exception {
		usuarioDao.deletar(u);
	}

}
